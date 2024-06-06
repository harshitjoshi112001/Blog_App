package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookSer;
	
	@GetMapping("/books")   //get all books
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list = this.bookSer.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookId(@PathVariable("id") int id)
	{
		Book book = this.bookSer.getBookById(id);
		if(ObjectUtils.isEmpty(book)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public String saveBook(@RequestBody Book book)
	{
		return this.bookSer.addBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") int id)
	{
		String s = this.bookSer.deleteBookById(id);
		if(s.equals("")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(s));
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateBook(@RequestBody Book book)
	{
		Book b = this.bookSer.updateBook(book);
		if(b.getId()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(b));
	}
}
