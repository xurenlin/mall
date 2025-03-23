package com.xrl.mall.operation_logs.entity;

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
public class OperationLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "")
    private Long id;
    @Schema(description = "")
    private Long userId;
    @Schema(description = "")
    private String operationType;
    @Schema(description = "")
    private String description;
    @Schema(description = "")
    private LocalDateTime createdAt;
}