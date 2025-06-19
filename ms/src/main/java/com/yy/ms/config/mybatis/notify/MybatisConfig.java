package com.yy.ms.config.mybatis.notify;


import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.yy.ms.config.customize.MybatisMapKeyUpperFactory;
import jakarta.annotation.Resource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;

/**
 * mybatis配置类
 * 
 * @author yuqiumin
 * @date 2016/12/05
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

	@Resource(name = "pg_notify")
	DataSource dataSource;

	/**
	 * 配置mybatis工厂类
	 */
	@Bean(name = "sqlSessionFactory_notify")
	public SqlSessionFactory sqlSessionFactoryBean() {

		MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
		// 设置数据源
		bean.setDataSource(dataSource);
		// 设置实体类的别名包路径
		bean.setTypeAliasesPackage("com.yy.common.entity.ms.notice");
		// 设置自定义Map Key转大写包装工厂
		bean.setObjectWrapperFactory(new MybatisMapKeyUpperFactory());
		bean.setConfiguration(mybatisSetting());

		
        // 添加插件
        Interceptor[] pl = {  };
        bean.setPlugins(pl);


		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			// 设置xml扫描路径
			bean.setMapperLocations(resolver
					.getResources("classpath:mybatis/notice/*Mapper.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("sqlSessionFactory init fail", e);
		}
	}


	/**
	 * 可以通过这个类,详细配置mybatis
	 *
	 * @return
	 */
	public MybatisConfiguration mybatisSetting(){
		MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
		mybatisConfiguration.setLogImpl(StdOutImpl.class);
		return mybatisConfiguration;
	}

	/**
	 * 用于实际查询的sql工具,传统dao开发形式可以使用这个,基于mapper代理则不需要注入
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name = "sqlSessionTemplate_notify")
	public SqlSessionTemplate sqlSessionTemplate(
			SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
