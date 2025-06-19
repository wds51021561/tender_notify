package com.yy.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GeneratorCode {

    public static void main(String[] args) {
        try {
            // 1. 创建 FreeMarker 配置
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/template")); // 设置模板目录
            cfg.setDefaultEncoding("UTF-8");

            // 2. 加载模板
            Template template = cfg.getTemplate("A.ftl");

            // 3. 准备数据模型
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("packageName", "com.yy.demo");
            dataModel.put("className", "Greeting");
            dataModel.put("name", "World");

            // 4. 输出生成的内容
            // 写入生成的文件
            File file = new File("src/main/java/com/yy/demo/Greeting.java");
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(file)) {

                template.process(dataModel, writer);
                writer.flush();
            }

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
