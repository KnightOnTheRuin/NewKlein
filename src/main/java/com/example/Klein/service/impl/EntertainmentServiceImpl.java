package com.example.Klein.service.impl;

import com.example.Klein.entity.Entertainment;
import com.example.Klein.dao.EntertainmentDao;
import com.example.Klein.entity.User;
import com.example.Klein.service.EntertainmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 餐饮娱乐实体表(Entertainment)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:42:04
 */
@Service("entertainmentService")
@Transactional
public class EntertainmentServiceImpl implements EntertainmentService {
    @Resource
    private EntertainmentDao entertainmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param entertainmentId 主键
     * @return 实例对象
     */
    @Override
    public Entertainment queryById(Long entertainmentId) {
        return this.entertainmentDao.queryById(entertainmentId);
    }


    /**
     * 新增数据
     *
     * @param entertainment 实例对象
     * @return 实例对象
     */
    @Override
    public Entertainment insert(Entertainment entertainment) {
        this.entertainmentDao.insert(entertainment);
        return entertainment;
    }

    /**
     * 修改数据
     *
     * @param entertainment 实例对象
     * @return 实例对象
     */
    @Override
    public Entertainment update(Entertainment entertainment) {
        this.entertainmentDao.update(entertainment);
        return this.queryById(entertainment.getEntertainmentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param entertainmentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long entertainmentId) {
        return this.entertainmentDao.deleteById(entertainmentId) > 0;
    }

    @Override
    public List<Entertainment> queryListByScenicID(Long scenicAreaId){
        return this.entertainmentDao.queryEntertainmentByScenicAreaId(scenicAreaId);
    }
    @Override
    public List<Entertainment> queryListByScenicName(String ScenicName){
        return this.entertainmentDao.queryEntertainmentByScenicAreaName(ScenicName);
    }

    @Override
    public List<Entertainment> queryCateringByScenicAreaId(Long scenicAreaId) {
        return this.entertainmentDao.queryCateringByScenicAreaId(scenicAreaId);
    }

    @Override
    public List<Entertainment> queryNotCateringByScenicAreaId(Long scenicAreaId) {
        return this.entertainmentDao.queryNotCateringByScenicAreaId(scenicAreaId);
    }

    @Override
    public int BatchInsert(List<Entertainment> entities) {
        this.entertainmentDao.insertBatch(entities);
        return 0;
    }

    @Override
    public Long countByConditions(Entertainment entertainment) {
        return this.entertainmentDao.count(entertainment);
    }

    @Override
    public List<Entertainment> queryAll(){
        return this.entertainmentDao.queryAll();
    }

    @Override
    public List<Entertainment> queryByName(String dimName) {
        return this.entertainmentDao.queryByName(dimName);
    }
}
