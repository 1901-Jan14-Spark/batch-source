package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Cat;
import com.revature.services.CatService;

@Controller
public class CatController {
	
	@Autowired
	CatService catService;
	
	@GetMapping("/cats")
	@ResponseBody
	public List<Cat> getCats(){
		return catService.getCats();
	}

}
