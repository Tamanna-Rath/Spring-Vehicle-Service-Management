package com.cg.rest.mechanic.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
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

import com.cg.rest.controller.MechanicController;

import com.cg.rest.model.Mechanic;

import com.cg.rest.service.MechanicService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MechanicController.class)
public class MechanicControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	 @MockBean
	 private MechanicService mechanicService;
	 
	 @Test
		public void testNewMechanic() throws Exception{
		 	String URI = "/mechanic/add";
		 	Mechanic mechanic = new Mechanic();
		 	mechanic.setMechanicId(1);
		 	mechanic.setmFirstName("Monika");
		 	mechanic.setmLastName("Sharma");
		 	mechanic.setmContactNumber("9632587410");
		 	mechanic.setmEmail("monikasharma@gmail.com");
		 	mechanic.setmAddress("Gandhinagar");
			String jsonInput = this.converttoJson(mechanic);
			
			Mockito.when(mechanicService.addMechanic(Mockito.any(Mechanic.class))).thenReturn(mechanic);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
					.andReturn();
			MockHttpServletResponse mockHttpServletResponse =   mvcResult.getResponse();
			String jsonOutput = mockHttpServletResponse.getContentAsString();
			assertThat(jsonInput).isEqualTo(jsonOutput);
			Assert.assertEquals(HttpStatus.OK.value(),mockHttpServletResponse.getStatus());
			
		}
		
	 @Test	
		public void testGetMechanic() throws Exception{
		 String URI = "/mechanic/{Id}";
		 Mechanic mechanic = new Mechanic();
		 mechanic.setMechanicId(102);
		 mechanic.setmFirstName("Monika");
		 	mechanic.setmLastName("Sharma");
		 	mechanic.setmContactNumber("9632587410");
		 	mechanic.setmEmail("monikasharma@gmail.com");
		 	mechanic.setmAddress("Manali");
			
			String jsonInput= this.converttoJson(mechanic);
			Mockito.when(mechanicService.getMechanic(Mockito.anyInt())).thenReturn(mechanic);
			MvcResult mvcResult= this.mockMvc.perform(MockMvcRequestBuilders.get(URI,102).accept(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse =   mvcResult.getResponse();
			String jsonOutput = mockHttpServletResponse.getContentAsString();
			assertThat(jsonInput).isEqualTo(jsonOutput);
			
	 }
	 
	 @Test
		public void  testGetAllMechanics() throws Exception{
		 String URI="/mechanic/getAllMechanics";
		 Mechanic mechanic = new Mechanic();
		 mechanic.setMechanicId(3);
		 mechanic.setmFirstName("Kashmera");
		 	mechanic.setmLastName("Shah");
		 	mechanic.setmContactNumber("9632587410");
		 	mechanic.setmEmail("kashmirashah@gmail.com");
		 	mechanic.setmAddress("kashmir");
			
		 Mechanic mechanic1 = new Mechanic();
		 mechanic.setMechanicId(4);
		 mechanic.setmFirstName("Kavita");
		 	mechanic.setmLastName("Kaushik");
		 	mechanic.setmContactNumber("9632587410");
		 	mechanic.setmEmail("kavitakaushik@gmail.com");
		 	mechanic.setmAddress("Kanpur");
				
				List<Mechanic> mechanicList= new ArrayList<>();
				mechanicList.add(mechanic);
				mechanicList.add(mechanic1);
				
				String jsonInput = this.converttoJson(mechanicList);
				Mockito.when(mechanicService.getAllMechanics()).thenReturn(mechanicList);
		        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();

		        assertThat(jsonInput).isEqualTo(jsonOutput);

		        
	 }
	 @Test
		public void testSaveAndFlush() throws Exception{
		 String URI = "/mechanic/update/{id}" ;
		 Mechanic mechanic1 = new Mechanic();
		 mechanic1.setMechanicId(103);
		 mechanic1.setmFirstName("Monika");
		 	mechanic1.setmLastName("Sharma");
		 	mechanic1.setmContactNumber("9632587410");
		 	mechanic1.setmEmail("monikasharma@gmail.com");
		 	mechanic1.setmAddress("Gandhinagar");
			
			String jsonInput = this.converttoJson(mechanic1);
			
			Mockito.when(mechanicService.saveAndFlush(Mockito.any(Mechanic.class),Mockito.anyInt())).thenReturn(mechanic1);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,103).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
			
	 }
	 /**
	     * Convert Object into Json String by using Jackson ObjectMapper
	     * @param ticket
	     * @return
	     * @throws JsonProcessingException
	     */
	    private String converttoJson(Object mechanic1) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(mechanic1);
	    }
}


	 
