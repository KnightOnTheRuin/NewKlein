package com.example.Klein.service;

import com.example.Klein.entity.Performance;
import com.example.Klein.entity.RoomOrder;

import java.util.List;

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

    //通过条件统计订单
    Long CountByConditions(RoomOrder roomOrder);

    //通过管理员ID查询订单列表
    List<RoomOrder> queryOrderListByAdminId(Long adminId);

    //通过游客ID查询订单列表
    List<RoomOrder> queryOrderListByVisitorId(Long visitorId);

    //通过酒店ID查询订单列表
    List<RoomOrder> queryOrderByHotelId(Long hotelId);

    /*通过游客Id查找到当前游客的所有已完成但还未评价的订单*/
    List<RoomOrder> queryFinisherOrderByVisitorId(Long visitorId);

    /*通过游客Id查找到当前游客的所有已完成评价的订单*/
    List<RoomOrder> queryEvaluatedOrderByVisitorId(Long visitorId);

    /*通过游客Id查找到当前游客的未完成的订单*/
    List<RoomOrder> queryNoFinishedOrderByVisitorId(Long visitorId);


    /*通过管理员Id查找到当前管理员处理过的所有订单*/
    List<RoomOrder> queryCheckedOrderByAdminId(Long adminId);

    /*通过管理员Id查找到当前管理员还未处理所有订单*/
    List<RoomOrder> queryNoCheckedOrderByAdminId(Long adminId);

    List<RoomOrder> queryAll();
}
