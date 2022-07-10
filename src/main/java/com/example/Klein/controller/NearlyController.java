package com.example.Klein.controller;

import com.example.Klein.entity.Nearly;
import com.example.Klein.service.NearlyService;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Node;

import javax.annotation.Resource;

/**
 * 景区附近的酒店关系表(Nearly)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:44:22
 */
@RestController
@RequestMapping("nearly")
public class NearlyController {
    /**
     * 服务对象
     */
    @Resource
    private NearlyService nearlyService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryNearlyById")
    public Result queryNearlyById(@RequestBody Long id) {
        return Result.success(this.nearlyService.queryById(id));
    }


    /**
     * 新增数据
     *
     * @param nearly 实体
     * @return 新增结果
     */
    @PostMapping("/addNearly")
    public Result addNearly(@RequestBody Nearly nearly) {
        try{
            Nearly _nearly =  this.nearlyService.insert(nearly);
            return Result.success(200,"添加成功",_nearly);
        }catch (Exception e){
            return Result.fail(402,"添加失败",null);
        }
    }
    /**
     * 编辑数据
     *
     * @param nearly 实体
     * @return 编辑结果
     */
    @PutMapping("/editNearly")
    public Result editNealy(@RequestBody Nearly nearly) {

        Nearly _nearly = this.nearlyService.update(nearly);
        if(_nearly != null){
            return Result.success(200,"更新成功",_nearly);
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
    @DeleteMapping("/deleteNearlyById")
    public Result deleteTNById(@RequestBody Long id) {
        boolean mark = this.nearlyService.deleteById(id);
        if(mark) {
            return Result.success(this.nearlyService.deleteById(id));
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

}

