package com.example.Klein.controller;

import com.example.Klein.entity.Performance;
import com.example.Klein.service.PerformanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @GetMapping("{id}")
    public ResponseEntity<Performance> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.performanceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param performance 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Performance> add(Performance performance) {
        return ResponseEntity.ok(this.performanceService.insert(performance));
    }

    /**
     * 编辑数据
     *
     * @param performance 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Performance> edit(Performance performance) {
        return ResponseEntity.ok(this.performanceService.update(performance));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.performanceService.deleteById(id));
    }

}

