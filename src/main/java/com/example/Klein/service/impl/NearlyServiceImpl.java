package com.example.Klein.service.impl;

import com.example.Klein.entity.Nearly;
import com.example.Klein.dao.NearlyDao;
import com.example.Klein.service.NearlyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 景区附近的酒店关系表(Nearly)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:44:22
 */
@Service("nearlyService")
@Transactional
public class NearlyServiceImpl implements NearlyService {
    @Resource
    private NearlyDao nearlyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param nearlyId 主键
     * @return 实例对象
     */
    @Override
    public Nearly queryById(Long nearlyId) {
        return this.nearlyDao.queryById(nearlyId);
    }


    /**
     * 新增数据
     *
     * @param nearly 实例对象
     * @return 实例对象
     */
    @Override
    public Nearly insert(Nearly nearly) {
        this.nearlyDao.insert(nearly);
        return nearly;
    }

    /**
     * 修改数据
     *
     * @param nearly 实例对象
     * @return 实例对象
     */
    @Override
    public Nearly update(Nearly nearly) {
        this.nearlyDao.update(nearly);
        return this.queryById(nearly.getNearlyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param nearlyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long nearlyId) {
        return this.nearlyDao.deleteById(nearlyId) > 0;
    }

    @Override
    public Long count(Nearly nearly) {
        return this.nearlyDao.count(nearly);
    }
}
