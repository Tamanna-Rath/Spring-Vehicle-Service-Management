package com.cg.rest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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


@RestController
@RequestMapping(value="/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	private static final Logger logger = LogManager.getLogger(VehicleController.class);
	
	@PutMapping(value = "/update/{id}")
	public Vehicle save(@RequestBody Vehicle vehicle,@PathVariable int id) {
		Vehicle vehicleResponse = vehicleService.saveAndFlush(vehicle,id);
		logger.info("in controller - save");
		return vehicleResponse;
	}
	
	@GetMapping(value ="/{id}")
	public Vehicle getVehicle(@PathVariable int id) {
		Vehicle vehicleResponse = vehicleService.getVehicle(id);
		logger.info("in controller - getVehicle");
		return vehicleResponse;
	}
	
	@GetMapping(value ="/getAllVehicles")
	public List<Vehicle> getAllVehicles(){
		logger.info("in controller -getAllVehicles");
		return vehicleService.getAllVehicles();
	}
	
	@PostMapping("/add")
	public Vehicle addVehicle(@RequestBody final Vehicle vehicle) {
		logger.info("in controller -addVehicle");
		return vehicleService.addVehicle(vehicle);
	}
}
