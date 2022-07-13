package com.example.Klein.service;

import com.example.Klein.entity.Evaluation;

import java.util.List;

/**
 * 游客对酒店评价(Evaluation)表服务接口
 *
 * @author makejava
 * @since 2022-07-13 08:26:20
 */
public interface EvaluationService {

    /**
     * 通过ID查询单条数据
     *
     * @param evaluationId 主键
     * @return 实例对象
     */
    Evaluation queryById(Long evaluationId);


    /**
     * 新增数据
     *
     * @param evaluation 实例对象
     * @return 实例对象
     */
    Evaluation insert(Evaluation evaluation);

    /**
     * 修改数据
     *
     * @param evaluation 实例对象
     * @return 实例对象
     */
    Evaluation update(Evaluation evaluation);

    /**
     * 通过主键删除数据
     *
     * @param evaluationId 主键
     * @return 是否成功
     */
    boolean deleteById(Long evaluationId);

    /*通过餐饮娱乐ID查询该餐饮娱乐的评论*/
    List<Evaluation> queryEvaluationByEntertainmentId(Long entertainmentId);


    /*通过游客ID查询该游客的评论*/
    List<Evaluation> queryEvaluationByVisitorId(Long visitorId);

}
