package com.xrl.mall.order_items.controller;

import com.xrl.mall.order_items.service.OrderItemsService;
import com.xrl.mall.order_items.entity.OrderItems;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/order_items/orderItems")
@Tag(name = "OrderItemsController", description = "")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody OrderItems orderItems) {
        return orderItemsService.saveOrUpdate(orderItems);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody OrderItems orderItems) {
        return orderItemsService.updateById(orderItems);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return orderItemsService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public OrderItems getById(@Parameter(description = "ID") @PathVariable Long id) {
        return orderItemsService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<OrderItems> list() {
        return orderItemsService.list();
    }
}