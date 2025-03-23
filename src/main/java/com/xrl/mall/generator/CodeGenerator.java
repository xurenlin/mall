package com.xrl.mall.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String[] tables = {"users","user_tokens","products","categories","product_media","product_media","order_items","payments","product_inventory","product_inventory","operation_logs","operation_logs"}; // 需要生成的表名

        for (String table : tables) {
            FastAutoGenerator.create(
                            "jdbc:mysql://localhost:3306/mall?useSSL=false&serverTimezone=Asia/Shanghai",
                            "root",
                            "123456"
                    )
                    .globalConfig(builder -> {
                        builder.author("xrl")
                                .fileOverride()
                                .outputDir(System.getProperty("user.dir") + "/src/main/java");
                    })
                    .packageConfig(builder -> {
                        builder.parent("com.xrl.mall")
                                .moduleName(table)
                                .entity("entity")
                                .mapper("mapper")
                                .service("service")
                                .pathInfo(Collections.singletonMap(
                                        OutputFile.xml,
                                        System.getProperty("user.dir") + "/src/main/resources/mapper/" + table
                                ));
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(table)
                                .entityBuilder()
                                .naming(NamingStrategy.underline_to_camel)
                                .columnNaming(NamingStrategy.underline_to_camel)
                                .enableLombok()
                                .enableTableFieldAnnotation()
                                .idType(IdType.AUTO)
                                .mapperBuilder()
                                .enableMapperAnnotation()
                                .enableBaseResultMap()    // 启用 ResultMap
                                .enableBaseColumnList();  // 启用 ColumnList
                    })
/*                    .templateConfig(builder -> {
                        builder.disable(TemplateType.CONTROLLER);
                    })*/
                    .execute();
        }
    }
}