package com.example.Klein.service;

import com.example.Klein.entity.Nearly;

/**
 * 景区附近的酒店关系表(Nearly)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:44:22
 */
public interface NearlyService {

    /**
     * 通过ID查询单条数据
     *
     * @param nearlyId 主键
     * @return 实例对象
     */
    Nearly queryById(Long nearlyId);


    /**
     * 新增数据
     *
     * @param nearly 实例对象
     * @return 实例对象
     */
    Nearly insert(Nearly nearly);

    /**
     * 修改数据
     *
     * @param nearly 实例对象
     * @return 实例对象
     */
    Nearly update(Nearly nearly);

    /**
     * 通过主键删除数据
     *
     * @param nearlyId 主键
     * @return 是否成功
     */
    boolean deleteById(Long nearlyId);

    //通过条件查询附近总数
    Long count(Nearly nearly);

}
