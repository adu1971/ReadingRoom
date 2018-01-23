package org.adu.readingroom.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate-mysql.properties" })
public class PersistenceConfig {
	
	 @Autowired
	 private Environment env;
	
	 @Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		 entityManagerFactory.setDataSource(getDataSource());
		 entityManagerFactory.setPackagesToScan(new String[] {"org.adu.readingroom.model"});		 
		 entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		 entityManagerFactory.setJpaProperties(getHibernateProperties());
		 return entityManagerFactory;
	 }
	 
	 
//	 @Bean
//	 public LocalSessionFactoryBean sessionFactory() {
//		 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		 sessionFactory.setDataSource(getDataSource());
//		 sessionFactory.setPackagesToScan( new String[] { "org.adu.readingroom.model" });
//		 sessionFactory.setHibernateProperties(getHibernateProperties());
//		 return sessionFactory;
//	 }
	
	 private Properties getHibernateProperties() {
		 Properties properties = new Properties();
		 properties.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
		 properties.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show_sql"));
		 properties.put(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		 properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current.session.context.class"));
		 properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, env.getProperty("hibernate.batch.size"));

		 // properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		 // properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		 // properties.setProperty("hibernate.globally_quoted_identifiers", "true");
		 return properties;
	 }
	
	 @Bean
	 public DataSource getDataSource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 dataSource.setDriverClassName(env.getRequiredProperty("datasource.driver"));
		 dataSource.setUrl(env.getRequiredProperty("datasource.url"));
		 dataSource.setUsername(env.getRequiredProperty("datasource.username"));
		 dataSource.setPassword(env.getRequiredProperty("datasource.password"));
		 return dataSource;
	 }

	 @Bean
	 public PlatformTransactionManager transactionManager(EntityManagerFactory emFactory) {
		 JpaTransactionManager txManager = new JpaTransactionManager();
		 txManager.setEntityManagerFactory(emFactory);
		 return txManager;
	 }
	 
	 
//	 @Bean
//	 @Autowired
//	 public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//		 HibernateTransactionManager txManager = new HibernateTransactionManager();
//		 txManager.setSessionFactory(sessionFactory);
//		 return txManager;
//	 }
	
//	 @Bean
//	 public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//	 return new PersistenceExceptionTranslationPostProcessor();
//	 }

}