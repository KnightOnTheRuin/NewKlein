package com.example.Klein.service;

import com.example.Klein.entity.ScenicArea;

import java.util.List;

/**
 * 景区实体表(ScenicArea)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:45:26
 */
public interface ScenicAreaService {

    /**
     * 通过ID查询单条数据
     *
     * @param scenicAreaId 主键
     * @return 实例对象
     */
    ScenicArea queryById(Long scenicAreaId);

    /**
     * 新增数据
     *
     * @param scenicArea 实例对象
     * @return 实例对象
     */
    ScenicArea insert(ScenicArea scenicArea);

    /**
     * 修改数据
     *
     * @param scenicArea 实例对象
     * @return 实例对象
     */
    ScenicArea update(ScenicArea scenicArea);

    /**
     * 通过主键删除数据
     *
     * @param scenicAreaId 主键
     * @return 是否成功
     */
    boolean deleteById(Long scenicAreaId);

    //通过名字模糊搜索景区
    ScenicArea queryByName(String name);

    //通过名字精确搜索景区
    List<ScenicArea> dimQueryByName(String dimNamein);

    //通过酒店ID搜索附近景区列表
    List<ScenicArea> queryScenicListAreaNearHotel(Long hotelId);

    List<ScenicArea> queryAll();
}
