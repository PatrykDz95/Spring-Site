package com.project.springsecurity.plotlyjs.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.project.springsecurity.plotlyjs")
@PropertySource("classpath:persistence-mysql.properties") // will read the props file: src/main/resources
public class DemoAppConfig {

	//set up variable to hold the properties
	@Autowired
	private Environment env; // will hold data read from properties files
	
	//set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	//define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		
		//create connection pool
		ComboPooledDataSource securityDataSource = 
								new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {								// reads data base configs from property file
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver")); 
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		//log the connection props
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));		
		
		//set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
	
		//set connection pool props
		securityDataSource.setInitialPoolSize(
						getIntProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		return securityDataSource;
	}
	
	//need helper method
	//read environment property and convert to int
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		
		//now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
}















