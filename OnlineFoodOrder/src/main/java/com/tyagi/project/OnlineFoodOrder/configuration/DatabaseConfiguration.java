package com.tyagi.project.OnlineFoodOrder.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tyagi.project.OnlineFoodOrder.dao.CategoryDAO;
import com.tyagi.project.OnlineFoodOrder.dao.FoodDAO;
import com.tyagi.project.OnlineFoodOrder.dao.SupplierDAO;
import com.tyagi.project.OnlineFoodOrder.dao.UserDAO;
import com.tyagi.project.OnlineFoodOrder.model.Category;
import com.tyagi.project.OnlineFoodOrder.model.Food;
import com.tyagi.project.OnlineFoodOrder.model.Supplier;
import com.tyagi.project.OnlineFoodOrder.model.UserRegister;

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
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/OnlineFoodOrder");
		dataSource.setUsername("sa");
		dataSource.setPassword("test");
		System.out.println("Data Source Creation");
		return dataSource;
	}

	// Session Factory Object Creation(Hibernate Mapping)
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("---Hibernate Properties----");
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true"); // optional
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("---Hibernate Properties Created");

		// Local Session Factory Builder Object Creation
		System.out.println("---Local SessionFactory Builder Object Creation---");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println("---Factory Builder Object Created---");

		// Session Factory Object For Category
		sessionBuilder.addAnnotatedClass(Category.class);
		System.out.println("Session Factory Object Creation for Category");
		
		// Session Factory Object For User
		sessionBuilder.addAnnotatedClass(UserRegister.class);
		System.out.println("Session Factory Object Creation for User");
		
		// Session Factory Object For Food
		sessionBuilder.addAnnotatedClass(Food.class);
		System.out.println("Session Factory Object Creation for Food");
		
		// Session Factory Object For Supplier
		sessionBuilder.addAnnotatedClass(Supplier.class);
		System.out.println("Session Factory Object Creation for Supplier");

		// SessionFactory Object Created
		SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}

	// Transaction Manager Object
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("--Transaction manager Object Creation--");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("--Transaction manager Object Created--");
		return transactionManager;
	}

	// categoryDAO Object
	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		System.out.println("-- CategoryDAO Object Creation--");
		return new CategoryDAO(sessionFactory);
	}

	// userDAO Object
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		System.out.println("-- UserDAO Object Creation--");
		return new UserDAO(sessionFactory);
	}
	
	// foodDAO Object
	@Autowired
	@Bean(name = "foodDAO")
	public FoodDAO getFoodDAO(SessionFactory sessionFactory) {
		System.out.println("-- FoodDAO Object Creation--");
		return new FoodDAO(sessionFactory);
	}
	
	// supplierDAO Object
		@Autowired
		@Bean(name = "supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
			System.out.println("-- SupplierDAO Object Creation--");
			return new SupplierDAO(sessionFactory);
		}
}