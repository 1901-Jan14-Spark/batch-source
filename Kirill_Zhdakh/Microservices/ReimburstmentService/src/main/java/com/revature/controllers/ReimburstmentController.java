package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reimburstment;

@RestController
@RequestMapping("/reimburstments")
public class ReimburstmentController {
	private Logger log = Logger.getLogger(Reimburstment.class);

	private List<Reimburstment> reimburstments = new ArrayList<>();
	
	public ReimburstmentController()
	{
		reimburstments.add(new Reimburstment(1, 1, "Cats", 500));
		reimburstments.add(new Reimburstment(2, 1, "Boxes", 50));
		reimburstments.add(new Reimburstment(3, 2, "Dogs", 1200));
		reimburstments.add(new Reimburstment(4, 2, "Leashes", 70));
		reimburstments.add(new Reimburstment(5, 3, "Bears???", 78023));
		reimburstments.add(new Reimburstment(6, 3, "Diamond Claws", 1000022333));
	}
	
	@GetMapping
	public List<Reimburstment> getAllReimburstments(){
		log.info("getting all reimburstments");
		return reimburstments;
	}
	
	@GetMapping("/{reimburstmentId}")
	public Reimburstment getReimburstmentById(@PathVariable("reimburstmentId") Integer reimburstmentId) {
		log.info("getting reimburstment by id: " + reimburstmentId);
		for(Reimburstment r: reimburstments) {
			if(reimburstmentId == r.getReimburstmentId()) {
				return r;
			}
		}
		return null;
	}
	
	@GetMapping("/customer/{customerId}")
	public List<Reimburstment> getReimburstmentsByCustomerId(@PathVariable("customerId") Integer customerId){
		return reimburstments.stream().filter(acct -> acct.getEmployeeId()==customerId)
				.collect(Collectors.toList());
	}
}
