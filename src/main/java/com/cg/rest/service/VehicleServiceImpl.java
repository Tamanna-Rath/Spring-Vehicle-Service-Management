package com.cg.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.dao.VehicleJpaDao;
import com.cg.rest.model.Vehicle;

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleJpaDao vehRepo;

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		vehRepo.save(vehicle);
		return vehicle;
	}
	 
	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicle = (List<Vehicle>)vehRepo.findAll() ;
		return vehicle;
	}

	@Override
	public Vehicle saveAndFlush(Vehicle vehicle,int id) {
		Vehicle vehicle1 = vehRepo.findById(id).get();
		vehicle1.setVehicleBrand(vehicle.getVehicleBrand());
		vehicle1.setVehicleNumber(vehicle.getVehicleNumber());
		vehicle1.setVehicleType(vehicle.getVehicleType());
		Vehicle  response = vehRepo.saveAndFlush(vehicle1);
		return response;
	}

	@Override
	public Vehicle getVehicle(int vehicleId) {
		Optional<Vehicle> vehicleResponse = vehRepo.findById(vehicleId);
		Vehicle vehicle = vehicleResponse.get();
		return vehicle;
	}
	
}
