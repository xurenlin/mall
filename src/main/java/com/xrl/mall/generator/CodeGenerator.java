package com.xrl.mall.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        // 去重后的表名列表
        String[] tables = {
                "users", "user_tokens", "products", "categories",
                "product_media", "order_items", "payments",
                "product_inventory", "operation_logs"
        };

        for (String table : tables) {
            FastAutoGenerator.create(
                            "jdbc:mysql://localhost:3306/mall?useSSL=false&serverTimezone=Asia/Shanghai",
                            "root",
                            "123456"
                    )
                    .globalConfig(builder -> {
                        builder.author("xrl")
                                .enableSpringdoc()
                                .outputDir(System.getProperty("user.dir") + "/src/main/java");
                    })
                    .packageConfig(builder -> {
                        builder.parent("com.xrl.mall")   // 父包名
                                .moduleName(table)       // 模块名（按表名生成独立模块）
                                .entity("entity")        // 实体类包名
                                .mapper("mapper")        // Mapper 接口包名
                                .service("service")      // Service 接口包名
                                .controller("controller")// Controller 包名
                                .pathInfo(Collections.singletonMap(
                                        OutputFile.xml,  // XML 文件路径
                                        System.getProperty("user.dir") + "/src/main/resources/mapper/" + table
                                ));
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(table)
                                // 实体类配置
                                .entityBuilder()
                                .enableFileOverride() // 仅覆盖实体
                                .naming(NamingStrategy.underline_to_camel)  // 类名驼峰
                                .columnNaming(NamingStrategy.underline_to_camel) // 字段名驼峰
                                .enableLombok()          // 启用 Lombok
                                .enableTableFieldAnnotation()  // 字段注解（如 @TableId）
                                .idType(IdType.AUTO)     // 主键自增
                                // Controller 配置
                                .controllerBuilder()
                                .enableFileOverride() // 仅覆盖 Controller
                                .enableRestStyle()       // 启用 REST 风格
                                .formatFileName("%sController") // 控制器类名格式
                                // Service 配置
                                .serviceBuilder()
                                .formatServiceFileName("%sService") // 服务接口名格式
                                .formatServiceImplFileName("%sServiceImpl") // 服务实现类名格式
                                // Mapper 配置
                                .mapperBuilder()
                                .enableMapperAnnotation()  // 启用 @Mapper
                                .enableBaseResultMap()     // 生成 ResultMap
                                .enableBaseColumnList();   // 生成 ColumnList
                    })
                    .templateEngine(new FreemarkerTemplateEngine())
                    .templateConfig(builder -> {
                        // 指定自定义 Controller 模板路径
                        builder.controller("/templates/controller.java");
                        builder.entity("/templates/entity.java");
                    })
                    .execute();
        }
    }
}