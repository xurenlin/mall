package ${package.Entity};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#if springdoc>
import io.swagger.v3.oas.annotations.media.Schema;
</#if>
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
</#if>

<#if entityLombokModel>
@Data
<#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
<#else>
@EqualsAndHashCode(callSuper = false)
</#if>
</#if>
<#if springdoc>
@Schema(description = "${table.comment!}")
</#if>
public class ${entity} <#if superEntityClass??>extends ${superEntityClass}<#else>implements Serializable</#if> {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

<#list table.fields as field>
    <#if springdoc>
    @Schema(description = "${field.comment!}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
}