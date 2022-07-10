package com.example.Klein.controller;

import com.example.Klein.entity.Nearly;
import com.example.Klein.service.NearlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{id}")
    public ResponseEntity<Nearly> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.nearlyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param nearly 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Nearly> add(Nearly nearly) {
        return ResponseEntity.ok(this.nearlyService.insert(nearly));
    }

    /**
     * 编辑数据
     *
     * @param nearly 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Nearly> edit(Nearly nearly) {
        return ResponseEntity.ok(this.nearlyService.update(nearly));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.nearlyService.deleteById(id));
    }

}

