package com.xrl.mall.user_tokens.controller;

import com.xrl.mall.user_tokens.service.UserTokensService;
import com.xrl.mall.user_tokens.entity.UserTokens;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/user_tokens/userTokens")
@Tag(name = "UserTokensController", description = "")
public class UserTokensController {

    @Autowired
    private UserTokensService userTokensService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody UserTokens userTokens) {
        return userTokensService.saveOrUpdate(userTokens);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody UserTokens userTokens) {
        return userTokensService.updateById(userTokens);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return userTokensService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public UserTokens getById(@Parameter(description = "ID") @PathVariable Long id) {
        return userTokensService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<UserTokens> list() {
        return userTokensService.list();
    }
}