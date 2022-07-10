package com.example.Klein.controller;

import com.example.Klein.entity.GuestRoom;
import com.example.Klein.entity.Hotel;
import com.example.Klein.service.HotelService;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 酒店实体表(Hotel)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:42:44
 */
@RestController
@RequestMapping("hotel")
public class HotelController {
    /**
     * 服务对象
     */
    @Resource
    private HotelService hotelService;

    /**
     * 通过主键查询单条数据
     * @param HotelId 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public Result queryById(@RequestBody Long HotelId){
        return Result.success(this.hotelService.queryById(HotelId));
    }

    /**
     * 新增数据
     *
     * @param hotel 实体
     * @return 新增结果
     */
    @PostMapping("/hotelAdd")
    public Result hotelAdd(@RequestBody Hotel hotel) {
        if(hotel.getHotelId()!=null){
            return Result.fail(400,"主键不允许自定义增加",hotel);
        }
        //正式添加
        Hotel _hotel = this.hotelService.insert(hotel);
        try {
            return Result.success(200, "添加成功", _hotel);
        } catch (Exception e) {
            return Result.fail(402, "添加失败", _hotel);
        }
    }

    /**
     * 编辑数据
     *
     * @param hotel 实体
     * @return 编辑结果
     */
    @PostMapping("/updateHotel")
    public Result updateHotel(@RequestBody Hotel hotel) {
        if(hotel.getHotelId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        Hotel TestHotel=this.hotelService.queryById(hotel.getHotelId());
        if(TestHotel==null){
            return Result.fail(400,"表中无此主键ID对应的数据",null);
        }
        Hotel _hotel = this.hotelService.update(hotel);
        if (_hotel != null) {
            return Result.success(200, "更新成功", _hotel);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }

    /**
     * 删除数据
     * @param hotelId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteHotelById")
    public Result deleteHotelById(@RequestBody Long hotelId) {
        Hotel _hotel=this.hotelService.queryById(hotelId);
        if(_hotel==null){
            return Result.fail(400,"数据库不存在ID对应的列",null);
        }
        boolean mark = this.hotelService.deleteById(hotelId);
        if(mark){
            return Result.success(200,"删除成功",null);
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

}

