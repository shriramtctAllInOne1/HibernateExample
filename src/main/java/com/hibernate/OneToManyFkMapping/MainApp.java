package com.hibernate.OneToManyFkMapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;



public class MainApp {

	// loads configuration and mappings
	public static void main(String[] args) {
		OneToManySave();
		//OneToManyDelete();
	}
	
	public static void OneToManySave() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// creates a Book entity
		Book newBook = new Book();
		newBook.setTitle("Effective Java");
		newBook.setDescription("Best practices for Java programming");
		newBook.setPublishedDate(new Date());

		Chapter chapter = new Chapter();
		chapter.setTitle("inheritance");
		chapter.setNoOfPages(10);
		// session.save(chapter);
		Set<Chapter> chaperset = new HashSet<Chapter>();
		chaperset.add(chapter);
		newBook.setChapter(chaperset);
		// persists the book entity
		session.saveOrUpdate(newBook);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void OneToManyDelete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Book book =(Book) session.load(Book.class, 1);
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}

}
