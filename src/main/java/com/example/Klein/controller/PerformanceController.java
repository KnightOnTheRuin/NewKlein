package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.PerformanceService;
import com.example.Klein.service.ScenicAreaService;
import com.example.Klein.utils.PageMessage;
import com.example.Klein.utils.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 演出实体表(Performance)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:44:44
 */
@RestController
@RequestMapping("performance")
public class PerformanceController {
    /**
     * 服务对象
     */
    @Resource
    private PerformanceService performanceService;

    @Resource
    private ScenicAreaService scenicAreaService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/queryPFMCById")
    public Result queryPFMCById(@RequestBody Long id) {
        return Result.success(this.performanceService.queryById(id));
    }


    /**
     * 新增数据
     *
     * @param performance 实体
     * @return 新增结果
     */
    @PostMapping("/addPFMC")
    public Result addPFMC(@RequestBody Performance performance) {
        try{

            if(performance.getPerformanceId()!=null){
                return Result.fail(400,"主键不允许自定义增加",performance);
            }
            if(performance.getScenicAreaId()==null){
                return Result.fail(400,"增加对象时ScenicArea外键不允许为空",performance);
            }
            ScenicArea TestscenicArea=this.scenicAreaService.queryById(performance.getScenicAreaId());

            if (TestscenicArea==null){
                return Result.fail(400,"外键ScenicAreaId在表中不存在",performance);
            }

            //正式添加
            Performance _performance=this.performanceService.insert(performance);
            return Result.success(200,"添加成功",_performance);
        }catch (Exception e){
            return Result.fail(402,"添加失败",null);
        }
    }
    /**
     * 编辑数据
     *
     * @param performance 实体
     * @return 编辑结果
     */
    @PostMapping("/editPFMC")
    public Result editPFMC(@RequestBody Performance performance) {

        if(performance.getPerformanceId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        Performance TestPerformance=this.performanceService.queryById(performance.getPerformanceId());
        if(TestPerformance==null){
            return Result.fail(400,"Performance表中无此主键ID对应的数据",null);
        }
        ScenicArea scenicArea=this.scenicAreaService.queryById(performance.getScenicAreaId());
        if(scenicArea==null){
            return Result.fail(400,"外键在scenicArea表中无对应的数据",null);
        }
        Performance _performance=this.performanceService.update(performance);
        if (_performance != null) {
            return Result.success(200, "更新成功", _performance);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deletePFMCById")
    public Result deletePFMCById(@RequestBody Long id) {
        Performance performance=this.performanceService.queryById(id);
        if(performance==null){
            return Result.fail(400,"Id对应的实体在表中不存在",id);
        }
        boolean mark = this.performanceService.deleteById(id);
        if(mark) {
            return Result.success(this.performanceService.deleteById(id));
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

    //通过条件计数Performance总数
    @PostMapping("/CountPerformanceByConditions")
    public Result CountPerformanceByConditions(@RequestBody Performance performance){
        Long count =this.performanceService.CountByConditions(performance);
        return  Result.success(200,"查询成功",count);
    }

    //通过景区ID查找Performance表单
    @PostMapping("/queryPerformanceListByScenicId")
    public Result queryPerformanceListByScenicId(@RequestBody Long ScenicId){
        Result result = new Result();
        List<Performance> performanceList = this.performanceService.queryPerformanceListByScenicAreaId(ScenicId);
        if(performanceList != null){
            result.setData(performanceList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    //通过景区ID查找Performance表单
    @PostMapping("/queryPerformanceListByScenicName")
    public Result queryPerformanceListByScenicName(@RequestBody String scenicName){
        scenicName=scenicName.replace("\"","");
        Result result = new Result();
        List<Performance> performanceList = this.performanceService.queryPerformanceListByScenicAreaName(scenicName);
        if(performanceList != null){
            result.setData(performanceList);
        }else{
            result.setData(null);
        }
        return Result.success(result.getData());
    }

    @PostMapping("/queryAllPerformanceListByPage")
    public Result queryAllPerformanceListByPage(@RequestBody PageSendMessage pageSendMessage){
        //前期准备
        //List<Performance> returnPerformanceList=new LinkedList<>();
        PageMessage pageMessage=new PageMessage();
        String dimName = "%%"+pageSendMessage.getPerformanceDimName()+"%%";
        pageSendMessage.setPerformanceDimName(dimName);

        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<Performance> performanceList =this.performanceService.queryAll();
        if(lastIndex>performanceList.size()){
            lastIndex=performanceList.size();
        }
        List<Performance> returnPerformanceList =performanceList.subList(firstIndex,lastIndex);
        List<Performance> dimNamePerformanceList=this.performanceService.queryByName(pageSendMessage.getPerformanceDimName());

        if(pageSendMessage.getPerformanceDimName()==null||pageSendMessage.getPerformanceDimName()=="%%%%"){
            if(lastIndex>performanceList.size()){
                lastIndex=performanceList.size();
            }
            returnPerformanceList =performanceList.subList(firstIndex,lastIndex);
            pageMessage.setTotalResult(performanceList.size());
            pageMessage.setTotalPage(performanceList.size()/PageSize+1);
        }
        else{
            if(lastIndex>dimNamePerformanceList.size()){
                lastIndex=dimNamePerformanceList.size();
            }
            returnPerformanceList =dimNamePerformanceList.subList(firstIndex,lastIndex);
            pageMessage.setTotalResult(dimNamePerformanceList.size());
            pageMessage.setTotalPage(dimNamePerformanceList.size()/PageSize+1);
        }
        pageMessage.setPerformancePageList(returnPerformanceList);
        //pageMessage.setTotalResult(performanceList.size());
        //pageMessage.setTotalPage(performanceList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(performanceList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }
}

