package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.HotelService;
import com.example.Klein.utils.PageMessage;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

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

        if(hotel.getStarLevel()!=0&&hotel.getStarLevel()!=3&&hotel.getStarLevel()!=4&&hotel.getStarLevel()!=5){
            return Result.fail(400,"酒店星级设置错误",hotel);
        }
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
        if(hotel.getStarLevel()!=0&&hotel.getStarLevel()!=3&&hotel.getStarLevel()!=4&&hotel.getStarLevel()!=5){
            return Result.fail(400,"酒店星级设置错误",hotel);
        }
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
    @PostMapping("/deleteHotelById")
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

    //通过景区ID搜索附近酒店
    @PostMapping("/queryHotelListBySceniclId")
    public Result queryHotelListBySceniclId(@RequestBody Long scenicId){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryHotelNearScenicArea(scenicId);

        //hotel转NewHotel
        /*List<NewHotel> NewHotelList=new LinkedList<>();
        for( int i = 0 ; i < hotelList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            Hotel tempHotel=hotelList.get(i);
            NewHotel newHotel=new NewHotel(tempHotel);
            NewHotelList.add(newHotel);
        }*/

        if(hotelList != null){
            result.setData(hotelList);
        }else{
            result.setData(hotelList);
        }
        return Result.success(result.getData());
    }

    //通过条件查找酒店总数
    @PostMapping("/CountHotelByCondtion")
    public Result CountHotelByCondtion(@RequestBody Hotel hotel){
        Long count =this.hotelService.countByConditions(hotel);
        return  Result.success(200,"查询成功",count);
    }


    //查找所有星级酒店
    @PostMapping("/queryAllStarHotel")
    public Result queryAllStarHotel(){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryStarHotel();
        if(hotelList != null){
            result.setData(hotelList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //查找所有非星级酒店
    @PostMapping("/queryAllNoneStarHotel")
    public Result queryAllNoneStarHotel(){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryNoneStarHotel();
        if(hotelList != null){
            result.setData(hotelList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过星级查找酒店
    @PostMapping("/queryAllPreciseStarHotelByExactStarLevel")
    public Result queryAllPreciseStarHotelByExactStarLevel(@RequestBody int StarLevel){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryHotelListByStarLevel(StarLevel);

        if(hotelList != null){
            result.setData(hotelList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过景区Id查找景区的星级酒店
    @PostMapping("/queryStarHotelByScenicId")
    public Result queryStarHotelByScenicId(@RequestBody Long scenicId){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryStarHotelBySceniceId(scenicId);

        //hotel转NewHotel
        /*List<NewHotel> NewHotelList=new LinkedList<>();
        for( int i = 0 ; i < hotelList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            Hotel tempHotel=hotelList.get(i);
            NewHotel newHotel=new NewHotel(tempHotel);
            NewHotelList.add(newHotel);
        }*/

        if(hotelList != null){
            result.setData(hotelList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过景区Id查找景区的非星级酒店
    @PostMapping("/queryNoneStarHotelByScenicId")
    public Result queryNoneStarHotelByScenicId(@RequestBody Long scenicId){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryNoneStarHotelBySceniceId(scenicId);

        //hotel转NewHotel
        /*List<NewHotel> NewHotelList=new LinkedList<>();
        for( int i = 0 ; i < hotelList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            Hotel tempHotel=hotelList.get(i);
            NewHotel newHotel=new NewHotel(tempHotel);
            NewHotelList.add(newHotel);
        }*/

        if(hotelList != null){
            result.setData(hotelList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }


    //通过管理员Id查找管理酒店List
    @PostMapping("/queryHotelListByAdminId")
    public Result queryHotelListByAdminId(@RequestBody Long adminId){
        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryHotelListByAdminId(adminId);

        //hotel转NewHotel
        /*List<NewHotel> NewHotelList=new LinkedList<>();
        for( int i = 0 ; i < hotelList.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            Hotel tempHotel=hotelList.get(i);
            NewHotel newHotel=new NewHotel(tempHotel);
            NewHotelList.add(newHotel);
        }*/

        if(hotelList != null){
            Hotel hotel=hotelList.get(0);
            result.setData(hotel);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }


    //分页查询
    @PostMapping("/queryAllHotelListByPage")
    public Result queryAllHotelListByPage(@RequestBody PageSendMessage pageSendMessage){
        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<Hotel> hotelList =this.hotelService.queryAll();
        if(lastIndex>hotelList.size()){
            lastIndex=hotelList.size();
        }
        List<Hotel> returnHotelList =hotelList.subList(firstIndex,lastIndex);
        PageMessage pageMessage=new PageMessage();
        pageMessage.setHotelPageList(returnHotelList);
        pageMessage.setTotalResult(hotelList.size());
        pageMessage.setTotalPage(hotelList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(hotelList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }

    @PostMapping("/queryAllHotel")
    public Result queryAllHotel(){

        Result result = new Result();
        List<Hotel> hotelList = this.hotelService.queryAll();
        /*List<Long> hotelIdList = new LinkedList<>();
        for(int i=0;i<hotelList.size();i++){
            Hotel hotel = hotelList.get(i);
            hotelIdList.add(hotel.getHotelId());
        }*/

        if(hotelList != null){
            result.setData(hotelList);
            return Result.success(result.getData());
        }else{
            result.setData(hotelList);
            return Result.success(result.getData());
        }
    }


}

