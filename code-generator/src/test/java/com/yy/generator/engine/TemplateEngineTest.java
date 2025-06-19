package com.yy.generator.engine;

import com.baomidou.mybatisplus.annotation.IdType;
import com.yy.generator.config.DataSourceConfig;
import com.yy.generator.config.StrategyConfig;
import com.yy.generator.config.TemplateConfig;
import com.yy.generator.config.builder.ConfigBuilder;
import com.yy.generator.config.builder.GeneratorBuilder;
import com.yy.generator.config.po.LikeTable;
import com.yy.generator.config.po.TableInfo;
import com.yy.generator.config.po.TableInfoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author nieqiurong 2020/10/11.
 */
public class TemplateEngineTest {

    private void compatibleAssert(ConfigBuilder configBuilder) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        velocityTemplateEngine.setConfigBuilder(configBuilder);
        TableInfo tableInfo = new TableInfo(new ConfigBuilder(GeneratorBuilder.packageConfig(), TableInfoTest.dataSourceConfig,
            GeneratorBuilder.strategyConfig(), null, null, null), "user");
        tableInfo.processTable();
        Map<String, Object> objectMap = velocityTemplateEngine.getObjectMap(configBuilder, tableInfo);
        Assertions.assertEquals(Boolean.FALSE, objectMap.get("enableCache"));
        Assertions.assertEquals(Boolean.TRUE, objectMap.get("baseResultMap"));
        Assertions.assertEquals(Boolean.TRUE, objectMap.get("baseColumnList"));
        Assertions.assertEquals(Boolean.TRUE, objectMap.get("activeRecord"));
        Assertions.assertEquals(IdType.INPUT.toString(), objectMap.get("idType"));
    }

    @Test
    void compatibleTest() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:h2:mem:test;MODE=mysql;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE", "sa", "").build();
        compatibleAssert(new ConfigBuilder(GeneratorBuilder.packageConfig(), dataSourceConfig,
            new StrategyConfig.Builder().likeTable(new LikeTable("USER"))
                .entityBuilder().enableActiveRecord().idType(IdType.INPUT)
                .mapperBuilder().enableBaseResultMap().enableBaseColumnList()
                .build(),
            new TemplateConfig.Builder().build(),
            GeneratorBuilder.globalConfig(), null));
    }
}
