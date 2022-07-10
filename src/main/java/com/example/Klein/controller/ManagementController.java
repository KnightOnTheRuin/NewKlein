package com.example.Klein.controller;

import com.example.Klein.entity.GuestRoom;
import com.example.Klein.entity.Hotel;
import com.example.Klein.entity.Management;
import com.example.Klein.entity.User;
import com.example.Klein.service.HotelService;
import com.example.Klein.service.ManagementService;
import com.example.Klein.service.UserService;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 酒店管理员管理酒店关系表(Management)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:43:46
 */
@RestController
@RequestMapping("management")
public class ManagementController {
    /**
     * 服务对象
     */
    @Resource
    private ManagementService managementService;

    @Resource
    private HotelService hotelService;

    @Resource
    private UserService userService;


    /**
     * 通过主键查询单条数据
     * @param managementId 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public Result queryById(@RequestBody Long managementId){
        return Result.success(this.managementService.queryById(managementId));
    }

    /**
     * 新增数据
     * @param management 实体
     * @return 新增结果
     */
    @PostMapping("/ManagementAdd")
    public Result ManagementAdd(@RequestBody Management management) {
        if(management.getManagementId()!=null){
            return Result.fail(400,"主键不允许自定义增加",management);
        }
        if(management.getHotelId()==null||management.getAdministratorId()==null){
            return Result.fail(400,"增加对象时外键不允许为空",management);
        }
        Hotel TestHotel=this.hotelService.queryById(management.getHotelId());
        if (TestHotel==null){
            return Result.fail(400,"外键HotelId在表中不存在",management);
        }
        User TestUser=this.userService.queryById(management.getAdministratorId());
        if (TestUser==null){
            return Result.fail(400,"外键UserId在表中不存在",management);
        }
        //正式添加
        Management _management = this.managementService.insert(management);
        try {
            return Result.success(200, "添加成功", _management);
        } catch (Exception e) {
            return Result.fail(402, "添加失败", _management);
        }
    }

    /**
     * 编辑数据
     *
     * @param management 实体
     * @return 编辑结果
     */
    @PostMapping("/ManagementUpdate")
    public Result ManagementUpdate(@RequestBody Management management) {
        return Result.fail(400,"此表无法修改",null);
    }

    /**
     * 删除数据
     *
     * @param managementId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteManagementById")
    public Result deleteManagementById(@RequestBody Long managementId) {
        Management _management=this.managementService.queryById(managementId);
        if(_management==null){
            return Result.fail(400,"数据库不存在ID对应的列",null);
        }
        boolean mark = this.managementService.deleteById(managementId);
        if(mark){
            return Result.success(200,"删除成功",null);
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

}

