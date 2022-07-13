package com.example.Klein.dao;

import com.example.Klein.entity.Evaluation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 游客对酒店评价(Evaluation)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-13 08:26:20
 */
public interface EvaluationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param evaluationId 主键
     * @return 实例对象
     */
    Evaluation queryById(Long evaluationId);



    /**
     * 统计总行数
     *
     * @param evaluation 查询条件
     * @return 总行数
     */
    long count(Evaluation evaluation);

    /**
     * 新增数据
     *
     * @param evaluation 实例对象
     * @return 影响行数
     */
    int insert(Evaluation evaluation);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Evaluation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Evaluation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Evaluation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Evaluation> entities);

    /**
     * 修改数据
     *
     * @param evaluation 实例对象
     * @return 影响行数
     */
    int update(Evaluation evaluation);

    /**
     * 通过主键删除数据
     *
     * @param evaluationId 主键
     * @return 影响行数
     */
    int deleteById(Long evaluationId);

    /**
     * 通过餐饮娱乐ID查询该餐饮娱乐的评论
     *
     * @param entertainmentId 非主键
     * @return 实例对象
     */

    List<Evaluation> queryEvaluationByEntertainmentId(Long entertainmentId);

    /**
     * 通过游客ID查询该游客的评论
     *
     * @param visitorId 非主键
     * @return 实例对象
     */

    List<Evaluation> queryEvaluationByVisitorId(Long visitorId);

}

