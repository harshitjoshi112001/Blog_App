package com.api.book.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.api.book.dao.BookRepo;
import com.api.book.entity.Author;
import com.api.book.entity.Book;

@ExtendWith(SpringExtension.class)
public class BookServiceTest {

    static List<Book> bookList;
    static List<Author> author;
	
	@Mock
	private BookRepo bookRepo;
	
	@InjectMocks
	private BookService bookService;
		
	@BeforeAll
	static void setUp(){
		
		bookList = new ArrayList<>();
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Title 1");
		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("Title 2");
		
		Author author1 = new Author();
		author1.setAuthorId(1);
		author1.setFirstName("first 1");
		author1.setLastName("last 1");
		Author author2 = new Author();
		author2.setAuthorId(2);
		author2.setFirstName("first 2");
		author2.setLastName("last 2");
		author = new ArrayList<>();
		author.add(author2);
		author.add(author1);
		bookList.add(book1);
		bookList.add(book2);
	}
	
	
	@Test
	void testGetAllBooks(){
		
		when(bookRepo.findAll()).thenReturn(bookList);
		List<Book> list = bookService.getAllBooks();
		assertNotNull(list);
		assertTrue(list instanceof List<Book>);
	}
}
