package com.king.togi.ggock.model;

/**
 * Created by Tacademy on 2017-08-03.
 */

public class ItemModel
{
    String shopName;
    String poster;

    public ItemModel() {
    }

    public ItemModel(String shopName, String poster) {
        this.shopName = shopName;
        this.poster = poster;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
