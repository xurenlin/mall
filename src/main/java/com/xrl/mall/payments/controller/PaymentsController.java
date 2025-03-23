package com.xrl.mall.payments.controller;

import com.xrl.mall.payments.service.PaymentsService;
import com.xrl.mall.payments.entity.Payments;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/payments/payments")
@Tag(name = "PaymentsController", description = "")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping
    @Operation(summary = "新增")
    public boolean save(@Parameter(description = "实体") @RequestBody Payments payments) {
        return paymentsService.saveOrUpdate(payments);
    }

    @PutMapping
    @Operation(summary = "更新")
    public boolean update(@Parameter(description = "实体") @RequestBody Payments payments) {
        return paymentsService.updateById(payments);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public boolean delete(@Parameter(description = "ID") @PathVariable Long id) {
        return paymentsService.removeById(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询单个")
    public Payments getById(@Parameter(description = "ID") @PathVariable Long id) {
        return paymentsService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询列表")
    public List<Payments> list() {
        return paymentsService.list();
    }
}