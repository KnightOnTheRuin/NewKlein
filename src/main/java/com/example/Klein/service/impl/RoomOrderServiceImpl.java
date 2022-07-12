package com.example.Klein.service.impl;

import com.example.Klein.entity.RoomOrder;
import com.example.Klein.dao.RoomOrderDao;
import com.example.Klein.service.RoomOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单实体表(RoomOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:45:04
 */
@Service("roomOrderService")
@Transactional
public class RoomOrderServiceImpl implements RoomOrderService {
    @Resource
    private RoomOrderDao roomOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public RoomOrder queryById(Long orderId) {
        return this.roomOrderDao.queryById(orderId);
    }


    /**
     * 新增数据
     *
     * @param roomOrder 实例对象
     * @return 实例对象
     */
    @Override
    public RoomOrder insert(RoomOrder roomOrder) {
        this.roomOrderDao.insert(roomOrder);
        return roomOrder;
    }

    /**
     * 修改数据
     *
     * @param roomOrder 实例对象
     * @return 实例对象
     */
    @Override
    public RoomOrder update(RoomOrder roomOrder) {
        this.roomOrderDao.update(roomOrder);
        return this.queryById(roomOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long orderId) {
        return this.roomOrderDao.deleteById(orderId) > 0;
    }

    @Override
    public Long CountByConditions(RoomOrder roomOrder) {
        return this.roomOrderDao.count(roomOrder);
    }

    @Override
    public List<RoomOrder> queryOrderListByAdminId(Long adminId) {
        return this.roomOrderDao.queryOrderByAdminId(adminId);
    }

    @Override
    public List<RoomOrder> queryOrderListByVisitorId(Long visitorId) {
        return this.roomOrderDao.queryOrderByVisitorId(visitorId);
    }

    @Override
    public List<RoomOrder> queryOrderByHotelId(Long hotelId) {
        return this.roomOrderDao.queryOrderByHotelId(hotelId);
    }

    @Override
    public List<RoomOrder> queryAll(){
        return this.roomOrderDao.queryAll();
    }
}
