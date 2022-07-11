package com.example.Klein.dao;

import com.example.Klein.entity.Performance;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 演出实体表(Performance)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:44:44
 */
public interface PerformanceDao {

    /**
     * 通过ID查询单条数据
     * @param performanceId 主键
     * @return 实例对象
     */
    Performance queryById(Long performanceId);

    /**
     * 统计总行数
     *
     * @param performance 查询条件
     * @return 总行数
     */

    Long count(Performance performance);

    /**
     * 新增数据
     * @param performance 实例对象
     * @return 影响行数
     */
    int insert(Performance performance);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<Performance> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Performance> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Performance> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Performance> entities);

    /**
     * 修改数据
     *
     * @param performance 实例对象
     * @return 影响行数
     */
    int update(Performance performance);

    /**
     * 通过主键删除数据
     * @param performanceId 主键
     * @return 影响行数
     */
    int deleteById(Long performanceId);
    /**
     * 通过景区Id查找节目
     * @param scenicAreaId  非主键
     * @return 实例对象
     */
    List<Performance> queryPerformanceByScenicAreaId(Long scenicAreaId);

    /**
     * 通过景区名查找节目
     *
     * @param scenicAreaName  非主键
     * @return 实例对象
     */
    List<Performance> queryPerformanceByScenicAreaName(String scenicAreaName);
}

