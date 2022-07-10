package com.example.Klein.controller;

import com.example.Klein.entity.RoomOrder;
import com.example.Klein.service.RoomOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单实体表(RoomOrder)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:45:03
 */
@RestController
@RequestMapping("roomOrder")
public class RoomOrderController {
    /**
     * 服务对象
     */
    @Resource
    private RoomOrderService roomOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RoomOrder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.roomOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param roomOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RoomOrder> add(RoomOrder roomOrder) {
        return ResponseEntity.ok(this.roomOrderService.insert(roomOrder));
    }

    /**
     * 编辑数据
     *
     * @param roomOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RoomOrder> edit(RoomOrder roomOrder) {
        return ResponseEntity.ok(this.roomOrderService.update(roomOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.roomOrderService.deleteById(id));
    }

}

