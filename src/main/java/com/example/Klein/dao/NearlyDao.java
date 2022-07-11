package com.example.Klein.dao;

import com.example.Klein.entity.Nearly;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景区附近的酒店关系表(Nearly)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:44:22
 */
public interface NearlyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param nearlyId 主键
     * @return 实例对象
     */
    Nearly queryById(Long nearlyId);

    /**
     * 统计总行数
     *
     * @param nearly 查询条件
     * @return 总行数
     */
    Long count(Nearly nearly);

    /**
     * 新增数据
     *
     * @param nearly 实例对象
     * @return 影响行数
     */
    int insert(Nearly nearly);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Nearly> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Nearly> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Nearly> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Nearly> entities);

    /**
     * 修改数据
     *
     * @param nearly 实例对象
     * @return 影响行数
     */
    int update(Nearly nearly);

    /**
     * 通过主键删除数据
     * @param nearlyId 主键
     * @return 影响行数
     */
    int deleteById(Long nearlyId);

}

