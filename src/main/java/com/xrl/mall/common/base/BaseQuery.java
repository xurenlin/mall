package com.xrl.mall.common.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/***
 *@title BaseQuery
 *@description <TODO description class purpose>
 *@author xrl
 *@version 1.0.0
 *@create 2025/3/28 20:08
 **/
@Data
public class BaseQuery {

    @Schema(description = "页码", example = "1")
    private Integer pageNum = 1;

    @Schema(description = "每页数量", example = "10")
    private Integer pageSize = 10;

    @Schema(description = "排序字段")
    private String orderBy;

    @Schema(description = "排序方式（asc/desc）")
    private String orderType;

    @Schema(description = "id集合")
    private List<Integer> ids;
}
