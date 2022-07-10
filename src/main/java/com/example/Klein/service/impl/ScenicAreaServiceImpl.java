package com.example.Klein.service.impl;

import com.example.Klein.entity.ScenicArea;
import com.example.Klein.dao.ScenicAreaDao;
import com.example.Klein.service.ScenicAreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景区实体表(ScenicArea)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:45:26
 */
@Service("scenicAreaService")
@Transactional
public class ScenicAreaServiceImpl implements ScenicAreaService {
    @Resource
    private ScenicAreaDao scenicAreaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scenicAreaId 主键
     * @return 实例对象
     */
    @Override
    public ScenicArea queryById(Long scenicAreaId) {
        return this.scenicAreaDao.queryById(scenicAreaId);
    }


    /**
     * 新增数据
     *
     * @param scenicArea 实例对象
     * @return 实例对象
     */
    @Override
    public ScenicArea insert(ScenicArea scenicArea) {
        this.scenicAreaDao.insert(scenicArea);
        return scenicArea;
    }

    /**
     * 修改数据
     *
     * @param scenicArea 实例对象
     * @return 实例对象
     */
    @Override
    public ScenicArea update(ScenicArea scenicArea) {
        this.scenicAreaDao.update(scenicArea);
        return this.queryById(scenicArea.getScenicAreaId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scenicAreaId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long scenicAreaId) {
        return this.scenicAreaDao.deleteById(scenicAreaId) > 0;
    }

    @Override
    public ScenicArea queryByName(String name) {
        return this.scenicAreaDao.queryByName(name);
    }

    @Override
    public List<ScenicArea> dimQueryByName(String dimNamein) {
        return this.scenicAreaDao.queryByDimName(dimNamein);
    }
}
