package ${package.Parent}.query;

import com.xrl.mall.common.base.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "查询条件")
@Data
@EqualsAndHashCode(callSuper = true)
public class ${entity}Query extends BaseQuery {

}
