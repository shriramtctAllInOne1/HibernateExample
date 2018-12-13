package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;



//delete  FROM stock  where stock_name in('GENM2','GENM3','GENM4','GENM6','GENM');

public class App {
	public static void xmlConfiguration() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("4715");
		stock.setStockName("GENM");
		session.save(stock);
		session.getTransaction().commit();
		System.out.println("--------------xmlConfiguration savestock--------");
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Query query = (Query) session1.createQuery("from Stock");
		Stock books = (Stock) ((org.hibernate.Query) query).uniqueResult();
		System.out.println("------xmlConfiguration getStock-------------"
				+ books.getStockName());
		HibernateUtil.shutdown();
	}

	public static void programaticConfig() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory()
				.openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("47151");
		stock.setStockName("GENM1");
		System.out
				.println("--------------programaticConfiguration savestock--------");
		session.save(stock);
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory()
				.openSession();
		session1.beginTransaction();
		Query query = (Query) session1.createQuery("from Stock");
		Stock books = (Stock) ((org.hibernate.Query) query).uniqueResult();
		System.out
				.println("------programaticConfiguration getStock-------------"
						+ books.getStockName());
		HibernateUtil.shutdown();
	}

	public static void main(String[] args) throws SQLException {
		// programaticConfig();
		// xmlConfiguration();

	}
}