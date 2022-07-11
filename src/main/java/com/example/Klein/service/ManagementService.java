package com.example.Klein.service;

import com.example.Klein.entity.Management;

/**
 * 酒店管理员管理酒店关系表(Management)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:43:46
 */
public interface ManagementService {

    /**
     * 通过ID查询单条数据
     *
     * @param managementId 主键
     * @return 实例对象
     */
    Management queryById(Long managementId);


    /**
     * 新增数据
     *
     * @param management 实例对象
     * @return 实例对象
     */
    Management insert(Management management);

    /**
     * 修改数据
     *
     * @param management 实例对象
     * @return 实例对象
     */
    Management update(Management management);

    /**
     * 通过主键删除数据
     *
     * @param managementId 主键
     * @return 是否成功
     */
    boolean deleteById(Long managementId);



}
