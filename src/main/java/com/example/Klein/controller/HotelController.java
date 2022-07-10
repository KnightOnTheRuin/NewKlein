package com.example.Klein.controller;

import com.example.Klein.entity.Hotel;
import com.example.Klein.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 酒店实体表(Hotel)表控制层
 *
 * @author makejava
 * @since 2022-07-10 13:42:44
 */
@RestController
@RequestMapping("hotel")
public class HotelController {
    /**
     * 服务对象
     */
    @Resource
    private HotelService hotelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Hotel> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.hotelService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param hotel 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Hotel> add(Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.insert(hotel));
    }

    /**
     * 编辑数据
     *
     * @param hotel 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Hotel> edit(Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.update(hotel));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.hotelService.deleteById(id));
    }

}

