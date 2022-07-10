package com.example.Klein.service;

import com.example.Klein.entity.Performance;

/**
 * 演出实体表(Performance)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:44:44
 */
public interface PerformanceService {

    /**
     * 通过ID查询单条数据
     *
     * @param performanceId 主键
     * @return 实例对象
     */
    Performance queryById(Long performanceId);


    /**
     * 新增数据
     *
     * @param performance 实例对象
     * @return 实例对象
     */
    Performance insert(Performance performance);

    /**
     * 修改数据
     *
     * @param performance 实例对象
     * @return 实例对象
     */
    Performance update(Performance performance);

    /**
     * 通过主键删除数据
     *
     * @param performanceId 主键
     * @return 是否成功
     */
    boolean deleteById(Long performanceId);

}
