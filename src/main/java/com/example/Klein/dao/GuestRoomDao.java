package com.example.Klein.dao;

import com.example.Klein.entity.GuestRoom;
import com.example.Klein.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 客房实体表(GuestRoom)表数据库访问层
 * @author makejava
 * @since 2022-07-10 13:42:22
 */
public interface GuestRoomDao {

    /**
     * 通过ID查询单条数据
     * @param roomId 主键
     * @return 实例对象
     */
    GuestRoom queryById(Long roomId);


    /**
     * 统计总行数
     * @param guestRoom 查询条件
     * @return 总行数
     */
    Long count(GuestRoom guestRoom);

    /**
     * 新增数据
     * @param guestRoom 实例对象
     * @return 影响行数
     */
    int insert(GuestRoom guestRoom);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     * @param entities List<GuestRoom> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<GuestRoom> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     * @param entities List<GuestRoom> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<GuestRoom> entities);

    /**
     * 修改数据
     * @param guestRoom 实例对象
     * @return 影响行数
     */
    int update(GuestRoom guestRoom);

    /**
     * 通过主键删除数据
     * @param roomId 主键
     * @return 影响行数
     */
    int deleteById(Long roomId);
    /**
     * 通过酒店Id查找酒店所包含的房间类型
     * @param hotelId 主键
     * @return 实例对象
     */

    List<GuestRoom> queryRoomByHotelId(Long hotelId);

    List<GuestRoom> queryAll();
}

