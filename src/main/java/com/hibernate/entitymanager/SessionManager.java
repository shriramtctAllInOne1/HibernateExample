package com.hibernate.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManager {

	/*
	 * public static EntityManager getEntityManager() { EntityManagerFactory
	 * managerFactory = Persistence .createEntityManagerFactory("book");
	 * EntityManager manager = managerFactory.createEntityManager(); return
	 * manager; }
	 */
	
	


	public static EntityManager getEntitiyManager() {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("book");
		EntityManager manager = managerFactory.createEntityManager();
		return manager;
	}
}