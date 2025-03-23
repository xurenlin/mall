package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
<#if springdoc>
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
</#if>

@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if springdoc>
@Tag(name = "${table.controllerName}", description = "${table.comment!'无描述'}")
</#if>
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @PostMapping
    <#if springdoc>
    @Operation(summary = "新增${table.comment!'无描述'}")
    </#if>
    public boolean save(<#if springdoc>@Parameter(description = "${table.comment!'无描述'}实体") </#if>@RequestBody ${entity} ${entity?uncap_first}) {
        return ${table.serviceName?uncap_first}.saveOrUpdate(${entity?uncap_first});
    }

    @PutMapping
    <#if springdoc>
    @Operation(summary = "更新${table.comment!'无描述'}")
    </#if>
    public boolean update(<#if springdoc>@Parameter(description = "${table.comment!'无描述'}实体") </#if>@RequestBody ${entity} ${entity?uncap_first}) {
        return ${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
    }

    @DeleteMapping("/{id}")
    <#if springdoc>
    @Operation(summary = "删除${table.comment!'无描述'}")
    </#if>
    public boolean delete(<#if springdoc>@Parameter(description = "${table.comment!'无描述'}ID") </#if>@PathVariable <#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id) {
        return ${table.serviceName?uncap_first}.removeById(id);
    }

    @GetMapping("/{id}")
    <#if springdoc>
    @Operation(summary = "查询单个${table.comment!'无描述'}")
    </#if>
    public ${entity} getById(<#if springdoc>@Parameter(description = "${table.comment!'无描述'}ID") </#if>@PathVariable <#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id) {
        return ${table.serviceName?uncap_first}.getById(id);
    }

    @GetMapping
    <#if springdoc>
    @Operation(summary = "查询${table.comment!'无描述'}列表")
    </#if>
    public List<${entity}> list() {
        return ${table.serviceName?uncap_first}.list();
    }
}