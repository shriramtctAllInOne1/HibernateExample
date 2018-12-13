package com.hibernate.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilProgrammatic {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		SessionFactory factory;
		try {

			Configuration configuration = new Configuration()
					.addResource("com/hibernate/entity/Stock.hbm.xml")
					.setProperty("hibernate.connection.url","jdbc:h2:./database/test")
					.setProperty("hibernate.connection.driver_class","org.h2.Driver")
					.setProperty("hibernate.connection.username", "sa")
					.setProperty("hibernate.connection.password", "")
					.setProperty("hibernate.default_schema", "PUBLIC")
					.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect")
					.setProperty("show_sqlt","true")
					.setProperty("connection.pool_size","1")
					.setProperty("hibernate.hbm2ddl.auto", "create");
			factory = configuration.buildSessionFactory();

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
