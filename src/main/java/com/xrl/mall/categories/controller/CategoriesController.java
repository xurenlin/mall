package com.xrl.mall.categories.controller;

import com.xrl.mall.categories.service.CategoriesService;
import com.xrl.mall.categories.entity.Categories;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/categories/categories")
@Tag(name = "CategoriesController", description = "")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody Categories categories) {
        return categoriesService.saveOrUpdate(categories);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody Categories categories) {
        return categoriesService.updateById(categories);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return categoriesService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public Categories getById(@Parameter(description = "ID") @PathVariable Long id) {
        return categoriesService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<Categories> list() {
        return categoriesService.list();
    }
}