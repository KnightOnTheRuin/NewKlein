package com.example.Klein.controller;

import com.example.Klein.entity.Entertainment;
import com.example.Klein.service.EntertainmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Entertainment> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.entertainmentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param entertainment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Entertainment> add(Entertainment entertainment) {
        return ResponseEntity.ok(this.entertainmentService.insert(entertainment));
    }

    /**
     * 编辑数据
     *
     * @param entertainment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Entertainment> edit(Entertainment entertainment) {
        return ResponseEntity.ok(this.entertainmentService.update(entertainment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.entertainmentService.deleteById(id));
    }

}

