package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 酒店实体表(Hotel)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:42:44
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 352243721067075739L;
    
    private Long hotelId;
    
    private String hotelName;
    
    private Integer starLevel;
    
    private String phoneNumber;
    
    private String address;
    
    private String price;
    
    private String icon;

    private float stars;
    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }




    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}

