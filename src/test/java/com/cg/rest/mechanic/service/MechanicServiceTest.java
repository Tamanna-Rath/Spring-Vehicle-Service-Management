package com.cg.rest.mechanic.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.rest.dao.MechanicJpaDao;
import com.cg.rest.model.Mechanic;
import com.cg.rest.service.MechanicService;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MechanicServiceTest {
	
	@MockBean
	 private MechanicJpaDao mechanicJpaDao;
	 
	 @Autowired
	 private MechanicService mechanicService;
	 
	 @Test
		public void testAddMechanic(){
			Mechanic mechanic = new Mechanic();
			mechanic.setMechanicId(1);
			mechanic.setmFirstName("Suraj");
			mechanic.setmLastName("Patil");
			mechanic.setmContactNumber("8796541254");
			mechanic.setmEmail("surajpatil@gmail.com");
			mechanic.setmAddress("Dombivli");
			
			Mockito.when(mechanicJpaDao.save(mechanic)).thenReturn(mechanic);
			assertThat(mechanicService.addMechanic(mechanic)).isEqualTo(mechanic);
		}
	
	 
	
		
	@Test
	public void  testGetAllMechanics() {
		Mechanic mechanic = new Mechanic();
		mechanic.setMechanicId(1);
		mechanic.setmFirstName("Chetan");
		mechanic.setmLastName("Desai");
		mechanic.setmContactNumber("7896541254");
		mechanic.setmEmail("chetandesai@gmail.com");
		mechanic.setmAddress("Hyderabad");
		Mechanic mechanic1 = new Mechanic();
		mechanic1.setMechanicId(1);
		mechanic1.setmFirstName("Mansi");
		mechanic1.setmLastName("Chaudhari");
		mechanic.setmEmail("mansichaudhari@gmail.com");
		mechanic1.setmContactNumber("7896541741");
		mechanic1.setmAddress("Allahabad");
		
		List<Mechanic> mechanicList= new ArrayList<>();
		mechanicList.add(mechanic);
		mechanicList.add(mechanic1);
		
		Mockito.when(mechanicJpaDao.findAll()).thenReturn(mechanicList);
        assertThat(mechanicService.getAllMechanics()).isEqualTo(mechanicList);

	}
	
	
	
	}
