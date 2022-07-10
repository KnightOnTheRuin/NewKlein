package com.example.Klein.service.impl;

import com.example.Klein.entity.User;
import com.example.Klein.dao.UserDao;
import com.example.Klein.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户实体表，isAdmin为真，是管理员，为假，是普通游客，电话号码唯一(User)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 13:46:05
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long userId) {
        return this.userDao.queryById(userId);
    }


    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    @Override
    public User userLogin(String phoneNumber, String password) {
        return this.userDao.logIn(phoneNumber, password);
    }

    @Override
    public List<User> queryAll() {
        return this.userDao.queryAll();
    }

    @Override
    public User queryByPhoneNumber(String phoneNumber) {
        return this.userDao.queryUserByPhoneNumber(phoneNumber);
    }
}
