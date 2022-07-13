package com.example.Klein.entity;

import lombok.Data;

@Data
public class PageSendMessage {

    private Long entertainmentId;

    private Long userId;

    private int currentPage;

    private int pageSize;

}
