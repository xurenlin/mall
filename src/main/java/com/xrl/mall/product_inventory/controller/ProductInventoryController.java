package com.xrl.mall.product_inventory.controller;

import com.xrl.mall.product_inventory.service.ProductInventoryService;
import com.xrl.mall.product_inventory.entity.ProductInventory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/product_inventory/productInventory")
@Tag(name = "ProductInventoryController", description = "")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody ProductInventory productInventory) {
        return productInventoryService.saveOrUpdate(productInventory);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody ProductInventory productInventory) {
        return productInventoryService.updateById(productInventory);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return productInventoryService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public ProductInventory getById(@Parameter(description = "ID") @PathVariable Long id) {
        return productInventoryService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<ProductInventory> list() {
        return productInventoryService.list();
    }
}