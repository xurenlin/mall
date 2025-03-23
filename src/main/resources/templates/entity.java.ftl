<#-- src/main/resources/templates/entity.java.ftl -->
package ${package.Entity};

<#list table.importPackages as pkg>
import ${pkg};
</#list>
<#if swagger>  <!-- 使用 swagger 而非 springdoc -->
import io.swagger.v3.oas.annotations.media.Schema;
</#if>
<#if entityLombokModel>
import lombok.Data;
</#if>

<#if entityLombokModel>
@Data
</#if>
<#if swagger>
@Schema(description = "${table.comment!}")
</#if>
public class ${entity} implements Serializable {
<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

<#list table.fields as field>
    <#if swagger>
    @Schema(description = "${field.comment!}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
}