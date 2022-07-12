package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.HotelService;
import com.example.Klein.service.RoomOrderService;
import com.example.Klein.service.UserService;
import com.example.Klein.utils.PageMessage;
import com.example.Klein.utils.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 订单实体表(RoomOrder)表控制层
 * @author makejava
 * @since 2022-07-10 13:45:03
 */
@RestController
@RequestMapping("roomOrder")
public class RoomOrderController {
    /**
     *服务对象
     */
    @Resource
    private RoomOrderService roomOrderService;

    @Resource
    private HotelService hotelService;

    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryRoomOrderById")
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
            if(roomOrder.getOrderId()!=null){
                return Result.fail(400,"主键不允许自定义增加",roomOrder);
            }
            if(roomOrder.getHotelId()==null||roomOrder.getVisitorId()==null){
                return Result.fail(400,"增加对象时外键不允许为空",roomOrder);
            }

            Hotel hotel=this.hotelService.queryById(roomOrder.getHotelId());
            User visitor=this.userService.queryById(roomOrder.getVisitorId());
            if (hotel==null||visitor==null){
                return Result.fail(400,"外键在对应的表中不存在",roomOrder);
            }
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
    @PostMapping("/editRoomOrder")
    public Result editRoomOrder(@RequestBody RoomOrder roomOrder) {

        //通过评分修改酒店Stars
        float totalStars=0;
        float score=roomOrder.getStars();
        float result;

        //遍历酒店订单获取总分
        List<RoomOrder> roomOrderList=this.roomOrderService.queryOrderByHotelId(roomOrder.getHotelId());
        int size=roomOrderList.size();
        if(roomOrder.getStars()!=0){
            size++;
        }
        Iterator<RoomOrder> iterator = roomOrderList.iterator();
        while (iterator.hasNext()) {
            RoomOrder nextRoomOrder=iterator.next();
            totalStars+=nextRoomOrder.getStars();
            iterator.remove();
        }
        //求平均分
        totalStars+=score;
        result=totalStars/size;

        //更新平均分
        Hotel UpdateHotel=this.hotelService.queryById(roomOrder.getHotelId());
        UpdateHotel.setStars(result);
        this.hotelService.update(UpdateHotel);

        if(roomOrder.getOrderId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        if(roomOrder.getHotelId()!=null&&roomOrder.getVisitorId()!=null){
            Hotel hotel=this.hotelService.queryById(roomOrder.getHotelId());
            User visitor=this.userService.queryById(roomOrder.getVisitorId());
            if (hotel==null||visitor==null){
                return Result.fail(400,"外键在对应的表中不存在",roomOrder);
            }
        }


        RoomOrder _roomOrder = this.roomOrderService.update(roomOrder);
        if(_roomOrder != null){
            return Result.success(200,"更新成功",_roomOrder);
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
    @PostMapping("/deleteRoomOrderById")
    public Result deleteRoomOrderById(@RequestBody Long id) {
        RoomOrder roomOrder=this.roomOrderService.queryById(id);
        if(roomOrder==null){
            return Result.fail(400,"Id对应的实体在表中不存在",id);
        }
        boolean mark = this.roomOrderService.deleteById(id);
        if(mark) {
            return Result.success(this.roomOrderService.deleteById(id));
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

    //通过订单来评分
    @PostMapping("/ScoreHotel")
    public Result ScoreHotel(@RequestBody RoomOrder roomOrder) {

        //通过评分修改酒店Stars
        Hotel UpdateHotel=this.hotelService.queryById(roomOrder.getHotelId());
        float originScore=UpdateHotel.getStars();
        float resultStars=0;
        float orderScore=roomOrder.getStars();

        resultStars= (float) ((orderScore-originScore)*0.1+originScore);
        resultStars=Math.round(resultStars*10)/10f;
        /*DecimalFormat df1 = new DecimalFormat("#.00");
        df1.format(resultStars);*/

        //更新平均分
        UpdateHotel.setStars(resultStars);
        this.hotelService.update(UpdateHotel);

        return Result.success(200,"评分成功",UpdateHotel);

    }


    //通过条件计数订单总数
    @PostMapping("/CountRoomOrderByConditions")
    public Result CountRoomOrderByConditions(@RequestBody RoomOrder roomOrder){
        Long count =this.roomOrderService.CountByConditions(roomOrder);
        return  Result.success(200,"查询成功",count);
    }

    //通过管理员ID查找订单列表
    @PostMapping("/queryOrderListByAdminId")
    public Result queryOrderListByAdminId(@RequestBody Long adminId){
        Result result = new Result();
        List<RoomOrder> roomOrderList = this.roomOrderService.queryOrderListByAdminId(adminId);
        if(roomOrderList != null){
            result.setData(roomOrderList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过游客ID查找订单列表
    @PostMapping("/queryOrderListByVisitorId")
    public Result queryOrderListByVisitorId(@RequestBody Long visitorId){
        Result result = new Result();
        List<RoomOrder> roomOrderList = this.roomOrderService.queryOrderListByVisitorId(visitorId);

        //中间类转换
        List<NewRoomOrder> newRoomOrderList=new LinkedList<>();
        for( int i = 0 ; i < roomOrderList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            RoomOrder tempRoomOrder=roomOrderList.get(i);
            NewRoomOrder newRoomOrder=new NewRoomOrder(tempRoomOrder);

            Hotel tempHotel=this.hotelService.queryById(tempRoomOrder.getHotelId());
            newRoomOrder.setHotelName(tempHotel.getHotelName());
            newRoomOrderList.add(newRoomOrder);
        }


        if(newRoomOrderList != null){
            result.setData(newRoomOrderList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过游客ID查找未完成订单列表  (0,1,2)状态
    @PostMapping("/queryNonFinishOrderListByVisitorId")
    public Result queryNonFinishOrderListByVisitorId(@RequestBody Long visitorId){
        Result result = new Result();
        List<RoomOrder> roomOrderList = this.roomOrderService.queryNoFinishedOrderByVisitorId(visitorId);

        //中间类转换
        List<NewRoomOrder> newRoomOrderList=new LinkedList<>();
        for( int i = 0 ; i < roomOrderList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            RoomOrder tempRoomOrder=roomOrderList.get(i);
            NewRoomOrder newRoomOrder=new NewRoomOrder(tempRoomOrder);
            Hotel tempHotel=this.hotelService.queryById(tempRoomOrder.getHotelId());
            newRoomOrder.setHotelName(tempHotel.getHotelName());
            newRoomOrderList.add(newRoomOrder);
        }


        if(newRoomOrderList != null){
            result.setData(newRoomOrderList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过游客ID查找已完成未评价订单列表  3状态
    @PostMapping("/queryFinishOrderListByVisitorId")
    public Result queryFinishOrderListByVisitorId(@RequestBody Long visitorId){
        Result result = new Result();
        List<RoomOrder> roomOrderList = this.roomOrderService.queryFinisherOrderByVisitorId(visitorId);

        //中间类转换
        List<NewRoomOrder> newRoomOrderList=new LinkedList<>();
        for( int i = 0 ; i < roomOrderList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            RoomOrder tempRoomOrder=roomOrderList.get(i);
            NewRoomOrder newRoomOrder=new NewRoomOrder(tempRoomOrder);
            Hotel tempHotel=this.hotelService.queryById(tempRoomOrder.getHotelId());
            newRoomOrder.setHotelName(tempHotel.getHotelName());
            newRoomOrderList.add(newRoomOrder);
        }


        if(newRoomOrderList != null){
            result.setData(newRoomOrderList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }


    //通过游客ID查找已完成评价订单列表  4状态
    @PostMapping("/queryEvaluateOrderListByVisitorId")
    public Result queryEvaluateOrderListByVisitorId(@RequestBody Long visitorId){
        Result result = new Result();
        List<RoomOrder> roomOrderList = this.roomOrderService.queryEvaluatedOrderByVisitorId(visitorId);

        //中间类转换
        List<NewRoomOrder> newRoomOrderList=new LinkedList<>();
        for( int i = 0 ; i < roomOrderList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            RoomOrder tempRoomOrder=roomOrderList.get(i);
            NewRoomOrder newRoomOrder=new NewRoomOrder(tempRoomOrder);
            Hotel tempHotel=this.hotelService.queryById(tempRoomOrder.getHotelId());
            newRoomOrder.setHotelName(tempHotel.getHotelName());
            newRoomOrderList.add(newRoomOrder);
        }


        if(newRoomOrderList != null){
            result.setData(newRoomOrderList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }


    //分页查询
    @PostMapping("/queryAllOrderListByPage")
    public Result queryAllOrderListByPage(@RequestBody PageSendMessage pageSendMessage){
        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<RoomOrder> roomOrderList =this.roomOrderService.queryAll();
        if(lastIndex>roomOrderList.size()){
            lastIndex=roomOrderList.size();
        }
        List<RoomOrder> returnRoomOrderList =roomOrderList.subList(firstIndex,lastIndex);
        PageMessage pageMessage=new PageMessage();
        pageMessage.setRoomOrderPageList(returnRoomOrderList);
        pageMessage.setTotalResult(roomOrderList.size());
        pageMessage.setTotalPage(roomOrderList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(roomOrderList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }

}

