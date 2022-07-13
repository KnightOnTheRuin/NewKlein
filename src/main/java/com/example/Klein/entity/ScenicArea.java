package com.example.Klein.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 景区实体表(ScenicArea)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:45:26
 */

@Data
public class ScenicArea implements Serializable {
    private static final long serialVersionUID = 244639337785452020L;
    
    private Long scenicAreaId;
    
    private String scenicAreaName;
    
    private String phoneNumber;
    
    private String icon1;
    
    private String icon2;
    
    private String icon3;
    
    private String description;

    private String city;




}

