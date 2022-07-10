package com.example.Klein.controller;

import com.example.Klein.entity.Entertainment;
import com.example.Klein.entity.ScenicArea;
import com.example.Klein.entity.User;
import com.example.Klein.service.EntertainmentService;
import com.example.Klein.service.ScenicAreaService;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 餐饮娱乐实体表(Entertainment)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:41:52
 */
@RestController
@RequestMapping("entertainment")
public class EntertainmentController {
    /**
     * 服务对象
     */
    @Resource
    private EntertainmentService entertainmentService;

    @Resource
    private ScenicAreaService scenicAreaService;

    /**
     * 通过主键查询单条数据
     *
     * @param EntertainmentId 主键
     * @return 单条数据
     */
    @PostMapping("/queryById")
    public Result queryById(@RequestBody long EntertainmentId){
        return Result.success(this.entertainmentService.queryById(EntertainmentId));
    }

    /**
     * 新增数据
     *
     * @param entertainment 实体
     * @return 新增结果
     */
    @PostMapping("/EntertainmentAdd")
    public Result EntertainmentAdd(@RequestBody Entertainment entertainment) {
        if(entertainment.getEntertainmentId()!=null){
            return Result.fail(400,"主键不允许自定义增加",entertainment);
        }
        if(entertainment.getScenicAreaId()==null){
            return Result.fail(400,"增加对象时外键不允许为空",entertainment);
        }
        if(entertainment.getScenicAreaId()!=null){
            ScenicArea scenicArea=scenicAreaService.queryById(entertainment.getScenicAreaId());
            if (scenicArea==null){
                return Result.fail(400,"外键scenicArea在表中不存在",entertainment);
            }
        }
        //正式添加
        Entertainment _entertainment = this.entertainmentService.insert(entertainment);
        try {
            return Result.success(200, "添加成功", _entertainment);
        } catch (Exception e) {
            return Result.fail(402, "添加失败", _entertainment.getEntertainmentId());
        }
    }

    /**
     * 编辑数据
     *
     * @param entertainment 实体
     * @return 编辑结果
     */
    @PostMapping("/updateEntertainment")
    public Result updateEntertainment(@RequestBody Entertainment entertainment) {
        if(entertainment.getEntertainmentId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }
        Entertainment Testentertainment=this.entertainmentService.queryById(entertainment.getEntertainmentId());
        if(Testentertainment==null){
            return Result.fail(400,"表中无此主键ID对应的数据",null);
                }
        if (entertainment.getScenicAreaId() != null) {
            return Result.fail(400, "不允许修改外键ScenicAreaId,此项必须为空", null);
        }
        Entertainment _entertainment = this.entertainmentService.update(entertainment);
        if (_entertainment != null) {
            return Result.success(200, "更新成功", _entertainment);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }
    /**
     * 删除数据
     *
     * @param entertainmentId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteEntertainmentById")
    public Result deleteEntertainmentById(@RequestBody Long entertainmentId) {
        Entertainment _entertainment=this.entertainmentService.queryById(entertainmentId);
        if(_entertainment==null){
            return Result.fail(400,"数据库不存在ID对应的列",null);
        }
        boolean mark = this.entertainmentService.deleteById(entertainmentId);
        if(mark){
            return Result.success(200,"删除成功",null);
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

    //通过景区ID查询娱乐列表
    @PostMapping("/queryEntertainmentListByAreaId")
    public Result queryEntertainmentListByAreaId(@RequestBody Long scenicAreaId){
        Result result = new Result();
        List<Entertainment> entertainmentList = this.entertainmentService.queryListByScenicID(scenicAreaId);
        if(entertainmentList != null){
            result.setData(entertainmentList);
            return Result.success(result.getData());
        }else{
            result.setData(scenicAreaId);
            return Result.success(result.getData());
        }
        //return Result.success(result.getData());
    }

    //通过景区名字查询娱乐列表
    @PostMapping("/queryEntertainmentListByAreaName")
    public Result queryEntertainmentListByAreaName(@RequestBody String AreaName){

        //Postman中传的参数可能会带双引号，以致测试结果不通过，故而删去双引号
        AreaName=AreaName.replace("\"","");

        Result result = new Result();
        List<Entertainment> entertainmentList = this.entertainmentService.queryListByScenicName(AreaName);
        if(entertainmentList != null){
            result.setData(entertainmentList);
        }else{
            result.setData(AreaName);
        }
        return Result.success(result.getData());
    }

    @PostMapping("/BatchInsertEntertainment")
    public Result BatchInsertEntertainment(@RequestBody List<Entertainment> entertainmentList){
        Result result = new Result();
        int r=this.entertainmentService.BatchInsert(entertainmentList);
        if(r==1){
            return result.success(200,"批量添加成功",null);
        }
        else{
            return result.fail(400,"批量添加失败",null);
        }
    }

    @PostMapping("/CountByCondtion")
    public Result CountByCondtion(@RequestBody Entertainment entertainment){
        Long count =this.entertainmentService.countByConditions(entertainment);
        return  Result.success(200,"查询成功",count);
    }

}

