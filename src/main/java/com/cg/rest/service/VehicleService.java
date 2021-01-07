package com.cg.rest.service;

import java.util.List;



import com.cg.rest.model.Vehicle;


public interface VehicleService {
	public List<Vehicle> getAllVehicles(); 
	public Vehicle getVehicle(int vehicleId);
	public Vehicle addVehicle(Vehicle vehicle);
	public Vehicle saveAndFlush(Vehicle vehicle,int id);
	
}
