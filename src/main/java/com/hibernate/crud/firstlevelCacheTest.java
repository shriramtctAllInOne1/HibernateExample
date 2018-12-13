package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Session;



/*
 1. First level cache is associated with “session” object and other session objects in application can not see it.
 2. The scope of cache objects is of session. Once session is closed, cached objects are gone forever.
 3. First level cache is enabled by default and you can not disable it.
 4. When we query an entity first time, it is retrieved from database and stored in first level cache associated with hibernate session.
 5.If we query same object again with same session object, it will be loaded from cache and no sql query will be executed.
 6.The loaded entity can be removed from session using evict() method. The next loading of this entity will again make a database call if it has been removed using evict() method.
 7.The whole session cache can be removed using clear() method. It will remove all the entities stored in cache
 */public class firstlevelCacheTest {

	public static void firsLevelCachewithOneSesson() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.load(Stock.class, 9);
		System.out.println(persistobj.getStockName());
		Stock persistobj1 = (Stock) session.load(Stock.class, 9);
		System.out.println(persistobj1.getStockName());
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	public static void firsLevelCachewithTwoSesson() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.load(Stock.class, 9);
		System.out.println(persistobj.getStockName());
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Stock persistobj1 = (Stock) session1.load(Stock.class, 9);
		System.out.println(persistobj1.getStockName());
		session1.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	public static void evictTest() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.load(Stock.class, 9);
		System.out.println(persistobj.getStockName());
		session.evict(persistobj);
		Stock persistobj1 = (Stock) session.load(Stock.class, 9);
		System.out.println(persistobj1.getStockName());
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

	public static void main(String[] args) throws SQLException {
		// firsLevelCachewithOneSesson();
		// firsLevelCachewithTwoSesson();
		evictTest();

	}
}