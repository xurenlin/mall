package com.xrl.mall.common.core;

import com.xrl.mall.common.enums.ResultCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *@title Result
 *@description <TODO description class purpose>
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/27 20:49
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "统一响应结构")
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    private Long timestamp = System.currentTimeMillis();

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }


    // 成功响应（使用状态码枚举）
    public static <T> Result<T> success(ResultCode resultCode, T data) {
        return new Result<>(resultCode.getCode(), resultCode.getMsg(), data);
    }

    // 默认成功响应
    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS, data);
    }

    // 错误响应（使用状态码枚举）
    public static <T> Result<T> error(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMsg(), null);
    }

    // 自定义错误信息（覆盖默认提示）
    public static <T> Result<T> error(ResultCode resultCode, String customMsg) {
        return new Result<>(resultCode.getCode(), customMsg, null);
    }
}
