package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 订单实体表(RoomOrder)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:45:03
 */
public class RoomOrder implements Serializable {
    private static final long serialVersionUID = -62708453945825385L;
    
    private Long orderId;
    
    private String orderDescription;
    
    private Long visitorId;
    
    private Long hotelId;
    
    private Integer result;

    private float stars;

    private String orderTime;

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }




    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

}

