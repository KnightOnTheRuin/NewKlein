package com.example.Klein.service;

import com.example.Klein.entity.User;

import java.util.List;

/**
 * 用户实体表，isAdmin为真，是管理员，为假，是普通游客，电话号码唯一(User)表服务接口
 *
 * @author makejava
 * @since 2022-07-10 13:46:05
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

    User userLogin(String phoneNumber, String password);

    List<User> queryAll();

    User queryByPhoneNumber(String phoneNumber);
}
