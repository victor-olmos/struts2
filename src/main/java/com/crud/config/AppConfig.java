package com.crud.config;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.crud.repositories.ProductRepository;
import com.crud.repositories.ProductRepositoryImpl;
import com.crud.services.ProductService;
import com.crud.services.ProductServiceImpl;

@Configuration
@ComponentScan({"com.crud"})
@EnableTransactionManagement
public class AppConfig {
	
	
	@Bean(name="entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan(new String [] {"com.crud.entities"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		entityManager.setJpaProperties(additionalProperties());
		
		return entityManager;
		
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/crud");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transasctionManager = new JpaTransactionManager();
		transasctionManager.setEntityManagerFactory(emf);
		return transasctionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exeptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	
		Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}
		
		@Bean
		public ProductRepository productRepository() {
			return new ProductRepositoryImpl();
		}
		
		@Bean
		public ProductService productService() {
			return new ProductServiceImpl(productRepository());
		}
		
		
		/*
		@Bean
		public ProductRepository productRepository() {
			return new ProductRepositoryImpl();
		}
		
		@Bean
		public ProductService productService() {
			return new ProductServiceImpl(productRepository());
		}
	
	

	
	@Bean
	public AccountRepository accountRepository() {
		return new AccountRepositoryImpl();
		
	}
	
	@Bean
	public AccountService accountService() {
		return new AccountServiceImpl(accountRepository());
	}
 */
}
