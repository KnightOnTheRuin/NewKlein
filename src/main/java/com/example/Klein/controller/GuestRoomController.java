package com.example.Klein.controller;

import com.example.Klein.entity.GuestRoom;
import com.example.Klein.service.GuestRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 客房实体表(GuestRoom)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:42:22
 */
@RestController
@RequestMapping("guestRoom")
public class GuestRoomController {
    /**
     * 服务对象
     */
    @Resource
    private GuestRoomService guestRoomService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GuestRoom> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.guestRoomService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param guestRoom 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<GuestRoom> add(GuestRoom guestRoom) {
        return ResponseEntity.ok(this.guestRoomService.insert(guestRoom));
    }

    /**
     * 编辑数据
     *
     * @param guestRoom 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<GuestRoom> edit(GuestRoom guestRoom) {
        return ResponseEntity.ok(this.guestRoomService.update(guestRoom));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.guestRoomService.deleteById(id));
    }

}

