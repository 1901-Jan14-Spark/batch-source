package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Book;
import com.revature.service.Library;

public class Driver {

	public static void main(String[] args) {
		
		String serviceURL = "http://192.168.51.112:8080/LibrarySoapService/Library";
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(serviceURL);
		factory.setServiceClass(Library.class);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		Library library = (Library) factory.create();
		
//		List<Book> books = library.getAllBooks();
//		for(Book b: books) {
//			System.out.println(b);
//		}
		
		String response = library.addBook(new Book("Harry Potter and the Bean Factory","JK Rowling?", 2019));
		System.out.println(response);
		
//		List<Book> booksAgain = library.getAllBooks();
//		for(Book b: booksAgain) {
//			System.out.println(b);
//		}
		
		
	}

}
