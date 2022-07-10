package com.example.Klein.service;

import com.example.Klein.entity.GuestRoom;

/**
 * 客房实体表(GuestRoom)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:42:22
 */
public interface GuestRoomService {

    /**
     * 通过ID查询单条数据
     *
     * @param roomId 主键
     * @return 实例对象
     */
    GuestRoom queryById(Long roomId);


    /**
     * 新增数据
     *
     * @param guestRoom 实例对象
     * @return 实例对象
     */
    GuestRoom insert(GuestRoom guestRoom);

    /**
     * 修改数据
     *
     * @param guestRoom 实例对象
     * @return 实例对象
     */
    GuestRoom update(GuestRoom guestRoom);

    /**
     * 通过主键删除数据
     *
     * @param roomId 主键
     * @return 是否成功
     */
    boolean deleteById(Long roomId);

}
