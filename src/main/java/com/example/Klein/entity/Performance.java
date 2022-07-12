package com.example.Klein.entity;

import java.io.Serializable;

/**
 * 演出实体表(Performance)实体类
 *
 * @author makejava
 * @since 2022-07-10 13:44:44
 */
public class Performance implements Serializable {
    private static final long serialVersionUID = 408157413478008390L;
    
    private Long performanceId;
    
    private Long scenicAreaId;
    
    private String performanceName;
    
    private String teamName;
    
    private String performanceType;
    
    private String icon;
    
    private String time;

    private  String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getScenicAreaId() {
        return scenicAreaId;
    }

    public void setScenicAreaId(Long scenicAreaId) {
        this.scenicAreaId = scenicAreaId;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(String performanceType) {
        this.performanceType = performanceType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

