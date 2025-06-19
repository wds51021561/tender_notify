package com.yy.ms.config.dbConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.jakarta.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class PgNotifyConfig {

    @Bean(name = "pg_notify")
    public DataSource dataSource() throws Exception {

        // 创建Druid数据源实例
        DruidDataSource dataSource = new DruidDataSource();

        // 设置JDBC驱动类名（PostgreSQL）
        dataSource.setDriverClassName("org.postgresql.Driver");

        // 设置数据库连接URL（需根据实际环境填写）
        dataSource.setUrl("jdbc:postgresql://192.168.127.132:5432/tender_notice");

        // 设置数据库用户名（需根据实际环境填写）
        dataSource.setUsername("tender_notice");

        // 设置数据库密码（需根据实际环境填写）
        dataSource.setPassword("wds123654");

        // 配置初始连接数（建议值：5-10）
        dataSource.setInitialSize(5);

        // 配置最小空闲连接数（建议值与initialSize保持一致）
        dataSource.setMinIdle(5);

        // 配置最大连接数（根据系统负载调整，建议值：20-50）
        dataSource.setMaxActive(20);

        // 设置获取连接的最大等待时间（单位：毫秒，建议值：60000）
        dataSource.setMaxWait(60000);

        // 设置空闲连接回收器运行间隔（单位：毫秒，建议值：60000）
        dataSource.setTimeBetweenEvictionRunsMillis(60000);

        // 设置连接最小生存时间（单位：毫秒，建议值：300000）
        dataSource.setMinEvictableIdleTimeMillis(300000);

        // 设置是否缓存PreparedStatement（开启PSCache能提升SQL执行效率）
        dataSource.setPoolPreparedStatements(true);

        // 设置每个连接PSCache中存储的PreparedStatement数量（建议值：20-50）
        dataSource.setMaxOpenPreparedStatements(50);

        // 配置SQL监控和过滤器，替换日志实现为Slf4j
        dataSource.setFilters("stat,slf4j");
        dataSource.init();
        return dataSource;
    }

    /**
     * 注册 Druid 监控的 StatViewServlet
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 可选：设置监控页面的登录账号密码等
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin"); // 登录 Druid 监控页面的用户名
        initParams.put("loginPassword", "admin"); // 登录密码
        initParams.put("resetEnable", "false");   // 禁用重置功能
        bean.setInitParameters(initParams);

        return bean;
    }

}
