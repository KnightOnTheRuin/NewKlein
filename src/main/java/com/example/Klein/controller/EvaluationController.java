package com.example.Klein.controller;

import com.example.Klein.entity.*;
import com.example.Klein.service.EntertainmentService;
import com.example.Klein.service.EvaluationService;
import com.example.Klein.service.UserService;
import com.example.Klein.utils.PageMessage;
import com.example.Klein.utils.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 游客对酒店评价(Evaluation)表控制层
 *
 * @author makejava
 * @since 2022-07-13 08:26:19
 */
@RestController
@RequestMapping("evaluation")
public class EvaluationController {
    /**服务对象*/
    @Resource
    private EvaluationService evaluationService;

    @Resource
    private EntertainmentService entertainmentService;

    @Resource
    private UserService userService;

    /*@GetMapping
    public ResponseEntity<Page<Evaluation>> queryByPage(Evaluation evaluation, PageRequest pageRequest) {
        return ResponseEntity.ok(this.evaluationService.queryByPage(evaluation, pageRequest));
    }*/

    /*通过主键查询单条数据*/
    @PostMapping("/queryById")
    public Result queryById(@RequestBody Long EvaluationId){
        return Result.success(this.evaluationService.queryById(EvaluationId));
    }

    /*新增数据*/
    @PostMapping("/addEvaluation")
    public Result addEvaluation(@RequestBody Evaluation evaluation) {
        if(evaluation.getEvaluationId()!=null){
            return Result.fail(400,"主键不允许自定义增加",evaluation);
        }
        /*if(evaluation.getVisitorId()==null||evaluation.getOrderId()==null){
            return Result.fail(400,"增加对象时外键不允许为空",evaluation);
        }
        Entertainment entertainment=this.entertainmentService.queryById(evaluation.getOrderId());
        User user=this.userService.queryById(evaluation.getVisitorId());
        if(entertainment==null||user==null){
            return Result.fail(400,"外键在其表里不存在对应的数据",null);
        }*/

        //正式添加
        Evaluation _evaluation=this.evaluationService.insert(evaluation);
        try {
            return Result.success(200, "添加成功", _evaluation);
        } catch (Exception e) {
            return Result.fail(402, "添加失败", _evaluation);
        }
    }

    /*编辑数据*/
    @PostMapping("/updateEvaluation")
    public Result updateEvaluation(@RequestBody Evaluation evaluation) {
        if(evaluation.getEvaluationId()==null){
            return Result.fail(400,"必须经过主键进行更新但主键为空",null);
        }

        Entertainment entertainment=this.entertainmentService.queryById(evaluation.getOrderId());
        User user=this.userService.queryById(evaluation.getVisitorId());
        if(entertainment==null||user==null){
            return Result.fail(400,"外键在其表里不存在对应的数据",null);
        }

        Evaluation _evaluation=this.evaluationService.update(evaluation);
        if (_evaluation != null) {
            return Result.success(200, "更新成功", _evaluation);
        } else {
            return Result.fail(400, "更新失败", null);
        }
    }

    /*删除数据*/
    @PostMapping("/deleteEvaluationById")
    public Result deleteEvaluationById(@RequestBody Long EvaluationId) {
        Evaluation _evaluation=this.evaluationService.queryById(EvaluationId);
        if(_evaluation==null){
            return Result.fail(400,"数据库不存在ID对应的列",null);
        }

        boolean mark = this.evaluationService.deleteById(EvaluationId);
        if(mark){
            return Result.success(200,"删除成功",null);
        }else{
            return Result.fail(400,"删除失败",null);
        }
    }

    /*通过娱乐ID分页查询评论*/
    @PostMapping("/queryEvaluationListByEntertainmentId")
    public Result queryEvaluationListByEntertainmentId(@RequestBody PageSendMessage pageSendMessage) {
        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<Evaluation> evaluationList=this.evaluationService.
                queryEvaluationByEntertainmentId(pageSendMessage.getEntertainmentId());
        if(lastIndex>evaluationList.size()){
            lastIndex=evaluationList.size();
        }
        List<Evaluation> returnEvaluationList=evaluationList.subList(firstIndex,lastIndex);


        PageMessage pageMessage=new PageMessage();
        pageMessage.setEvaluationList(returnEvaluationList);
        pageMessage.setTotalResult(evaluationList.size());
        pageMessage.setTotalPage(evaluationList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(evaluationList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }
    /*通过游客ID查询娱乐评论*/
    @PostMapping("/queryEvaluationListByVisitorId")
    public Result queryEvaluationListByVisitorId(@RequestBody PageSendMessage pageSendMessage) {
        //数据解封
        int currentPage,PageSize;
        currentPage=pageSendMessage.getCurrentPage();
        PageSize=pageSendMessage.getPageSize();
        int firstIndex=(currentPage-1)*PageSize;
        int lastIndex=currentPage*PageSize;

        //实现分页并封装
        Result result = new Result();
        List<Evaluation> evaluationList=this.evaluationService.
                queryEvaluationByVisitorId(pageSendMessage.getUserId());
        if(lastIndex>evaluationList.size()){
            lastIndex=evaluationList.size();
        }
        List<Evaluation> returnEvaluationList=evaluationList.subList(firstIndex,lastIndex);


        PageMessage pageMessage=new PageMessage();
        pageMessage.setEvaluationList(returnEvaluationList);
        pageMessage.setTotalResult(evaluationList.size());
        pageMessage.setTotalPage(evaluationList.size()/PageSize+1);
        pageMessage.setTotal(lastIndex-firstIndex);

        if(evaluationList != null){
            result.setData(pageMessage);
            return Result.success(result.getData());
        }else{
            result.setData(currentPage);
            return Result.success(result.getData());
        }
    }

}

