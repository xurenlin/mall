package com.xrl.mall.products.entity;

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
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "")
    private Long id;
    @Schema(description = "")
    private String name;
    @Schema(description = "")
    private String description;
    @Schema(description = "")
    private BigDecimal price;
    @Schema(description = "")
    private Integer stock;
    @Schema(description = "")
    private Long categoryId;
    @Schema(description = "")
    private String status;
    @Schema(description = "")
    private LocalDateTime createdAt;
    @Schema(description = "")
    private LocalDateTime updatedAt;
}