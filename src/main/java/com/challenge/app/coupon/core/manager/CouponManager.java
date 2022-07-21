package com.challenge.app.coupon.core.manager;

import com.challenge.app.coupon.client.service.ClientService;
import com.challenge.app.coupon.common.constant.Constant;
import com.challenge.app.coupon.common.dto.CouponRequest;
import com.challenge.app.coupon.common.dto.CouponResponse;
import com.challenge.app.coupon.common.dto.ItemCounting;
import com.challenge.app.coupon.common.exception.ApiException;
import com.challenge.app.coupon.common.response.external.Item;
import com.challenge.app.coupon.domain.model.RegisterItem;
import com.challenge.app.coupon.domain.repository.RegisterItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CouponManager {

    @Autowired
    private ClientService clientService;

    @Autowired
    private RegisterItemRepository registerItemRepository;

    public CouponResponse postCoupon(final CouponRequest request){

        postCouponValidation(request);

        Double amount = request.getAmount();
        Double itemPrice = 0.0;
        Double totalTemp = 0.0;
        Double total = 0.0;
        Integer cont =0;
        List<String> listItemsChoice = new ArrayList<String>();

        //Iteramos la lista que llega en el request
        for (String itemRequest : request.getItem_ids()) {
            cont++;
            // Consultamos con el cliente el Item por cada item_ids
            Item itemClient = clientService.getItemById(itemRequest);
            // Setteamos a una variable el precio del item para no extraerla constantemente del objeto
            itemPrice = Double.parseDouble(String.valueOf(itemClient.price));
                /* Sentencia selectiva si el precio del item es menor al amount y el amount divido por el precio
                 del item es mayor o igual a nuestra constante DIVISIBLE la cual garantiza mayor número de items*/
                if((itemPrice < amount && amount / itemPrice >= Constant.DIVISIBLE)){
                    //Carga totalTemp con la sumativa de itemprice
                    totalTemp+= itemPrice;
                    /* Sí totalTemp es menor o igual que amount asigna a total el valor de totalTemp
                     y carga en listItemsChoice el item_ids */
                    if(totalTemp <= amount) {
                        total = totalTemp;
                        listItemsChoice.add(itemRequest);
                        /* Si el totalTemp es mayor o igual al amount entonces retira el ultimo precio agregado a totalTemp
                        para que siga buscando y agregando items hasta llegar al amount*/
                    }else if (totalTemp >= amount){
                        totalTemp-=itemPrice;
                    }else{
                        totalTemp-=itemPrice;
                    }
                }
                /* Se delimita el request para buscar el precio de los items de esta manera si son mas de N no continua,
                pero retorna el response necesario.*/
                if(cont > Constant.MAX_ITEMS_REQUEST){
                    break;
                }
        }

        registerItems(listItemsChoice);

        return getCouponResponse(listItemsChoice, total);
    }

    private void postCouponValidation(final CouponRequest request){
        if(request.getItem_ids().isEmpty()){
            throw new ApiException("ITEMS NOT FOUND ON REQUEST");
        }
        if(request.getAmount().isNaN() ||  request.getAmount()<= 0){
            throw new ApiException("AMOUNT CAN'T BE NULL OR ZERO");
        }
    }

    private void registerItems(final List<String> listChoiceItems){
        for(String items : listChoiceItems){
            Optional<RegisterItem> item = registerItemRepository.findByItemId(items);
            if (item.isEmpty()){
                RegisterItem itemToRegister = new RegisterItem(items,1L);
                registerItemRepository.save(itemToRegister);
            }else{
                Long count = item.get().getCounting() + 1;
                RegisterItem itemToRegister = new RegisterItem(item.get().getId(),item.get().getItemId(),count);
                registerItemRepository.save(itemToRegister);
            }
        }
    }

    private CouponResponse getCouponResponse(final List<String> listChoiceItems, final Double total){
        CouponResponse response = new CouponResponse(
                listChoiceItems,
                total
        );

        return response;
    }

    public List<ItemCounting> getCouponStats(){
        List <RegisterItem> listRegisterItems = registerItemRepository.getRegisterItemOrderByCountingDesc();
        List<ItemCounting> listCouponStats = listRegisterItems.stream().map(registerItem ->
                new ItemCounting(
                        registerItem.getItemId(),
                        registerItem.getCounting()
                )
        ).collect(Collectors.toList());
        return listCouponStats;
    }
}
