package ${package.Service};

import ${package.Entity}.${entity};
import ${package.Parent}.query.${entity}Query;
import com.xrl.mall.common.core.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface ${table.serviceName} {

    /**
    * 分页查询
    * @param query 查询参数
    */
    Result<Page<${entity}>> pageList(${entity}Query query);

    /**
    * 根据ID查询
    * @param id ID
    */
    Result<${entity}> getById(<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id);

    /**
    * 新增
    * @param entity 实体对象
    */
    Result<Boolean> save(${entity} entity);

    /**
    * 修改
    * @param entity 实体对象
    */
    Result<Boolean> update(${entity} entity);

    /**
    * 删除
    * @param id ID
    */
    Result<Boolean> delete(<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id);
}