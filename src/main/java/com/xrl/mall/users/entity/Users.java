package com.xrl.mall.users.entity;

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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "")
    private Long id;
    @Schema(description = "")
    private String username;
    @Schema(description = "")
    private String password;
    @Schema(description = "")
    private String email;
    @Schema(description = "")
    private String phone;
    @Schema(description = "")
    private String role;
    @Schema(description = "")
    private String status;
    @Schema(description = "")
    private LocalDateTime createdAt;
    @Schema(description = "")
    private LocalDateTime updatedAt;
}