package com.example.Klein.dao;

import com.example.Klein.entity.ScenicArea;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景区实体表(ScenicArea)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:45:26
 */
public interface ScenicAreaDao {

    /**
     * 通过ID查询单条数据
     *
     * @param scenicAreaId 主键
     * @return 实例对象
     */
    ScenicArea queryById(Long scenicAreaId);

    /**
     * 统计总行数
     *
     * @param scenicArea 查询条件
     * @return 总行数
     */
    long count(ScenicArea scenicArea);

    /**
     * 新增数据
     *
     * @param scenicArea 实例对象
     * @return 影响行数
     */
    int insert(ScenicArea scenicArea);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScenicArea> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ScenicArea> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScenicArea> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ScenicArea> entities);

    /**
     * 修改数据
     *
     * @param scenicArea 实例对象
     * @return 影响行数
     */
    int update(ScenicArea scenicArea);

    /**
     * 通过主键删除数据
     *
     * @param scenicAreaId 主键
     * @return 影响行数
     */
    int deleteById(Long scenicAreaId);
    /**
     * 通过模糊名字查询景点
     *
     * @param dimName 主键
     * @return 实例对象
     */
    List<ScenicArea> queryByDimName(String dimName);

    /**
     * 通过名字精确查询景点
     *
     * @param Name 主键
     * @return 实例对象
     */
    ScenicArea queryByName(String Name);


}

