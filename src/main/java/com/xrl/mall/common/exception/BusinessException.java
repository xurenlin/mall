package com.xrl.mall.common.exception;

import com.xrl.mall.common.enums.ResultCode;
import lombok.Getter;

/***
 *@title BusinessException
 *@description <TODO description class purpose>
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/27 20:54
 **/
@Getter
public class BusinessException extends RuntimeException {

    private final ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
