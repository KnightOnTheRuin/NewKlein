package com.example.Klein.service;

import com.example.Klein.entity.Entertainment;


/**
 * 餐饮娱乐实体表(Entertainment)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:42:04
 */
public interface EntertainmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param entertainmentId 主键
     * @return 实例对象
     */
    Entertainment queryById(Long entertainmentId);


    /**
     * 新增数据
     *
     * @param entertainment 实例对象
     * @return 实例对象
     */
    Entertainment insert(Entertainment entertainment);

    /**
     * 修改数据
     *
     * @param entertainment 实例对象
     * @return 实例对象
     */
    Entertainment update(Entertainment entertainment);

    /**
     * 通过主键删除数据
     *
     * @param entertainmentId 主键
     * @return 是否成功
     */
    boolean deleteById(Long entertainmentId);

}