package com.revature.main;

import java.io.PrintWriter;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Soap;
import com.revature.service.SoapService;

public class Driver {
	public static void main(String[] args) {
		String serviceURL ="http://192.168.61.181:8080/SoapService/Soap";
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(serviceURL);
		factory.setServiceClass(SoapService.class);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		SoapService distributor = (SoapService) factory.create();
		
		String response = distributor.addSoap(new Soap(10,"Old Town Funk","Grampa Jones"));
		
		System.out.println(response);
	}
}
