package com.xrl.mall.product_media.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "")
public class ProductMedia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "")
    private Long id;
    @Schema(description = "")
    private Long productId;
    @Schema(description = "")
    private String mediaUrl;
    @Schema(description = "")
    private String mediaType;
    @Schema(description = "")
    private LocalDateTime createdAt;
}