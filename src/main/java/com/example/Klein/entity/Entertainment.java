package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 餐饮娱乐实体表(Entertainment)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:41:52
 */
public class Entertainment implements Serializable {
    private static final long serialVersionUID = -38002868120652720L;
    
    private Long entertainmentId;
    
    private String entertainmentName;
    
    private String entertainmentType;
    
    private Long scenicAreaId;
    
    private String icon;
    private String address;

    private String time;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Long getEntertainmentId() {
        return entertainmentId;
    }

    public void setEntertainmentId(Long entertainmentId) {
        this.entertainmentId = entertainmentId;
    }

    public String getEntertainmentName() {
        return entertainmentName;
    }

    public void setEntertainmentName(String entertainmentName) {
        this.entertainmentName = entertainmentName;
    }

    public String getEntertainmentType() {
        return entertainmentType;
    }

    public void setEntertainmentType(String entertainmentType) {
        this.entertainmentType = entertainmentType;
    }

    public Long getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(Long scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}

