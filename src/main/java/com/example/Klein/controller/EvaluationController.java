package com.example.Klein.controller;

import com.example.Klein.entity.Evaluation;
import com.example.Klein.service.EvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    /*@GetMapping
    public ResponseEntity<Page<Evaluation>> queryByPage(Evaluation evaluation, PageRequest pageRequest) {
        return ResponseEntity.ok(this.evaluationService.queryByPage(evaluation, pageRequest));
    }*/

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Evaluation> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.evaluationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param evaluation 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Evaluation> add(Evaluation evaluation) {
        return ResponseEntity.ok(this.evaluationService.insert(evaluation));
    }

    /**
     * 编辑数据
     *
     * @param evaluation 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Evaluation> edit(Evaluation evaluation) {
        return ResponseEntity.ok(this.evaluationService.update(evaluation));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.evaluationService.deleteById(id));
    }

}

