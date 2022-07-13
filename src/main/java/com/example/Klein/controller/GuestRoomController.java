package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.GuestRoomService;
import com.example.Klein.service.HotelService;
import com.example.Klein.utils.PageMessage;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

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

    @Resource
    private HotelService hotelService;

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
        if(guestRoom.getIsFull()!=0&&guestRoom.getIsFull()!=1){
            return  Result.fail(400,"设置房间状态出错",null);
        }
        if(guestRoom.getRoomId()!=null){
            return Result.fail(400,"主键不允许自定义增加",guestRoom);
        }
        if(guestRoom.getHotelId()==null){
            return Result.fail(400,"增加对象时外键不允许为空",guestRoom);
        }

        Hotel hotel=this.hotelService.queryById(guestRoom.getHotelId());
        if(hotel==null){
            return Result.fail(400,"外键在对应的表中不存在",guestRoom);
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
        if(guestRoom.getIsFull()!=0&&guestRoom.getIsFull()!=1){
            return  Result.fail(400,"设置房间状态出错",null);
        }
        if(guestRoom.getRoomId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        GuestRoom TestGuestRoom=this.guestRoomService.queryById(guestRoom.getRoomId());
        if(TestGuestRoom==null){
            return Result.fail(400,"表中无此主键ID对应的数据",null);
        }
        if(guestRoom.getHotelId()!=null){
            Hotel testHotel=this.hotelService.queryById(guestRoom.getHotelId());
            if(testHotel==null){
                return Result.fail(400,"外键对应数据在其所属表中不存在",guestRoom);
            }
        }


        GuestRoom _guestRoom = this.guestRoomService.update(guestRoom);
        if (_guestRoom != null) {

            return Result.success(200, "更新成功", _guestRoom);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }

    /*删除数据*/
    @PostMapping("/deleteGuestRoomById")
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

    //酒店ID查询客房列表
    @PostMapping("/queryRoomListByHotelId")
    public Result queryRoomListByHotelId(@RequestBody Long hotelId){
        Result result = new Result();
        List<GuestRoom> roomList = this.guestRoomService.queryRoomByHotelId(hotelId);

        //Room转NewRoom
        List<NewRoom> returnRoomList=new LinkedList<>();
        for( int i = 0 ; i < roomList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            GuestRoom tempRoom=roomList.get(i);
            NewRoom newRoom=new NewRoom(tempRoom);
            returnRoomList.add(newRoom);
        }

        if(roomList != null){
            result.setData(returnRoomList);
        }else{
            result.setData(hotelId);
        }
        return Result.success(result.getData());
    }

    @PostMapping("/CountRoomByCondtion")
    public Result CountRoomByCondtion(@RequestBody GuestRoom guestRoom){
        Long count =this.guestRoomService.countByConditions(guestRoom);
        return  Result.success(200,"查询成功",count);
    }

    @PostMapping("/queryAllRoomListByPage")
    public Result queryAllRoomListByPage(@RequestBody PageSendMessage pageSendMessage){
        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<GuestRoom> guestRoomList =this.guestRoomService.queryAll();
        if(lastIndex>guestRoomList.size()){
            lastIndex=guestRoomList.size();
        }
        List<GuestRoom> retrunGuestRoomList =guestRoomList.subList(firstIndex,lastIndex);
        PageMessage pageMessage=new PageMessage();
        pageMessage.setGuestRoomPageList(retrunGuestRoomList);
        pageMessage.setTotalResult(guestRoomList.size());
        pageMessage.setTotalPage(guestRoomList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(guestRoomList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }
}

