package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Session;



//delete  FROM stock  where stock_name in('GENM2','GENM3','GENM4','GENM6','GENM');

/*
 * 1. Save is overloaded method save(String entity name, object)
 * 
 * 2. Save return unique identifier
 * 
 * 3 save method store transient object db and persist them
 * 
 * 4 save method should not be called on persist object
 * 
 * 5. if call save on persist object and no unique validation then duplicate recored inserted
 * 
 */
public class Save_method_test {

	//simply saving transient object in db
	public static void xmlConfigurationSaveMethod() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("1");
		stock.setStockName("ram1");
		session.save(stock);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	// we should not call save on persistent object
	// persist object saved only when txn commite, if any chagne hibernate do
	// autosave not need to call sava or saveor update agian
	// here stockname saved as ram3
	public static void xmlConfigurationSaveMethod1() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("2");
		stock.setStockName("ram2");
		session.save(stock);
		stock.setStockName("ram3");
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	// first calling save and getting one more seeion and calling save again
	// if no unique constraion two row inserted with same stockcode
	public static void xmlConfigurationSaveMethod2() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("3");
		stock.setStockName("ram4");
		session.save(stock);
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		stock.setStockName("ram5");
		session1.save(stock);
		session1.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	public static void main(String[] args) throws SQLException {
		xmlConfigurationSaveMethod2();
	}
}