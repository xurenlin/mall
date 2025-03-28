package com.xrl.mall.common.enums;

import lombok.Getter;

/***
 *@title ResultCode
 *@description
 *  * 系统状态码枚举类
 *  * 规范：
 *  * 1. 标准HTTP状态码遵循RFC协议（200~599）
 *  * 2. 业务自定义状态码从1000开始递增
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/27 20:58
 **/
@Getter
public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(200, "操作成功"),

    /* 客户端错误 */
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),

    /* 服务端错误 */
    INTERNAL_SERVER_ERROR(500, "系统内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),

    /* 业务自定义错误（示例） */
    USER_NOT_FOUND(1001, "用户不存在"),
    DUPLICATE_USERNAME(1002, "用户名已存在"),
    INVALID_PASSWORD(1003, "密码格式错误"),
    ORDER_CREATE_FAILED(2001, "订单创建失败"),
    STOCK_NOT_ENOUGH(2002, "库存不足");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据状态码查找枚举
     */
    public static ResultCode getByCode(Integer code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return null;
    }

    /**
     * 判断是否包含指定状态码
     */
    public static boolean containsCode(Integer code) {
        return getByCode(code) != null;
    }
}
