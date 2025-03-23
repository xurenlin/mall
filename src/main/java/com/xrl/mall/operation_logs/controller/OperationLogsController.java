package com.xrl.mall.operation_logs.controller;

import com.xrl.mall.operation_logs.service.OperationLogsService;
import com.xrl.mall.operation_logs.entity.OperationLogs;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/operation_logs/operationLogs")
@Tag(name = "OperationLogsController", description = "")
public class OperationLogsController {

    @Autowired
    private OperationLogsService operationLogsService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody OperationLogs operationLogs) {
        return operationLogsService.saveOrUpdate(operationLogs);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody OperationLogs operationLogs) {
        return operationLogsService.updateById(operationLogs);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return operationLogsService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public OperationLogs getById(@Parameter(description = "ID") @PathVariable Long id) {
        return operationLogsService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<OperationLogs> list() {
        return operationLogsService.list();
    }
}