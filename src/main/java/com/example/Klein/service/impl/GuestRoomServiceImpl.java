package com.example.Klein.service.impl;

import com.example.Klein.entity.GuestRoom;
import com.example.Klein.dao.GuestRoomDao;
import com.example.Klein.service.GuestRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客房实体表(GuestRoom)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:42:22
 */
@Service("guestRoomService")
@Transactional
public class GuestRoomServiceImpl implements GuestRoomService {
    @Resource
    private GuestRoomDao guestRoomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roomId 主键
     * @return 实例对象
     */
    @Override
    public GuestRoom queryById(Long roomId) {
        return this.guestRoomDao.queryById(roomId);
    }


    /**
     * 新增数据
     *
     * @param guestRoom 实例对象
     * @return 实例对象
     */
    @Override
    public GuestRoom insert(GuestRoom guestRoom) {
        this.guestRoomDao.insert(guestRoom);
        return guestRoom;
    }

    /**
     * 修改数据
     *
     * @param guestRoom 实例对象
     * @return 实例对象
     */
    @Override
    public GuestRoom update(GuestRoom guestRoom) {
        this.guestRoomDao.update(guestRoom);
        return this.queryById(guestRoom.getRoomId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roomId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roomId) {
        return this.guestRoomDao.deleteById(roomId) > 0;
    }

    @Override
    public Long countByConditions(GuestRoom guestRoom) {
        return  this.guestRoomDao.count(guestRoom);
    }

    @Override
    public List<GuestRoom> queryRoomByHotelId(Long hotelId) {
        return this.guestRoomDao.queryRoomByHotelId(hotelId);
    }
}
