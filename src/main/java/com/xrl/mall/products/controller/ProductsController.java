package com.xrl.mall.products.controller;

import com.xrl.mall.products.service.ProductsService;
import com.xrl.mall.products.entity.Products;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/products/products")
@Tag(name = "ProductsController", description = "")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody Products products) {
        return productsService.saveOrUpdate(products);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody Products products) {
        return productsService.updateById(products);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return productsService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public Products getById(@Parameter(description = "ID") @PathVariable Long id) {
        return productsService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<Products> list() {
        return productsService.list();
    }
}