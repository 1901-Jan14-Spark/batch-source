package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.CatNotFoundException;
import com.revature.models.Cat;
import com.revature.services.CatService;

@Controller
public class CatController {
	
	@Autowired
	CatService catService;
	
	@GetMapping("/cats")
	@ResponseBody
<<<<<<< HEAD
	public List<Cat> getCats(@RequestParam(value="id", required=false)Integer id){
		if (id != null)
		{
			Cat c = catService.getCatById(id);
			if (c == null)
				throw new CatNotFoundException();
			else
			{
=======
	public List<Cat> getCats(@RequestParam(value="id",required=false)Integer id){
		if(id!=null) {
			Cat c = catService.getCatById(id);
			if(c == null) {
				throw new CatNotFoundException();
			} else {
>>>>>>> Carolyn_Rehm
				ArrayList<Cat> cats = new ArrayList<>();
				cats.add(c);
				return cats;
			}
<<<<<<< HEAD
			
=======
>>>>>>> Carolyn_Rehm
		}
		return catService.getCats();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/cats/{id}")
	@ResponseBody
	public Cat getCatById(@PathVariable("id")Integer id) {
//		System.out.println(id);
		Cat c = catService.getCatById(id);
		if(c == null) {
			// throw an exception associated with a 404 response status
			throw new CatNotFoundException();
		}
		return c;
	}
	
	// can also pass in request/response objects to our controller methods
//	@GetMapping("/search")
//	public String getCat(HttpServletRequest req) {
//		String catId = req.getParameter("id");
//		return "redirect:/cats/"+catId;
//		//forwarding a request: return "forward: [url]"
//	}
	
	@GetMapping("/new")
	public String returnNewCatPage() {
		return "NewCat";
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/cats")
	@PostMapping("/cats")
	public String addCat(@RequestParam("name")String name, @RequestParam("numOfLives")Integer numOfLives) {
		Cat cat = new Cat(name, numOfLives);
		catService.addCat(cat);
		return "redirect:/cats";
	}
	

	@RequestMapping(method=RequestMethod.GET, value="cats/{id}")
	@ResponseBody
	public Cat getCatById(@PathVariable("id")Integer id)
	{
		Cat c = catService.getCatById(id);
		if (c == null)
		{
			throw new CatNotFoundException();
		}
		return c;
	}
	
//	@GetMapping("/search")
//	@ResponseBody
//	public String getCat(HttpServletRequest req)
//	{
//		String catId = req.getParameter("id");
//		return "redirect:/cats/"+catId;
//	}
	
	@GetMapping("/new")
	public String returnNewCatPage()
	{
		return "NewCat";
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="cats")
	@PostMapping("/cats")
	public String addCat(@RequestParam("name")String name, @RequestParam("numOfLives")Integer num)
	{
		catService.addCat(new Cat(name, num));
		return "redirect:/cats";
	}
}
