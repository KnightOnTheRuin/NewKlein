package com.example.Klein.service;

import com.example.Klein.entity.RoomOrder;

/**
 * 订单实体表(RoomOrder)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:45:04
 */
public interface RoomOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    RoomOrder queryById(Long orderId);

    /**
     * 新增数据
     *
     * @param roomOrder 实例对象
     * @return 实例对象
     */
    RoomOrder insert(RoomOrder roomOrder);

    /**
     * 修改数据
     *
     * @param roomOrder 实例对象
     * @return 实例对象
     */
    RoomOrder update(RoomOrder roomOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    boolean deleteById(Long orderId);

}
