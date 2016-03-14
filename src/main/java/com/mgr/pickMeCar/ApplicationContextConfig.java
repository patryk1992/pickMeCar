package com.mgr.pickMeCar;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mgr.pickMeCar.db.dao.TokenDAO;
import com.mgr.pickMeCar.db.dao.TokenDAOImpl;
import com.mgr.pickMeCar.db.dao.UserDAO;
import com.mgr.pickMeCar.db.dao.UserDAOImpl;
import com.mgr.pickMeCar.db.model.Token;
import com.mgr.pickMeCar.db.model.User;

@Configuration
@ComponentScan("com.mgr.pickMeCar")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/drive_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Token.class);
//		sessionBuilder.scanPackages("com.mgr.pickMeCar.db.model");
		return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
//	@Autowired
//	@Bean(name = "userDao")
//	public UserDAO getUserDao(SessionFactory sessionFactory) {
//	    return new UserDAOImpl(sessionFactory);
//	}
	@Autowired
	@Bean(name = "tokenDao")
	public TokenDAO getTokenDao(SessionFactory sessionFactory) {
	    return new TokenDAOImpl(sessionFactory);
	}

}
