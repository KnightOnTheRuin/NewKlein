package com.example.Klein.controller;

import com.example.Klein.entity.ScenicArea;
import com.example.Klein.service.ScenicAreaService;
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
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/querySAById")
    public Result querySAById(@RequestBody Long id) {
        return Result.success(this.scenicAreaService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param scenicArea 实体
     * @return 新增结果
     */
    @PostMapping("/addSA")
    public Result addSA(@RequestBody ScenicArea scenicArea) {
        try{
            ScenicArea sa =  this.scenicAreaService.insert(scenicArea);
            return Result.success(200,"添加成功",sa);
        }catch (Exception e){
            return Result.fail(402,"添加失败",null);
        }
    }

    /**
     * 编辑数据
     *
     * @param scenicArea 实体
     * @return 编辑结果
     */
    @PutMapping("/editSA")
    public Result editSA(@RequestBody ScenicArea scenicArea) {
        ScenicArea sa = this.scenicAreaService.update(scenicArea);
        if(sa != null){
            return Result.success(200,"更新成功",sa);
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
    @DeleteMapping("/deleteSAById")
    public Result deleteSAById(@RequestBody Long id) {
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

    //通过名字精确搜索
    @PostMapping("/querySAByName")
    public Result querySAByName(@RequestBody String name){
        return Result.success(this.scenicAreaService.queryByName(name));
    }


}

