package com.xrl.mall.order_items.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "")
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "")
    private Long id;
    @Schema(description = "")
    private Long orderId;
    @Schema(description = "")
    private Long productId;
    @Schema(description = "")
    private Integer quantity;
    @Schema(description = "")
    private BigDecimal price;
    @Schema(description = "")
    private BigDecimal totalAmount;
}