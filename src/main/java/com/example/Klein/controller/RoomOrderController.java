package com.example.Klein.controller;

import com.example.Klein.entity.RoomOrder;
import com.example.Klein.service.RoomOrderService;
import com.example.Klein.utils.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单实体表(RoomOrder)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:45:03
 */
@RestController
@RequestMapping("roomOrder")
public class RoomOrderController {
    /**
     * 服务对象
     */
    @Resource
    private RoomOrderService roomOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryRoomOrderById")
    public Result queryRoomOrderById(@RequestBody Long id) {
        return Result.success(this.roomOrderService.queryById(id));
    }


    /**
     * 新增数据
     *
     * @param roomOrder 实体
     * @return 新增结果
     */
    @PostMapping("/addRoomOrder")
    public Result addRoomOrder(@RequestBody RoomOrder roomOrder) {
        try{
            RoomOrder _roomOrder =  this.roomOrderService.insert(roomOrder);
            return Result.success(200,"生成订单成功",_roomOrder);
        }catch (Exception e){
            return Result.fail(402,"生成订单失败",null);
        }
    }
    /**
     * 编辑数据
     *
     * @param roomOrder 实体
     * @return 编辑结果
     */
    @PutMapping("/editRoomOrder")
    public Result editRoomOrder(@RequestBody RoomOrder roomOrder) {
        RoomOrder ro = this.roomOrderService.update(roomOrder);
        if(ro != null){
            return Result.success(200,"更新成功",ro);
        }else{
            return Result.fail(400,"更新失败",null);
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteRoomOrderById")
    public Result deleteRoomOrderById(@RequestBody Long id) {
        boolean mark = this.roomOrderService.deleteById(id);
        if(mark) {
            return Result.success(this.roomOrderService.deleteById(id));
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

}

