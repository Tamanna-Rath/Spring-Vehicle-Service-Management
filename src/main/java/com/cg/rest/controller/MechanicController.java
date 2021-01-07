package com.cg.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.model.Mechanic;
import com.cg.rest.service.MechanicService;

@RestController
@RequestMapping(value="/mechanic")
public class MechanicController {
	
	@Autowired
	private MechanicService mechanicService;
	
	@PutMapping(value="/update/{id}")
	public Mechanic save(@RequestBody Mechanic mechanic,@PathVariable int id) {
		Mechanic mechanicResponse = mechanicService.saveAndFlush(mechanic, id);
		return mechanicResponse;
	}
	
	@GetMapping(value= "/{id}")
	public Mechanic getMechanic(@PathVariable int id) {
		Mechanic mechanicResponse = mechanicService.getMechanic(id);
		return mechanicResponse;
	}

	@GetMapping(value="/getAllMechanics")
	public List<Mechanic> getAllMechanics(){
		return mechanicService.getAllMechanics();
	}
	
	@PostMapping(value="/add")
	public Mechanic addMechanic(@RequestBody final Mechanic mechanic) {
		return mechanicService.addMechanic(mechanic);
		
	}
}
