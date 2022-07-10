package com.example.Klein.dao;

import com.example.Klein.entity.Management;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 酒店管理员管理酒店关系表(Management)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:43:46
 */
public interface ManagementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param managementId 主键
     * @return 实例对象
     */
    Management queryById(Long managementId);

    /**
     * 统计总行数
     *
     * @param management 查询条件
     * @return 总行数
     */
    long count(Management management);

    /**
     * 新增数据
     *
     * @param management 实例对象
     * @return 影响行数
     */
    int insert(Management management);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Management> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Management> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Management> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Management> entities);

    /**
     * 修改数据
     *
     * @param management 实例对象
     * @return 影响行数
     */
    int update(Management management);

    /**
     * 通过主键删除数据
     *
     * @param managementId 主键
     * @return 影响行数
     */
    int deleteById(Long managementId);

}

