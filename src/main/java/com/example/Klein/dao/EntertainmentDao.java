package com.example.Klein.dao;

import com.example.Klein.entity.Entertainment;
import com.example.Klein.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 餐饮娱乐实体表(Entertainment)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:41:52
 */
public interface EntertainmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param entertainmentId 主键
     * @return 实例对象
     */
    Entertainment queryById(Long entertainmentId);

    /**
     * 统计总行数
     *
     * @param entertainment 查询条件
     * @return 总行数
     */
    Long count(Entertainment entertainment);

    /**
     * 新增数据
     *
     * @param entertainment 实例对象
     * @return 影响行数
     */
    int insert(Entertainment entertainment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Entertainment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Entertainment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Entertainment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Entertainment> entities);

    /**
     * 修改数据
     *
     * @param entertainment 实例对象
     * @return 影响行数
     */
    int update(Entertainment entertainment);

    /**
     * 通过主键删除数据
     *
     * @param entertainmentId 主键
     * @return 影响行数
     */
    int deleteById(Long entertainmentId);

    /**
     * 通过景区Id查找餐饮娱乐
     *
     * @param scenicAreaId 非主键
     * @return 实例对象
     */
    List<Entertainment> queryEntertainmentByScenicAreaId(Long scenicAreaId);

    /**
     * 通过景区名称查找餐饮娱乐
     *
     * @param scenicAreaName 非主键
     * @return 实例对象
     */
    List<Entertainment> queryEntertainmentByScenicAreaName(String scenicAreaName);

    List<Entertainment> queryAll();

    /**
     * 通过景区Id查找餐饮
     *
     * @param scenicAreaId 非主键
     * @return 实例对象
     */
    List<Entertainment> queryCateringByScenicAreaId(Long scenicAreaId);

    /**
     * 通过景区Id查找娱乐场所
     *
     * @param scenicAreaId 非主键
     * @return 实例对象
     */
    List<Entertainment> queryNotCateringByScenicAreaId(Long scenicAreaId);

}

