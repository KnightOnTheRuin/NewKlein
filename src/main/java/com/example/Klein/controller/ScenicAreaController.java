package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.ScenicAreaService;
import com.example.Klein.utils.PageMessage;
import com.example.Klein.utils.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景区实体表(ScenicArea)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:45:26
 */
@RestController
@RequestMapping("scenicArea")
public class ScenicAreaController {
    /**
     * 服务对象
     */
    @Resource
    private ScenicAreaService scenicAreaService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/querySAById")
    public Result querySAById(@RequestBody Long id) {
        return Result.success(this.scenicAreaService.queryById(id));
    }

    /**
     * 新增数据
     * @param scenicArea 实体
     * @return 新增结果
     */
    @PostMapping("/addSA")
    public Result addSA(@RequestBody ScenicArea scenicArea) {
        try{

            if(scenicArea.getScenicAreaId()!=null){
                return Result.fail(400,"主键不允许自定义增加",scenicArea);
            }
            ScenicArea sa =  this.scenicAreaService.insert(scenicArea);
            return Result.success(200,"添加成功",sa);
        }catch (Exception e){
            return Result.fail(402,"添加失败",null);
        }
    }

    /**
     * 编辑数据
     * @param scenicArea 实体
     * @return 编辑结果
     */
    @PostMapping("/editSA")
    public Result editSA(@RequestBody ScenicArea scenicArea) {
        if(scenicArea.getScenicAreaId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        ScenicArea _scenicArea = this.scenicAreaService.update(scenicArea);
        if(_scenicArea != null){
            return Result.success(200,"更新成功",_scenicArea);
        }else{
            return Result.fail(400,"更新失败",null);
        }
    }



    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteSAById")
    public Result deleteSAById(@RequestBody Long id) {
        ScenicArea scenicArea=this.scenicAreaService.queryById(id);
        if(scenicArea.getScenicAreaId()==null){
            return Result.fail(400,"主键对应数据为空",null);
        }
        boolean mark = this.scenicAreaService.deleteById(id);
        if(mark){
            return Result.success(200,"删除成功",null);
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

    //通过名字模糊查询景区
    @PostMapping("/dimQueryByName")
    public Result dimQueryByName(@RequestBody String dimName){
        Result result = new Result();
        String dimNamein = "%%"+dimName+"%%";
        //去掉双引号
        //dimNamein=dimNamein.replace("\"","");
        List<ScenicArea> scenicareaList = this.scenicAreaService.dimQueryByName(dimNamein);
        if(scenicareaList != null){
            result.setData(scenicareaList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }


    //查询全部景区
    @PostMapping("/queryAllScenic")
    public Result queryAllScenic(){
        Result result = new Result();
        List<ScenicArea> scenicAreaList = this.scenicAreaService.queryAll();
        /*List<Long> hotelIdList = new LinkedList<>();
        for(int i=0;i<hotelList.size();i++){
            Hotel hotel = hotelList.get(i);
            hotelIdList.add(hotel.getHotelId());
        }*/

        if(scenicAreaList != null){
            result.setData(scenicAreaList);
            return Result.success(result.getData());
        }else{
            result.setData(scenicAreaList);
            return Result.success(result.getData());
        }
    }

    //通过名字精确搜索
    @PostMapping("/querySAByName")
    public Result querySAByName(@RequestBody String name){
        return Result.success(this.scenicAreaService.queryByName(name));
    }

    //通过酒店ID查找景区列表
    @PostMapping("/queryScenicListByHotelId")
    public Result queryScenicListByHotelId(@RequestBody Long hotelId){
        Result result = new Result();
        List<ScenicArea> scenicAreaList = this.scenicAreaService.queryScenicListAreaNearHotel(hotelId);
        if(scenicAreaList != null){
            result.setData(scenicAreaList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }
    @PostMapping("/queryAllScenicListByPage")
    public Result queryAllScenicListByPage(@RequestBody PageSendMessage pageSendMessage){
        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<ScenicArea> ScenicList =this.scenicAreaService.queryAll();
        if(lastIndex>ScenicList.size()){
            lastIndex=ScenicList.size();
        }
        List<ScenicArea> returnScenicArea =ScenicList.subList(firstIndex,lastIndex);
        PageMessage pageMessage=new PageMessage();
        pageMessage.setScenicAreaPageList(returnScenicArea);
        pageMessage.setTotalResult(ScenicList.size());
        pageMessage.setTotalPage(ScenicList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(ScenicList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }

}

