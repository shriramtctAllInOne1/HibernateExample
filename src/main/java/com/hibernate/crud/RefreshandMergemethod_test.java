package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Session;



//delete  FROM stock  where stock_name in('GENM2','GENM3','GENM4','GENM6','GENM');

/*
 * 1. refresh and merge is overloaded
 * 
 * 2. refresh populate the entity with database changes
 * 
 * 3. merge update data base with new changes in detach object
 * 
 * Object merge(Object object)
   Object merge(String entityName, Object object)
 * 
 */
public class RefreshandMergemethod_test {

	// first calling save and save and update to modify existing obj
	public static void refreshTest() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("31");
		stock.setStockName("ram31");
		session.save(stock);
		session.getTransaction().commit();
		session.close();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		stock.setStockName("ram32");
		session1.refresh(stock);
		session1.getTransaction().commit();
		session1.close();
		HibernateUtil.shutdown();
		System.out.println(stock.getStockName().equals("ram31"));
	}

	public static void mergeTest() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.load(Stock.class, 9);
		session.getTransaction().commit();
		persistobj.setStockName("ram1335");
		session.beginTransaction();
		Stock stock1=(Stock) session.merge(persistobj);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println(stock1.getStockName());
	}

	public static void main(String[] args) throws SQLException {
		//refreshTest();
		mergeTest();
		
	}
}