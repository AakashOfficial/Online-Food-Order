package com.tyagi.project.OnlineFoodOrder.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.tyagi.project.OnlineFoodOrder") // Base Package Scan
@EnableTransactionManagement
public class DatabaseConfiguration {

	// Data Source (Backend Configuration)
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/OnlineShoppings");
		dataSource.setUsername("sa");
		dataSource.setPassword("test");
		System.out.println("Data Source Creation");
		return dataSource;
	}

}