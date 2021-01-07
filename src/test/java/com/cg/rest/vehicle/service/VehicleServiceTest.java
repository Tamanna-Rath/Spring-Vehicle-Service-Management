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
	 
	 
}
