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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="userEntityManagerFactory",basePackages={"com.foodpoint.repository"}
,transactionManagerRef="userTransactionManager")
public class UserConfig {
	
	@Bean(name="userDatasource")
	@ConfigurationProperties(prefix="spring.user.datasource")
	public DataSource datasourceCartItemConfig()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier DataSource datasource ) 
	{
		Map<String,Object> properties=new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL57Dialect");
		return builder.dataSource(datasource).properties(properties).packages("com.foodpoint.modal").persistenceUnit("User").build();
	}

	@Bean(name="userTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory)
	
	{
		return new JpaTransactionManager(entityManagerFactory);
	}

}
