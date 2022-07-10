package com.example.Klein.service.impl;

import com.example.Klein.entity.Performance;
import com.example.Klein.dao.PerformanceDao;
import com.example.Klein.service.PerformanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 演出实体表(Performance)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:44:44
 */
@Service("performanceService")
@Transactional
public class PerformanceServiceImpl implements PerformanceService {
    @Resource
    private PerformanceDao performanceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param performanceId 主键
     * @return 实例对象
     */
    @Override
    public Performance queryById(Long performanceId) {
        return this.performanceDao.queryById(performanceId);
    }

    /**
     * 新增数据
     *
     * @param performance 实例对象
     * @return 实例对象
     */
    @Override
    public Performance insert(Performance performance) {
        this.performanceDao.insert(performance);
        return performance;
    }

    /**
     * 修改数据
     *
     * @param performance 实例对象
     * @return 实例对象
     */
    @Override
    public Performance update(Performance performance) {
        this.performanceDao.update(performance);
        return this.queryById(performance.getPerformanceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param performanceId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long performanceId) {
        return this.performanceDao.deleteById(performanceId) > 0;
    }
}
