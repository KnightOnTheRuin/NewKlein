package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 客房实体表(GuestRoom)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:42:22
 */
public class GuestRoom implements Serializable {
    private static final long serialVersionUID = 479531015567223171L;
    
    private Long roomId;
    
    private String roomType;
    
    private String roomEnvironment;
    
    private String icon;
    
    private String price;
    
    private Integer isFull;
    
    private Long hotelId;


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomEnvironment() {
        return roomEnvironment;
    }

    public void setRoomEnvironment(String roomEnvironment) {
        this.roomEnvironment = roomEnvironment;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getIsFull() {
        return isFull;
    }

    public void setIsFull(Integer isFull) {
        this.isFull = isFull;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

}

