package com.hibernate.inheritanceentity;

import org.hibernate.Session;

import com.hibernate.inheritanceentity.Cheque;
import com.hibernate.inheritanceentity.CreditCard;


public class InheritanceTest {

	public static void main() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CreditCard c = new CreditCard();
		c.setPaymentId(10);
		c.setAmount(2500);
		c.setCreditCardType("Visa");
		Cheque c1 = new Cheque();
		c1.setPaymentId(11);
		c1.setAmount(2600);
		c1.setChequeType("ICICI");
		session.save(c);
		session.save(c1);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	public static void main(String[] args) {
		main();
	}

}
