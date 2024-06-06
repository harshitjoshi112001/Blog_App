package com.api.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
	
}
