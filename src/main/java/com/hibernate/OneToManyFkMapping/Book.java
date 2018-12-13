package com.hibernate.OneToManyFkMapping;

import java.util.Date;
import java.util.Set;

public class Book {

	private long id;
    private String title;
    private String description;
    private Date publishedDate;
    private Set<Chapter> chapter;
    public Book() {
    }  
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Date getPublishedDate() {
        return publishedDate;
    }
 
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

	public Set<Chapter> getChapter() {
		return chapter;
	}

	public void setChapter(Set<Chapter> chapter) {
		this.chapter = chapter;
	}
 
	
 

}
