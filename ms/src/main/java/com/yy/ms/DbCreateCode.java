package com.yy.ms;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.model.ClassAnnotationAttributes;


import java.sql.Types;
import java.util.Map;

public class DbCreateCode {

    static String dbUrl = "jdbc:postgresql://192.168.127.132:5432/tender_notice";
    static String dbUser = "tender_notice";
    static String dbPassword = "wds123654";
    static String commonDir = ".\\common\\src\\main\\java";
    static String msDir = ".\\ms\\src\\main\\java";
    static String commonPackage = "com.yy.common.entity.ms";
    static String msPackage = "com.yy.ms.dao";
    static String dbModule = "notice";
    static String msMapper = ".\\ms\\src\\main\\resources\\mapper\\";



    public static void main(String[] args) {
//        createCommon();
        createMs();
    }


    private static void createCommon(){
        FastAutoGenerator.create(dbUrl, dbUser, dbPassword)
                .globalConfig(builder -> {
                    builder.author("yyunyy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(commonDir);
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if(typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent(commonPackage)
                                .moduleName(dbModule)
                                .entity("")
                )
                .strategyConfig(builder ->
                        builder.entityBuilder()
                                .enableLombok(new ClassAnnotationAttributes("@Getter","lombok.Getter"))
                                .enableLombok(new ClassAnnotationAttributes("@Setter","lombok.Setter"))
                                .mapperBuilder().disable()
                                .controllerBuilder().disable()
                                .serviceBuilder().disable()
                                .build()
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    private static void createMs(){
        FastAutoGenerator.create(dbUrl, dbUser, dbPassword)
                .globalConfig(builder -> {
                    builder.author("yyunyy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(msDir); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if(typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent(msPackage)
                                .moduleName(dbModule)
                                .controller("api")
                                .pathInfo(Map.of(
                                        OutputFile.xml, ".\\ms\\src\\main\\resources\\mapper\\" + dbModule
                                )) // 设置mapperXml生成路径

                )
                .strategyConfig(builder ->
                        builder.entityBuilder().disable()
                                .mapperBuilder()
                                .serviceBuilder().disable()
                                .controllerBuilder().convertFileName(type -> type + "ApiImpl")
                                .build()
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
