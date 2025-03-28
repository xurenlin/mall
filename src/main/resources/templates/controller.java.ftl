package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Parent}.query.${entity}Query;
import ${package.Service}.${table.serviceName};
import com.xrl.mall.common.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/${controllerMappingHyphen?has_content?then(controllerMappingHyphen, table.entityPath)}")
@Tag(name = "${table.comment}接口")
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<Page<${entity}>> pageList(${entity}Query query) {
        return ${table.serviceName?uncap_first}.pageList(query);
    }

    @GetMapping("/{id}")
    @Operation(summary = "ID查询")
    public Result<${entity}> getById(@PathVariable <#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id) {
        return ${table.serviceName?uncap_first}.getById(id);
    }

    @PostMapping
    @Operation(summary = "新增")
    public Result<Boolean> save(@RequestBody ${entity} entity) {
        return ${table.serviceName?uncap_first}.save(entity);
    }

    @PutMapping
    @Operation(summary = "修改")
    public Result<Boolean> update(@RequestBody ${entity} entity) {
        return ${table.serviceName?uncap_first}.update(entity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除")
    public Result<Boolean> delete(@PathVariable <#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id) {
        return ${table.serviceName?uncap_first}.delete(id);
    }
}