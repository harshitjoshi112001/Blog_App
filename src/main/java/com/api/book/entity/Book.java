package com.api.book.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Author author;
	@OneToMany(mappedBy = "book")
	@JsonManagedReference   //for parent class
	private List<Author> author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Author getAuthor() {
//		return author;
//	}
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
	
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public Book(int id, Author author, String title) {
//		super();
//		this.id = id;
//		this.author = author;
//		this.title = title;
//	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String title, List<Author> author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + "]";
	}
	
	
}
