package com.example.Klein.service.impl;

import com.example.Klein.entity.Management;
import com.example.Klein.dao.ManagementDao;
import com.example.Klein.service.ManagementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 酒店管理员管理酒店关系表(Management)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:43:46
 */
@Service("managementService")
@Transactional
public class ManagementServiceImpl implements ManagementService {
    @Resource
    private ManagementDao managementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param managementId 主键
     * @return 实例对象
     */
    @Override
    public Management queryById(Long managementId) {
        return this.managementDao.queryById(managementId);
    }


    /**
     * 新增数据
     *
     * @param management 实例对象
     * @return 实例对象
     */
    @Override
    public Management insert(Management management) {
        this.managementDao.insert(management);
        return management;
    }

    /**
     * 修改数据
     *
     * @param management 实例对象
     * @return 实例对象
     */
    @Override
    public Management update(Management management) {
        this.managementDao.update(management);
        return this.queryById(management.getManagementId());
    }

    /**
     * 通过主键删除数据
     *
     * @param managementId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long managementId) {
        return this.managementDao.deleteById(managementId) > 0;
    }

    @Override
    public List<Management> queryAll(){
        return this.managementDao.queryAll();
    }
}
