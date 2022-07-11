package com.example.Klein.service;

import com.example.Klein.entity.GuestRoom;
import com.example.Klein.entity.Hotel;

import java.util.List;

/**
 * 酒店实体表(Hotel)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:42:44
 */
public interface HotelService {

    /**
     * 通过ID查询单条数据
     *
     * @param hotelId 主键
     * @return 实例对象
     */
    Hotel queryById(Long hotelId);


    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    Hotel insert(Hotel hotel);

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    Hotel update(Hotel hotel);

    /**
     * 通过主键删除数据
     *
     * @param hotelId 主键
     * @return 是否成功
     */
    boolean deleteById(Long hotelId);

    //依据不同的(Hotel属性)条件查询Hotel总数
    Long countByConditions(Hotel hotel);

    List<Hotel> queryHotelNearScenicArea(Long ScenicAreaId);

    List<Hotel> queryStarHotel();

}
