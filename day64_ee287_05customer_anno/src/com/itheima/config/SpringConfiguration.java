package com.itheima.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 一个spring的配置类
 * 它的作用就相当于bean.xml
 * @author 86131
 *
 */
@Configuration//它就是把当前类看成是spring的配置类 
@ComponentScan({"com.itheima","config"})
@Import({JdbcConfig.class})//导入其他配置类
@PropertySource("classpath:config/jdbcConfig.properties")
public class SpringConfiguration {
	
	@Bean
	public static PropertySourcePlaceholderConfigurer createPropertySourcePlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/*
	 * @Bean(name="runner")//它是把方法的返回值存入spring容器中，该注解有一个属性，name：用于指定bean的id。
	 * 当不指定时它有默认值，默认值是方法的名称 public QueryRunner createQueryRunner(DataSource
	 * dataSource) { return new QueryRunner(dataSource); }
	 * 
	 * @Bean(name="dataSource") public DataSource createDataSource() { try {
	 * ComboPooledDataSource ds=new ComboPooledDataSource();
	 * ds.setDriverClass("com.mysql.jdbc.Driver");
	 * ds.setJdbcUrl("jdbc:mysql://localhost:3306/day64_ee287_spring");
	 * ds.setUser("root"); ds.setPassword("1234"); return ds; }catch(Exception e) {
	 * throw new RuntimeException(e); } }
	 */

}
