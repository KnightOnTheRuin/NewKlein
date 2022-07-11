package com.example.Klein.dao;

import com.example.Klein.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户实体表，isAdmin为真，是管理员，为假，是普通游客，电话号码唯一(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-10 13:46:05
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);


    /**
     * 统计总行数
     *
     * @param user 查询条件
     * @return 总行数
     */
    Long count(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);
    /**
     * 通过电话和密码登录
     *
     * @param phoneNumber 主键
     * @param password 主键
     * @return 实例对象
     */
    User logIn(String phoneNumber,String password);

    /**
     * 通过电话查询人
     *
     * @param phoneNumber 非主键
     * @return 实例对象
     */
    User queryUserByPhoneNumber(String phoneNumber);

    List<User> queryAll();

    /**
     * 通过酒店Id查找其管理员
     *
     * @param hotelId 非主键
     * @return 实例对象
     */
    User queryAdministratorByHotelId(long hotelId);
 }

