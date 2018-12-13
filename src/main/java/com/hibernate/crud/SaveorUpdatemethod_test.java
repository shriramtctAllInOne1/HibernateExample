package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Session;



//delete  FROM stock  where stock_name in('GENM2','GENM3','GENM4','GENM6','GENM');

/*
 * 1. SaveOrUpdate is overloaded method SaveOrUpdate(String entity name, object)
 * 
 * 2. Save return no identifier
 * 
 * 3. save check if identifier exist or not if exist then update otherwise save
 * 
 * 4. save we call on persist object and transit both
 * 
 */
public class SaveorUpdatemethod_test {

	// first calling save and save and update to modify existing obj
	public static void xmlConfigurationSaveORUpdateMethod() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("11");
		stock.setStockName("ram11");
		session.save(stock);
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		stock.setStockName("ram12");
		session1.saveOrUpdate(stock);
		session1.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	// calling saveOrupdate and txn commit modifying object hibernate do auto-save
	public static void xmlConfigurationSaveORUpdateMethod2() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock stock = new Stock();
		stock.setStockCode("13");
		stock.setStockName("ram13");
		session.saveOrUpdate(stock);
		stock.setStockName("ram14");
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	public static void main(String[] args) throws SQLException {
		// programaticConfig();
		// xmlConfiguration();
		// xmlConfigurationLoadMethod();
		// xmlConfigurationGetMethod();
		// xmlConfigurationSave1Method();
		xmlConfigurationSaveORUpdateMethod2();
	}
}