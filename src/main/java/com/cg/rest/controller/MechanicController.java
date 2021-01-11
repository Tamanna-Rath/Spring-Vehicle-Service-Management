package com.cg.rest.controller;

import java.util.List;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.model.Mechanic;
import com.cg.rest.model.Vehicle;
import com.cg.rest.service.MechanicService;
import com.cg.rest.service.MechanicServiceImpl;

@RestController
@RequestMapping(value="/mechanic")
public class MechanicController {
	
	@Autowired
	private MechanicService mechanicService;
	
	private static final Logger logger = LogManager.getLogger(MechanicController.class);

	//add
	@PostMapping(value="/add")
	public ResponseEntity<Mechanic> addMechanic(@RequestBody final Mechanic mechanic) {
		logger.info("in controller -addMechanic");
		mechanicService.addMechanic(mechanic);
		return new ResponseEntity<Mechanic>(mechanic,HttpStatus.OK);
	}
	
	//getMechanicById
	@GetMapping(value= "/{id}")
	public ResponseEntity getMechanic(@PathVariable("id") int id) {
		Mechanic mechanicResponse = mechanicService.getMechanic(id);
		logger.info("in controller - getMechanic");
		return ResponseEntity.ok(mechanicResponse);
	}
	
	//getAllMechanics
	@GetMapping(value="/getAllMechanics")
	public ResponseEntity<List<Mechanic>> getAllMechanics(){
		List<Mechanic> mechanic = mechanicService.getAllMechanics();
		logger.info("in controller - getAllMechanics");
		return new ResponseEntity<List<Mechanic>>(mechanic,HttpStatus.OK);
	}
	
	//update
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Mechanic> save(@RequestBody Mechanic mechanic,@PathVariable int id) {
		mechanicService.saveAndFlush(mechanic, id);
		logger.info("in controller - update");
		return new ResponseEntity<Mechanic>(mechanic,HttpStatus.OK);
	}
	
}