package com.revature.service;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {
	
	private List<Book> bookList = new ArrayList<>();
	
	public LibraryImpl() {
		super();
		bookList.add(new Book("Programming for Dummies", "Someone Smarter", 2000));
		bookList.add(new Book("Catcher in the Rye", "JD Salinger",1951));
		bookList.add(new Book("Of Mice and Men","John Steinbeck",1937));
		bookList.add(new Book("The Hungry Caterpillar", "Eric Carle",1969));
	}

	@Override
	public List<Book> getAllBooks() {
		return bookList;
	}

	@Override
	public String addBook(Book book) {
		if(bookList.contains(book)) {
			throw new RuntimeException("Book has already been added!");
		}
		bookList.add(book);
		return book.getName()+" added to the library";
	}

}
