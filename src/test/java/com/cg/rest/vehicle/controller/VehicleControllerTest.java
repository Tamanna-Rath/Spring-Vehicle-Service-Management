package com.cg.rest.vehicle.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cg.rest.controller.VehicleController;
import com.cg.rest.model.Vehicle;
import com.cg.rest.service.VehicleService;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
public class VehicleControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	 @MockBean
	 private VehicleService vehicleService;
	 
	 @Test
		public void testNewVehicle() throws Exception{
		 	String URI = "/vehicle/add";
		 	Vehicle vehicle = new Vehicle();
		 	vehicle.setVehicleId(1);
			vehicle.setVehicleBrand("Tata");
			vehicle.setVehicleNumber("MH09HD5678");
			vehicle.setVehicleType("Four-Wheeler");
			
			String jsonInput = this.converttoJson(vehicle);
			
			Mockito.when(vehicleService.addVehicle(Mockito.any(Vehicle.class))).thenReturn(vehicle);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
					.andReturn();
			MockHttpServletResponse mockHttpServletResponse =   mvcResult.getResponse();
			String jsonOutput = mockHttpServletResponse.getContentAsString();
			assertThat(jsonInput).isEqualTo(jsonOutput);
			Assert.assertEquals(HttpStatus.OK.value(),mockHttpServletResponse.getStatus());
			
		}
		
	 @Test	
		public void testGetVehicle() throws Exception{
		 String URI = "/vehicle/{Id}";
		 Vehicle vehicle = new Vehicle();
		 vehicle.setVehicleId(102);
			vehicle.setVehicleBrand("Lamborghini");
			vehicle.setVehicleNumber("MH09HD5688");
			vehicle.setVehicleType("Four-Wheeler");
			
			String jsonInput= this.converttoJson(vehicle);
			Mockito.when(vehicleService.getVehicle(Mockito.anyInt())).thenReturn(vehicle);
			MvcResult mvcResult= this.mockMvc.perform(MockMvcRequestBuilders.get(URI,102).accept(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse =   mvcResult.getResponse();
			String jsonOutput = mockHttpServletResponse.getContentAsString();
			assertThat(jsonInput).isEqualTo(jsonOutput);
			Assert.assertEquals(HttpStatus.OK.value(),mockHttpServletResponse.getStatus());
	 }
	 
	 @Test
		public void  testGetAllVehicles() throws Exception{
		 String URI="/vehicle/getAllVehicles";
		 Vehicle vehicle = new Vehicle();
		 vehicle.setVehicleId(3);
			vehicle.setVehicleBrand("Khawasakhi");
			vehicle.setVehicleNumber("MH09DH5678");
			vehicle.setVehicleType("Two-Wheeler");
			
			 Vehicle vehicle1 = new Vehicle();
			 vehicle.setVehicleId(4);
			 vehicle1.setVehicleBrand("BMW");
				vehicle1.setVehicleNumber("MH09HD4528");
				vehicle1.setVehicleType("Four-Wheeler");
				
				List<Vehicle> vehicleList= new ArrayList<>();
				vehicleList.add(vehicle);
				vehicleList.add(vehicle1);
				
				String jsonInput = this.converttoJson(vehicleList);
				Mockito.when(vehicleService.getAllVehicles()).thenReturn(vehicleList);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();

		        assertThat(jsonInput).isEqualTo(jsonOutput);

		        
	 }
	 @Test
		public void testSaveAndFlush() throws Exception{
		 String URI = "/vehicle/update/{id}" ;
		 Vehicle vehicle1 = new Vehicle();
		 vehicle1.setVehicleId(5);
			vehicle1.setVehicleBrand("Yamaha");
			vehicle1.setVehicleNumber("MH09UT5678");
			vehicle1.setVehicleType("Two-Wheeler");
			
			String jsonInput = this.converttoJson(vehicle1);
			
			Mockito.when(vehicleService.saveAndFlush(Mockito.any(Vehicle.class),Mockito.anyInt())).thenReturn(vehicle1);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,103).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
			
	 }
	 private String converttoJson(Object vehicle1) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(vehicle1);
	    }


	 
}
