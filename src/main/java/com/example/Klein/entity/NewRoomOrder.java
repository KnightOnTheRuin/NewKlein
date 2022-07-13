package com.example.Klein.entity;

import lombok.Data;

@Data
public class NewRoomOrder {
    private static final long serialVersionUID = -62708453945825385L;

    public NewRoomOrder(){}

    public NewRoomOrder(RoomOrder roomOrder){
        this.orderId=roomOrder.getOrderId();
        this.hotelId=roomOrder.getHotelId();
        this.orderDescription=roomOrder.getOrderDescription();
        this.orderTime=roomOrder.getOrderTime();
        this.result=roomOrder.getResult();
        this.visitorId=roomOrder.getVisitorId();
        this.stars=roomOrder.getStars();

        String str=this.orderDescription;

        String []spiltString=str.split(",");
        this.orderDescription1=spiltString[0];
        this.orderDescription2=spiltString[1];

    }

    private Long orderId;

    private String orderDescription;

    private Long visitorId;

    private Long hotelId;

    private Integer result;

    private float stars;

    private String orderTime;

    private String orderDescription1;

    private String orderDescription2;

    private String hotelName;
}
