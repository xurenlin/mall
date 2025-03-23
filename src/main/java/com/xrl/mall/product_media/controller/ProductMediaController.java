package com.xrl.mall.product_media.controller;

import com.xrl.mall.product_media.service.ProductMediaService;
import com.xrl.mall.product_media.entity.ProductMedia;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/product_media/productMedia")
@Tag(name = "ProductMediaController", description = "")
public class ProductMediaController {

    @Autowired
    private ProductMediaService productMediaService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody ProductMedia productMedia) {
        return productMediaService.saveOrUpdate(productMedia);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody ProductMedia productMedia) {
        return productMediaService.updateById(productMedia);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return productMediaService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public ProductMedia getById(@Parameter(description = "ID") @PathVariable Long id) {
        return productMediaService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<ProductMedia> list() {
        return productMediaService.list();
    }
}