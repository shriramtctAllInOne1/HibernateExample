package com.hibernate.common;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.entity.Stock;
import com.hibernate.persistence.HibernateUtil;
import com.hibernate.persistence.HibernateUtilProgrammatic;

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

		// List<Stock>st=session1.get(Stock.class, stockId)

		Query query = (Query) session1.createQuery("from Stock");
		Stock books = (Stock) ((org.hibernate.Query) query).uniqueResult();
		System.out.println("------xmlConfiguration getStock-------------"+books.getStockName());

	}

	public static void programaticConfig() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtilProgrammatic.getSessionFactory().openSession();

		session.beginTransaction();
		Stock stock = new Stock();

		stock.setStockCode("47151");
		stock.setStockName("GENM1");
		System.out.println("--------------programaticConfiguration savestock--------");

		session.save(stock);
		session.getTransaction().commit();

		Session session1 = HibernateUtilProgrammatic.getSessionFactory().openSession();

		session1.beginTransaction();

		// List<Stock>st=session1.get(Stock.class, stockId)

		Query query = (Query) session1.createQuery("from Stock");
		Stock books = (Stock) ((org.hibernate.Query) query).uniqueResult();
		System.out.println("------programaticConfiguration getStock-------------"+books.getStockName());


	}
	
	public static void main( String[] args )
    {
		programaticConfig();
		xmlConfiguration();
       
        
    }
}
