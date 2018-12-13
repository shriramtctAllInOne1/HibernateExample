package com.hibernate.common;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.entity.Book;
import com.hibernate.entitymanager.SessionManager;

public class EntityApp {

	public static void main() {
		System.out.println("Maven + Hibernate + h2");
		EntityManager manager = SessionManager.getEntitiyManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		Query query = manager.createQuery("select b from Book b");
		List<Book> list = query.getResultList();
		tran.commit();
		manager.close();
		for(Book st:list){
			System.out.println(st.getBookName());
		}

	}

	public static void main1() {
		System.out.println("Maven + Hibernate + h2");
		EntityManager manager = SessionManager.getEntitiyManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		Book book = new Book();
		book.setBookName("java");
        book.setPrice(100l);
        book.setPublisherCode("101");
        book.setIsbn("1");
		manager.persist(book);
		tran.commit();
		manager.close();

	}

	public static void main(String[] args) {
		//main1();
		main();

	}

}
