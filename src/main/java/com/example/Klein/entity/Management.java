package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 酒店管理员管理酒店关系表(Management)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:43:46
 */
public class Management implements Serializable {
    private static final long serialVersionUID = 514042523392559536L;
    
    private Long managementId;
    
    private Long hotelId;
    
    private Long administratorId;


    public Long getManagementId() {
        return managementId;
    }

    public void setManagementId(Long managementId) {
        this.managementId = managementId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
    }

}

