package com.xrl.mall.users.controller;

import com.xrl.mall.users.service.UsersService;
import com.xrl.mall.users.entity.Users;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/users/users")
@Tag(name = "UsersController", description = "")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody Users users) {
        return usersService.saveOrUpdate(users);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody Users users) {
        return usersService.updateById(users);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return usersService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public Users getById(@Parameter(description = "ID") @PathVariable Long id) {
        return usersService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<Users> list() {
        return usersService.list();
    }
}