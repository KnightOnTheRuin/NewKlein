package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 酒店实体表(Hotel)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:42:44
 */
public class NewHotel implements Serializable {

    public NewHotel(Hotel hotel)
    {
        this.hotelId=hotel.getHotelId();
        this.address=hotel.getAddress();
        this.hotelName=hotel.getHotelName();
        this.icon=hotel.getIcon();
        this.starLevel=hotel.getStarLevel();
        this.phoneNumber=hotel.getPhoneNumber();

        String str=hotel.getPrice();

        String []spiltString=str.split(",");
        this.score=spiltString[0];
        this.lowestPrice=Integer.parseInt(spiltString[1]);

    }
    private static final long serialVersionUID = 352243721067075739L;

    private Long hotelId;

    private String hotelName;

    private Integer starLevel;

    private String phoneNumber;

    private String address;

    private String icon;

    private int lowestPrice;

    private  String score;


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
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


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
