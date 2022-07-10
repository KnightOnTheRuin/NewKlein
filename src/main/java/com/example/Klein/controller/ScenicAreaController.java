package com.example.Klein.controller;

import com.example.Klein.entity.ScenicArea;
import com.example.Klein.service.ScenicAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @GetMapping("{id}")
    public ResponseEntity<ScenicArea> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.scenicAreaService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param scenicArea 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ScenicArea> add(ScenicArea scenicArea) {
        return ResponseEntity.ok(this.scenicAreaService.insert(scenicArea));
    }

    /**
     * 编辑数据
     *
     * @param scenicArea 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ScenicArea> edit(ScenicArea scenicArea) {
        return ResponseEntity.ok(this.scenicAreaService.update(scenicArea));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.scenicAreaService.deleteById(id));
    }

}

