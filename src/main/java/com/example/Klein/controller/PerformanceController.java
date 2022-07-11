package com.example.Klein.controller;

import com.example.Klein.entity.Hotel;
import com.example.Klein.entity.Nearly;
import com.example.Klein.entity.Performance;
import com.example.Klein.service.PerformanceService;
import com.example.Klein.utils.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryPFMCById")
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
            Performance _performance =  this.performanceService.insert(performance);
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
    @PutMapping("/editPFMC")
    public Result editPFMC(@RequestBody Performance performance) {
        Performance _performance = this.performanceService.update(performance);
        if(_performance != null){
            return Result.success(200,"更新成功",_performance);
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
    @DeleteMapping("/deletePFMCById")
    public Result deletePFMCById(@RequestBody Long id) {
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
}

