package com.foodpoint.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="entityManagerFactory",basePackages={"com.foodpoint.repository"},transactionManagerRef="transactionManager")
public class CartItemConfig {
	
	@Primary
	@Bean(name="datasource")
	@ConfigurationProperties(prefix="spring.cartItem.datasource")
	
	public DataSource datasourceCartItemConfig()
	{
		return DataSourceBuilder.create().build();
	}
	@Primary
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier DataSource datasource ) 
	{
		Map<String,Object> properties=new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL57Dialect");
		return builder.dataSource(datasource).properties(properties).packages("com.foodpoint.modal").persistenceUnit("CartItem").build();
	}
	@Primary
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory)
	
	{
		return new JpaTransactionManager(entityManagerFactory);
	}
	

}
