package com.xrl.mall.operation_logs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xrl
 * @since 2025-03-23
 */
@Getter
@Setter
@TableName("operation_logs")
public class OperationLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("operation_type")
    private String operationType;

    @TableField("description")
    private String description;

    @TableField("created_at")
    private LocalDateTime createdAt;
}
