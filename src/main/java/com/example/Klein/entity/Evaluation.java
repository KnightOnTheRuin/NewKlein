package com.example.Klein.entity;

import lombok.Data;

import java.io.Serializable;

@Data
/**
 * 游客对酒店评价(Evaluation)实体类
 *
 * @author makejava
 * @since 2022-07-13 08:26:20
 */
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 395383000602206567L;
    
    private Long evaluationId;
    
    private Long orderId;
    
    private Long visitorId;
    
    private String evaluationComment;
    
    private String evaluationTime;

    private String userName;


}

