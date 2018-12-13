package com.hibernate.crud;

import java.sql.SQLException;

import org.hibernate.Session;



/*
 * 1. if we are having mapping b/w two entities then we can use fetch type lazy to load dependent entity  
 * 2. but if want to load master entity itself load as lazy we get by getReference method defined in IdentiferLoadAcess class
 */
public class lazyLoadingByGetReference {

	public static void lazyLoading() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Stock persistobj = (Stock) session.byId(Stock.class).getReference(9);
		session.getTransaction().commit();
		System.out.println(persistobj.getStockName());
		HibernateUtil.shutdown();
	}
	public static void main(String[] args) throws SQLException {
		lazyLoading();

	}
}