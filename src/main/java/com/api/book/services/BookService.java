package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.api.book.dao.BookRepo;
import com.api.book.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
//	private static List<Book> list =new ArrayList<>();
	
//	static {
//		list.add(new Book(11, "xyz" ,"Java"));
//		list.add(new Book(12, "yzx" ,"C++"));
//		list.add(new Book(13, "abc" ,"Js"));
//	}
	
	//get All books
	public List<Book> getAllBooks()
	{
//		return list;
		return this.bookRepo.findAll();
	}
	//get book by id
	public Book getBookById(int id)
	{
//		Book book =null;
//		for(Book b:list)
//		{
//			if(b.getId() == id)
//			{
//				return b;
//			}
//		}
//		return book;
		Optional<Book> book = this.bookRepo.findById(id);
		if(book.isEmpty()) return null;
		return book.get();
	}
	
	//add new book
	public String addBook(Book book)
	{
//		list.add(book);
		this.bookRepo.save(book);
		return "Successfulyy save the data";
	}
	//delete book by id
	public String deleteBookById(int id) {
		// TODO Auto-generated method stub
//		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
//		if(ObjectUtils.isEmpty(list)) {
//			return "";
//		}
//		return "Successfully deleted....";
//		for(Book book:list)
//		{
//			if(book.getId()==id)
//			{
//				list.remove(book);
//				return "Successfully deleted....";
//			}
//		}
//		return "";
		Optional<Book> book = this.bookRepo.findById(id);
		if(book.isPresent())
		{
			this.bookRepo.deleteById(id);
			return "Successfully deleted....";
		}
		return "";
	}
	
	//update the data
	public Book updateBook(Book book)
	{
		
//		Book bb=new Book();
//		list = list.stream().map(b->{
//			if(b.getId() == book.getId())
//			{
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//				bb.setAuthor(book.getAuthor());
//				bb.setId(book.getId());
//				bb.setTitle(book.getTitle());
////				return b;
//			}
//			return b;
//		}).collect(Collectors.toList());
////		Book books = list.stream().filter(b -> b.getId() == book.getId()).findFirst().get();
////		books.setAuthor("Neer");
////		books.setTitle("AI");
//		return bb;
		
		Optional<Book> book1 = this.bookRepo.findById(book.getId());
		if(book1.isPresent())
		{
			this.bookRepo.save(book);
			return book;
		}
		Book b = new Book();
		b.setId(0);
		return b;
	}
}
