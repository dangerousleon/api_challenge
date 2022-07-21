package com.challenge.app.coupon.common.response.external;

import java.util.ArrayList;
import java.util.Date;

public class Item{
    public String id;
    public String site_id;
    public String title;
    public Object subtitle;
    public int seller_id;
    public String category_id;
    public Object official_store_id;
    public int price;
    public int base_price;
    public Object original_price;
    public String currency_id;
    public int initial_quantity;
    public int available_quantity;
    public int sold_quantity;
    public ArrayList<Object> sale_terms;
    public String buying_mode;
    public String listing_type_id;
    public Date start_time;
    public Date stop_time;
    public String condition;
    public String permalink;
    public String thumbnail_id;
    public String thumbnail;
    public String secure_thumbnail;

    public Object video_id;
    public ArrayList<Object> descriptions;
    public boolean accepts_mercadopago;
    public ArrayList<Object> non_mercado_pago_payment_methods;

    public String international_delivery_mode;

    public Object seller_contact;

    public ArrayList<Object> coverage_areas;

    public ArrayList<Object> warnings;
    public String listing_source;

    public String status;
    public ArrayList<Object> sub_status;
    public ArrayList<String> tags;
    public Object warranty;
    public Object catalog_product_id;
    public String domain_id;
    public Object parent_item_id;
    public Object differential_pricing;
    public ArrayList<Object> deal_ids;
    public boolean automatic_relist;
    public Date date_created;
    public Date last_updated;
    public double health;
    public boolean catalog_listing;
    public ArrayList<String> channels;
}