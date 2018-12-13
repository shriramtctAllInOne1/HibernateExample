package com.hibernate.componenetmapping;

import org.hibernate.Session;



public class MainApp {

	public static void main(String[] args) {
		componentMapping();
	}
	public static void componentMapping(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee e1 = new Employee();
		e1.setName("shriram");
		Address address1 = new Address();
		address1.setCity("bangalore");
		address1.setCountry("India");
		address1.setPincode(201301);
		e1.setAddress(address1);
		session.save(e1);
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		HibernateUtil.shutdown();
	}
}
