package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Parent}.query.${entity}Query;
import ${package.Service}.${table.serviceName};
import com.xrl.mall.common.core.Result;
import com.xrl.mall.common.enums.ResultCode;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.Objects;

@Service
public class ${table.serviceImplName} implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} mapper;

    @Override
    public Result<Page<${entity}>> pageList(${entity}Query query) {
        try {
            // 1. 构建分页对象
            Page<${entity}> page = new Page<>(query.getPageNum(), query.getPageSize());

            // 2. 构建查询条件
            LambdaQueryWrapper<${entity}> wrapper = new LambdaQueryWrapper<>();

            // 2.1 处理ID集合查询
            if (!CollectionUtils.isEmpty(query.getIds())) {
                wrapper.in(${entity}::getId, query.getIds());
            }

            // 3. 执行查询
            Page<${entity}> result = mapper.selectPage(page, wrapper);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Result<${entity}> getById(<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id) {
        try {
            ${entity} entity = mapper.selectById(id);
            return Objects.nonNull(entity) ? Result.success(entity) : Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Result<Boolean> save(${entity} entity) {
        try {
            int count = mapper.insert(entity);
            return count > 0 ? Result.success(true) : Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Result<Boolean> update(${entity} entity) {
        try {
            int count = mapper.updateById(entity);
        return count > 0 ? Result.success(true) : Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Result<Boolean> delete(<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list> id) {
        try {
            int count = mapper.deleteById(id);
        return count > 0 ? Result.success(true) : Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
        }
    }
}