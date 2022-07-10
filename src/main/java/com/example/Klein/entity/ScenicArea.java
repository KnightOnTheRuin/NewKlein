package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 景区实体表(ScenicArea)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:45:26
 */
public class ScenicArea implements Serializable {
    private static final long serialVersionUID = 244639337785452020L;
    
    private Long scenicAreaId;
    
    private String scenicAreaName;
    
    private String phoneNumber;
    
    private String icon1;
    
    private String icon2;
    
    private String icon3;
    
    private String description;


    public Long getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(Long scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
    }

    public String getScenicAreaName() {
        return scenicAreaName;
    }

    public void setScenicAreaName(String scenicAreaName) {
        this.scenicAreaName = scenicAreaName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIcon1() {
        return icon1;
    }

    public void setIcon1(String icon1) {
        this.icon1 = icon1;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public String getIcon3() {
        return icon3;
    }

    public void setIcon3(String icon3) {
        this.icon3 = icon3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

