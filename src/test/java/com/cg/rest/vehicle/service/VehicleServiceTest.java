package com.cg.rest.vehicle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito;
import com.cg.rest.dao.VehicleJpaDao;
import com.cg.rest.model.Vehicle;
import com.cg.rest.service.VehicleService;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {
	
	 @MockBean
	 private VehicleJpaDao vehicleJpaDao;
	 
	 @Autowired
	 private VehicleService vehicleService;
	 
	 @Test
		public void testAddVehicle(){
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(2);
			vehicle.setVehicleBrand("Tata");
			vehicle.setVehicleNumber("MH09HD5678");
			vehicle.setVehicleType("Four-Wheeler");
			
			Mockito.when(vehicleJpaDao.save(vehicle)).thenReturn(vehicle);
			assertThat(vehicleService.addVehicle(vehicle)).isEqualTo(vehicle);
			
		}
		
	 
	 
	 @Test
		public void  testGetAllVehicles() throws Exception{
		 Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(1);
			vehicle.setVehicleBrand("Tata");
			vehicle.setVehicleNumber("MH09HD5678");
			vehicle.setVehicleType("Four-Wheeler");
			 Vehicle vehicle1 = new Vehicle();
			 vehicle1.setVehicleBrand("BMW");
				vehicle1.setVehicleNumber("MH09HD6789");
				vehicle1.setVehicleType("Four-Wheeler");
				
				List<Vehicle> vehicleList= new ArrayList<>();
				vehicleList.add(vehicle);
				vehicleList.add(vehicle1);
				
				Mockito.when(vehicleJpaDao.findAll()).thenReturn(vehicleList);
		        assertThat(vehicleService.getAllVehicles()).isEqualTo(vehicleList);
	 }
	 
	 @Test
		public void testGetVehicle() throws Exception {
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleId(1);
			vehicle.setVehicleBrand("Tata");
			vehicle.setVehicleNumber("MH09H");
			vehicle.setVehicleType("Four-Wheeler");
			
			Optional<Vehicle> vehicle1 = Optional.of(vehicle);
			Mockito.when(vehicleJpaDao.findById(1)).thenReturn(vehicle1);
			assertThat(vehicleService.getVehicle(1)).isEqualTo(vehicle);
		}

		@Test
		public void testSaveAndFlush() throws Exception {
			Vehicle vehicle1 = new Vehicle();
			vehicle1.setVehicleId(1);
			vehicle1.setVehicleBrand("Yamaha");
			vehicle1.setVehicleNumber("MH09");
			vehicle1.setVehicleType("Two-Wheeler");
			Optional<Vehicle> optional= Optional.of(vehicle1);
			Mockito.when(vehicleJpaDao.findById(1)).thenReturn(optional);
			 vehicle1=optional.get();
			 vehicle1.setVehicleNumber("MH085");
			  Mockito.when(vehicleJpaDao.saveAndFlush(vehicle1)).thenReturn(vehicle1);
			assertThat(vehicleService.saveAndFlush(vehicle1, 1)).isEqualTo(vehicle1);
		}
}
