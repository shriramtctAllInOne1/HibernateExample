package com.hibernate.annotation.TPHinheritance;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilProgrammatic {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		SessionFactory factory;
		try {
			Configuration configuration= new Configuration().addAnnotatedClass(com.hibernate.annotation.TPHinheritance.Employee.class).
					addAnnotatedClass(com.hibernate.annotation.TPHinheritance.Regular_Employee.class).addAnnotatedClass(com.hibernate.annotation.TPHinheritance.Contract_Employee.class)
			    	    .setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/testdb")
						.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
						.setProperty("hibernate.connection.username", "root")
						.setProperty("hibernate.connection.password", "root")
						.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect")
						.setProperty("show_sqlt","true")
						.setProperty("hibernate.cache.provider_class","org.hibernate.cache.EhCacheProvider")
						.setProperty("hibernate.cache.use_second_level_cache","false")
						.setProperty("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory")
						.setProperty("hibernate.hbm2ddl.auto", "create")
						.setProperty("hibernate.generate_statistics", "true");	
			            factory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
	
	
}
