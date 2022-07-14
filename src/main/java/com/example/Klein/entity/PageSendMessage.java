package com.example.Klein.entity;

import lombok.Data;

@Data
public class PageSendMessage {

    private Long entertainmentId;

    private Long userId;

    private String hotelDimName;

    private String scenicAreaDimName;

    private String performanceDimName;

    private String entertainmentDimName;

    private int currentPage;

    private int pageSize;

}
