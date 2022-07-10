package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 景区附近的酒店关系表(Nearly)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:44:22
 */
public class Nearly implements Serializable {
    private static final long serialVersionUID = 615663906366702309L;
    
    private Long nearlyId;
    
    private Long scenicAreaId;
    
    private Long hotelId;


    public Long getNearlyId() {
        return nearlyId;
    }

    public void setNearlyId(Long nearlyId) {
        this.nearlyId = nearlyId;
    }

    public Long getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(Long scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

}

