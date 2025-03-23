package com.xrl.mall.payments.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "")
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "")
    private Long id;
    @Schema(description = "")
    private Long orderId;
    @Schema(description = "")
    private String paymentMethod;
    @Schema(description = "")
    private String paymentStatus;
    @Schema(description = "")
    private BigDecimal amount;
    @Schema(description = "")
    private String transactionId;
    @Schema(description = "")
    private LocalDateTime createdAt;
}