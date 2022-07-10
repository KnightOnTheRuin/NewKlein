package com.example.Klein.controller;

import com.example.Klein.entity.Entertainment;
import com.example.Klein.entity.GuestRoom;
import com.example.Klein.entity.ScenicArea;
import com.example.Klein.service.GuestRoomService;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 客房实体表(GuestRoom)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:42:22
 */
@RestController
@RequestMapping("guestRoom")
public class GuestRoomController {
    /**
     * 服务对象
     */
    @Resource
    private GuestRoomService guestRoomService;

    /**
     * 通过主键查询单条数据
     * @param GuestRoomId 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public Result queryById(@RequestBody long GuestRoomId){
        return Result.success(this.guestRoomService.queryById(GuestRoomId));
    }

    /**新增数据
     *@param guestRoom 实体
     *@return 新增结果
     */
    @PostMapping("/GuestRoomAdd")
    public Result GuestRoomAdd(@RequestBody GuestRoom guestRoom) {
        if(guestRoom.getRoomId()!=null){
            return Result.fail(400,"主键不允许自定义增加",guestRoom);
        }
        if(guestRoom.getHotelId()==null){
            return Result.fail(400,"增加对象时外键不允许为空",guestRoom);
        }
            GuestRoom newGuestRoom=this.guestRoomService.queryById(guestRoom.getRoomId());
            if (newGuestRoom==null){
                return Result.fail(400,"外键scenicArea在表中不存在",guestRoom);
        }
        //正式添加
        GuestRoom _guestRoom = this.guestRoomService.insert(guestRoom);
        try {
            return Result.success(200, "添加成功", _guestRoom);
        } catch (Exception e) {
            return Result.fail(402, "添加失败", _guestRoom);
        }
    }


    /**
     * 编辑数据
     * @param guestRoom 实体
     * @return 编辑结果
     */
    @PostMapping("/updateGuestRoom")
    public Result updateGuestRoom(@RequestBody GuestRoom guestRoom) {
        if(guestRoom.getRoomId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        GuestRoom TestGuestRoom=this.guestRoomService.queryById(guestRoom.getRoomId());
        if(TestGuestRoom==null){
            return Result.fail(400,"表中无此主键ID对应的数据",null);
        }
        if (guestRoom.getHotelId()!= null) {
            return Result.fail(400, "不允许修改外键ScenicAreaId,此项必须为空", null);
        }
        GuestRoom _guestRoom = this.guestRoomService.update(guestRoom);
        if (_guestRoom != null) {
            return Result.success(200, "更新成功", _guestRoom);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }

    /**
      删除数据
      @param guestRoomId 主键
      @return 删除是否成功
     */
    @DeleteMapping("/deleteGuestRoomById")
    public Result deleteGuestRoomById(@RequestBody Long guestRoomId) {
        GuestRoom _guestRoom=this.guestRoomService.queryById(guestRoomId);
        if(_guestRoom==null){
            return Result.fail(400,"数据库不存在ID对应的列",null);
        }
        boolean mark = this.guestRoomService.deleteById(guestRoomId);
        if(mark){
            return Result.success(200,"删除成功",null);
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

}

