package com.hibernate.crud;

import java.sql.SQLException;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;




public class SecondLevelCacheTest {

	public static void SecondLevelCachewithOneSesson() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.load(Stock.class,9);
		System.out.println(persistobj.getStockName());
		Stock persistobj1 = (Stock) session.load(Stock.class,9);
		System.out.println(persistobj1.getStockName());
		session.evict(persistobj);
		Stock persistobj2 = (Stock) session.load(Stock.class,9);
		System.out.println(persistobj2.getStockName());
		System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount());           //Prints 1
		System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());   //Prints 1
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	public static void secondLevelCachewithTwoSesson() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.load(Stock.class,9);
		System.out.println(persistobj.getStockName());
		session.getTransaction().commit();
		session.evict(persistobj);
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Stock persistobj1 = (Stock) session.load(Stock.class,9);
		System.out.println(persistobj1.getStockName());
		Stock persistobj2 = (Stock) session1.load(Stock.class,9);
		System.out.println(persistobj2.getStockName());
		session1.getTransaction().commit();
		System.out.println(HibernateUtil.getSessionFactory().getStatistics().getEntityFetchCount());           //Prints 1
		System.out.println(HibernateUtil.getSessionFactory().getStatistics().getSecondLevelCacheHitCount());   //Prints 2
		 
		HibernateUtil.shutdown();
	}
	public void evict2ndLevelCache() {
	    try {
	        Map<String, ClassMetadata> classesMetadata = HibernateUtil.getSessionFactory().getAllClassMetadata();
	        for (String entityName : classesMetadata.keySet()) {
	        	HibernateUtil.getSessionFactory().evictEntity(entityName);
	        }
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	}
	public static void main(String[] args) throws SQLException {
		//SecondLevelCachewithOneSesson();
		secondLevelCachewithTwoSesson();
	}
}