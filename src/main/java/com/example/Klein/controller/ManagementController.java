package com.example.Klein.controller;

import com.example.Klein.entity.Management;
import com.example.Klein.service.ManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 酒店管理员管理酒店关系表(Management)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:43:46
 */
@RestController
@RequestMapping("management")
public class ManagementController {
    /**
     * 服务对象
     */
    @Resource
    private ManagementService managementService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Management> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.managementService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param management 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Management> add(Management management) {
        return ResponseEntity.ok(this.managementService.insert(management));
    }

    /**
     * 编辑数据
     *
     * @param management 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Management> edit(Management management) {
        return ResponseEntity.ok(this.managementService.update(management));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.managementService.deleteById(id));
    }

}

