package com.example.Klein.service.impl;

import com.example.Klein.entity.Hotel;
import com.example.Klein.dao.HotelDao;
import com.example.Klein.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 酒店实体表(Hotel)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:42:44
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
    @Resource
    private HotelDao hotelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hotelId 主键
     * @return 实例对象
     */
    @Override
    public Hotel queryById(Long hotelId) {
        return this.hotelDao.queryById(hotelId);
    }


    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel insert(Hotel hotel) {
        this.hotelDao.insert(hotel);
        return hotel;
    }

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel update(Hotel hotel) {
        this.hotelDao.update(hotel);
        return this.queryById(hotel.getHotelId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hotelId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long hotelId) {
        return this.hotelDao.deleteById(hotelId) > 0;
    }
}
