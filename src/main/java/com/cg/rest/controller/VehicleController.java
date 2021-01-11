package com.cg.rest.controller;

import java.util.List;
import java.util.logging.Level;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.model.Vehicle;
import com.cg.rest.service.VehicleService;
import com.cg.rest.service.VehicleServiceImpl;


@RestController
@RequestMapping(value="/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	private static final Logger logger = LogManager.getLogger(VehicleController.class);
	
	//add
	@PostMapping("/add")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody final Vehicle vehicle) {
		logger.info("in controller -addVehicle");
		vehicleService.addVehicle(vehicle);
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	}
	
	//getVehicleById
	@GetMapping(value ="/{id}")
	public ResponseEntity getVehicle(@PathVariable("id") int id) {
		Vehicle vehicleResponse = vehicleService.getVehicle(id);
		logger.info("in controller - getVehicle");
		return ResponseEntity.ok(vehicleResponse);
	}
	
	//getAllVehicles
	@GetMapping(value ="/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles(){
		List<Vehicle> vehicle = vehicleService.getAllVehicles();
		logger.info("in controller -getAllVehicles");
		return new ResponseEntity<List<Vehicle>>(vehicle,HttpStatus.OK);
	}
	
	//update
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle,@PathVariable int id) {
		vehicleService.saveAndFlush(vehicle,id);
		logger.info("in controller - update");
		return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
	}
	
	
}