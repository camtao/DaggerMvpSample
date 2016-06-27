package com.lianqi.union.daggermvpsample.bean;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/6/27.
 */
public class PhoneLocationBean {

    /**
     * phone : 13316441770
     * prefix : 1331644
     * supplier : 电信
     * province : 广东
     * city : 深圳
     * suit : 133卡
     */

    private String phone;
    private String prefix;
    private String supplier;
    private String province;
    private String city;
    private String suit;

    public static PhoneLocationBean objectFromData(String str) {

        return new Gson().fromJson(str, PhoneLocationBean.class);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
