package com.example.Klein.entity;

import lombok.Data;

@Data
public class NewRoom {
    private static final long serialVersionUID = 479531015567223171L;

    public NewRoom(GuestRoom guestRoom){
        this.hotelId=guestRoom.getHotelId();
        this.icon=guestRoom.getIcon();
        this.isFull=guestRoom.getIsFull();
        this.price=guestRoom.getPrice();
        this.roomId=guestRoom.getRoomId();
        this.roomType=guestRoom.getRoomType();
        this.EnvironmentDescription=guestRoom.getRoomEnvironment();
        String tempString=guestRoom.getRoomEnvironment();
        String[] spilt=tempString.split(",");
        System.arraycopy(spilt,0,environment,0,spilt.length);
        this.Arraylength=spilt.length;
    }

    private Long roomId;

    private String roomType;

    private String icon;

    private String price;

    private Integer isFull;

    private Long hotelId;

    private String[] environment={"","","","","","","",""};

    private int Arraylength;


    private String EnvironmentDescription;

}
