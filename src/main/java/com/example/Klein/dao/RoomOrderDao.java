package com.example.Klein.dao;

import com.example.Klein.entity.RoomOrder;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单实体表(RoomOrder)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:45:03
 */
public interface RoomOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    RoomOrder queryById(Long orderId);

    /**
     * 统计总行数
     *
     * @param roomOrder 查询条件
     * @return 总行数
     */
    long count(RoomOrder roomOrder);

    /**
     * 新增数据
     *
     * @param roomOrder 实例对象
     * @return 影响行数
     */
    int insert(RoomOrder roomOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoomOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RoomOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoomOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RoomOrder> entities);

    /**
     * 修改数据
     *
     * @param roomOrder 实例对象
     * @return 影响行数
     */
    int update(RoomOrder roomOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Long orderId);

}
