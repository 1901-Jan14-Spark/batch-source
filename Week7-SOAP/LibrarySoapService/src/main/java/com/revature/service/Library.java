package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Book;

@WebService
public interface Library {
	//service endpoint interface
	
	public List<Book> getAllBooks();
	public String addBook(Book book);

}
