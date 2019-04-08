package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Soap;

@WebService
public interface SoapService {
	public List<Soap> getAllSoap();
	public String addSoap(Soap soap);
}
