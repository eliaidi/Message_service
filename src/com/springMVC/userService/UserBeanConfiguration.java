package com.springMVC.userService;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class UserBeanConfiguration {
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Service");
        dataSource.setUsername("root");
        dataSource.setPassword("337755Zou");
        return dataSource;
    }
	private Map<String,?> jpaProperties() {
        Map<String,String> jpaPropertiesMap = new HashMap<String,String>();
        jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "update");
        return jpaPropertiesMap;
    }

	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = 
            new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        factoryBean.setDataSource(dataSource());
        System.out.println("ok1");
        factoryBean.setPackagesToScan("com.springMVC.entity");
        factoryBean.setJpaPropertyMap(jpaProperties());
        return factoryBean;
    }
	@Bean
	public UserDao userDao(){
		UserDao bean=new UserDaoImpl();
		return bean;
	}
	
	@Bean
	public UserManager userManager(){
		UserManager bean=new UserManagerImpl();
		return bean;
	}
	

}
