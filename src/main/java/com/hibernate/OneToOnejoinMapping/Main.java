package com.hibernate.OneToOnejoinMapping;

import org.hibernate.Session;



//delete from testdb.address where addressId=1;
//delete from testdb.emp where employeeId=1;
public class Main {

	public static void main(String[] args) {
		oneToOneMappingTest();
	}
	public static void oneToOneMappingTest(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee e1 = new Employee();
		e1.setName("shriram");
		e1.setEmail("ram@gmail.com");
		Address address1 = new Address();
		address1.setAddressLine1("G-21,Lohia nagar");
		address1.setCity("bangalore");
		address1.setState("karnataka");
		address1.setCountry("India");
		address1.setPincode(201301);
		e1.setAddress(address1);
		address1.setEmployee(e1);
		session.save(address1);
		session.save(e1);
		// No need to save address entity it will be auto save
		session.getTransaction().commit();
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		Address add=(Address) session1.get(Address.class, 1);
		Employee e= (Employee) session1.get(Employee.class, 1);
		System.out.println(add.getEmployee().getEmployeeId());
		System.out.println(e.getEmployeeId());
		HibernateUtil.shutdown();
	}
}
