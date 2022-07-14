package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.HotelService;
import com.example.Klein.service.NearlyService;
import com.example.Klein.service.ScenicAreaService;
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

    @Resource
    private HotelService hotelService;

    @Resource
    private ScenicAreaService scenicAreaService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("queryNearlyById")
    public Result queryNearlyById(@RequestBody Long id) {
        return Result.success(this.nearlyService.queryById(id));
    }


    /**
     * 新增数据
     * @param nearly 实体
     * @return 新增结果
     */
    @PostMapping("/addNearly")
    public Result addNearly(@RequestBody Nearly nearly) {
        try{
            if(nearly.getNearlyId()!=null){
                return Result.fail(400,"主键不允许自定义增加",nearly);
            }
            if(nearly.getHotelId()==null||nearly.getScenicAreaId()==null){
                return Result.fail(400,"增加对象时外键不允许为空",nearly);
            }
            Hotel TestHotel=this.hotelService.queryById(nearly.getHotelId());
            if (TestHotel==null){
                return Result.fail(400,"外键HotelId在表中不存在",nearly);
            }
            ScenicArea TestScenicArea=this.scenicAreaService.queryById(nearly.getScenicAreaId());
            if (TestScenicArea==null){
                return Result.fail(400,"外键ScenicAreaId在表中不存在",nearly);
            }
            //正式添加
            Nearly _nearly=this.nearlyService.insert(nearly);
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
    @PostMapping("/editNearly")
    public Result editNealy(@RequestBody Nearly nearly) {

        if(nearly.getNearlyId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        Hotel TestHotel=this.hotelService.queryById(nearly.getHotelId());
        if(TestHotel==null){
            return Result.fail(400,"Hotel表中无此主键ID对应的数据",null);
        }
        ScenicArea scenicArea=this.scenicAreaService.queryById(nearly.getScenicAreaId());
        if(scenicArea==null){
            return Result.fail(400,"scenicArea表中无此主键ID对应的数据",null);
        }
        Nearly _nearly=this.nearlyService.update(nearly);
        if (_nearly != null) {
            return Result.success(200, "更新成功", _nearly);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }

    /**
     * 删除数据
     *
     * @param
     * @return 删除是否成功
     */
    @PostMapping("/deleteNearlyById")
    public Result deleteTNById(@RequestBody Long nearlyId) {
        Nearly _nearly=this.nearlyService.queryById(nearlyId);
        if(_nearly==null){
            return Result.fail(400,"数据库不存在nearlyID对应的列",null);
        }
        boolean mark = this.nearlyService.deleteById(nearlyId);
        if(mark) {
            return Result.success(this.nearlyService.deleteById(nearlyId));
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }
    //通过条件计数Nearly总数
    @PostMapping("/CountNearlyByConditions")
    public Result CountNearlyByConditions(@RequestBody Nearly nearly){
        Long count =this.nearlyService.count(nearly);
        return  Result.success(200,"查询成功",count);
    }


}

