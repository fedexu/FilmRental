package com.filmrental.spring.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@PropertySource("/WEB-INF/persistence-mysql.properties")
@ComponentScan("com.filmrental")
public class ApplicationContextConfig {
   @Autowired
   private Environment env;
 
   @Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
   
   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(restDataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.filmrental.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
   
   Properties hibernateProperties() {
	      return new Properties() {
	         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
	            setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	            setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	            setProperty("hibernate.globally_quoted_identifiers", "true");
	            setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	         }
	      };
	   }
 
   @Bean
   public DataSource restDataSource() {
      /*BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
      dataSource.setUrl(env.getProperty("jdbc.url"));
      dataSource.setUsername(env.getProperty("jdbc.user"));
      dataSource.setPassword(env.getProperty("jdbc.pass"));
 
      return dataSource;*/
	   
	   JndiDataSourceLookup dataSource = new JndiDataSourceLookup();
	   dataSource.setResourceRef(true);
	   return dataSource.getDataSource(env.getProperty("jdbc.ds"));
   }
 
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }   
 
}