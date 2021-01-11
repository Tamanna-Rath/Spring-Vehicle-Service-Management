package com.cg.rest.vehicle.dao;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import org.springframework.test.context.junit4.SpringRunner;

import com.cg.rest.dao.VehicleJpaDao;
import com.cg.rest.model.Vehicle;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleJpaDaoTest {
	
	@Autowired
	private VehicleJpaDao vehicleJpaDao;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Test
	public void testNewVehicle() throws Exception{
		Vehicle vehicle = new Vehicle();
		Vehicle saveInDb = testEntityManager.persist(vehicle);
		Vehicle getFromInDb = vehicleJpaDao.findById(saveInDb.getVehicleId()).get();
		
		assertThat(getFromInDb).isEqualTo(saveInDb);
		
	}
	
 @Test	
	public void testGetVehicle() throws Exception{
	 Vehicle vehicle = new Vehicle();
		
		vehicle.setVehicleBrand("Lamborghini");
		vehicle.setVehicleNumber("MH09HD5688");
		vehicle.setVehicleType("Four-Wheeler");
		
		Vehicle saveInDb = testEntityManager.persist(vehicle);
		Vehicle getInDb = vehicleJpaDao.findById(vehicle.getVehicleId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
 }
 
 @Test
	public void  testGetAllVehicles() throws Exception{
	 Vehicle vehicle = new Vehicle();
		vehicle.setVehicleBrand("Tata");
		vehicle.setVehicleNumber("MH09HD5666");
		vehicle.setVehicleType("Four-Wheeler");
		
		 Vehicle vehicle1 = new Vehicle();
		 vehicle1.setVehicleBrand("Texas");
			vehicle1.setVehicleNumber("MH09HD");
			vehicle1.setVehicleType("Four-Wheeler");
			
			testEntityManager.persist(vehicle);
	        testEntityManager.persist(vehicle1);
			
			List<Vehicle> vehicleList= (List<Vehicle>) vehicleJpaDao.findAll();
			
	        Assert.assertEquals(2, vehicleList.size());
}
 
 
 @Test
	public void testSaveAndFlush() {
	 Vehicle vehicle1 = new Vehicle();
	 	
		vehicle1.setVehicleBrand("Yamaha");
		vehicle1.setVehicleNumber("MH09UT5678");
		vehicle1.setVehicleType("Two-Wheeler");
		
		 testEntityManager.persist(vehicle1);
		
		Vehicle getFromDb = vehicleJpaDao.findById(vehicle1.getVehicleId()).get();
		getFromDb.setVehicleBrand("Suzuki");
		testEntityManager.persist(getFromDb);
		
		assertThat(getFromDb.getVehicleBrand()).isEqualTo("Suzuki");
 }

	
}
