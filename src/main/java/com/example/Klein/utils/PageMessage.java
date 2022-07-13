package com.example.Klein.utils;

import com.example.Klein.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class PageMessage {
    private List<Hotel> hotelPageList;

    private List<Entertainment> entertainmentPageList;

    private List<GuestRoom> guestRoomPageList;

    private List<Performance> performancePageList;

    private List<RoomOrder> roomOrderPageList;

    private  List<ScenicArea> scenicAreaPageList;

    private List<User> userList;

    private List<Evaluation> evaluationList;

    private int totalResult;

    private int totalPage;

    private int total;

}
