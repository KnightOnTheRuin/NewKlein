package com.example.Klein.entity;

import java.io.Serializable;

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


    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getEvaluationComment() {
        return evaluationComment;
    }

    public void setEvaluationComment(String evaluationComment) {
        this.evaluationComment = evaluationComment;
    }

    public String getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

}

