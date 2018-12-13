package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Session;


//delete  FROM stock  where stock_name in('GENM2','GENM3','GENM4','GENM6','GENM');

/*
 * 1. Get and load overloaded method by entity-name class-name and id ad object
 * 2. load throw object not found exception if object not found get retur null
 * 3 load return proxy object and get direct hid db 
 */
public class LoadGetMethodTest {

	// Overloaded load method example
	public static void xmlConfigurationLoadMethod() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("20");
		stock.setStockName("ram20");
		session.save(stock);
		int stockId = stock.getStockId();
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Stock stock1 = (Stock) session1.load(Stock.class, stockId);
		System.out
				.println("---- --load enity by load method enity name and id--------------"
						+ stock1.getStockName());
		Stock stock2 = (Stock) session1.load("com.hibernate.entity.Stock",
				stockId);
		System.out
				.println("------------load enity by load method by class name and id--------------"
						+ stock2.getStockName());
		HibernateUtil.shutdown();
	}

	// Overloaded load method example
	public static void xmlConfigurationGetMethod() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("21");
		stock.setStockName("ram21");
		session.save(stock);
		int stockId = stock.getStockId();
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Stock stock1 = (Stock) session1.get(Stock.class, stockId);
		System.out
				.println("---- --load enity by get method enity name and id--------------"
						+ stock1.getStockName());
		Stock stock2 = (Stock) session1.get("com.hibernate.entity.Stock",
				stockId);
		System.out
				.println("------------load enity by get method by class name and id--------------"
						+ stock2.getStockName());
		HibernateUtil.shutdown();
	}

	public static void main(String[] args) throws SQLException {

		// xmlConfigurationLoadMethod();
		// xmlConfigurationGetMethod();

	}
}