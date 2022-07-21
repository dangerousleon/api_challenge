package com.challenge.app.coupon.client.service;

import com.challenge.app.coupon.common.response.external.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private RestTemplate clientItems;

    @Override
    public Item getItemById(String item_id) {
        return clientItems.getForObject("https://api.mercadolibre.com/items/{item_id}", Item.class, item_id);
    }
}
