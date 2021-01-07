package com.cg.rest.mechanic.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.rest.controller.MechanicController;
import com.cg.rest.dao.MechanicJpaDao;
import com.cg.rest.model.Mechanic;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MechanicJpaDaoTest {

	@Autowired
	private MechanicJpaDao mechanicJpaDao;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Test
	public void testNewMechanic() throws Exception{
		Mechanic mechanic = new Mechanic();
		Mechanic saveInDb = testEntityManager.persist(mechanic);
		Mechanic getFromInDb = mechanicJpaDao.findById(saveInDb.getMechanicId()).get();
		
		assertThat(getFromInDb).isEqualTo(saveInDb);
		
	}
	
 @Test	
	public void testGetMechanic() throws Exception{
	 Mechanic mechanic = new Mechanic();
		
	 mechanic.setmFirstName("Vikas");
	 	mechanic.setmLastName("Gupta");
	 	mechanic.setmContactNumber("9000000000");
	 	mechanic.setmEmail("vikasgupta@gmail.com");
	 	mechanic.setmAddress("Goa");
		
	 Mechanic saveInDb = testEntityManager.persist(mechanic);
	 Mechanic getInDb = mechanicJpaDao.findById(mechanic.getMechanicId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
 }
 
 @Test
	public void  testGetAllMechanics() throws Exception{
	 Mechanic mechanic = new Mechanic();
	 mechanic.setmFirstName("Sonali");
	 	mechanic.setmLastName("phogat");
	 	mechanic.setmContactNumber("9555444342");
	 	mechanic.setmEmail("sonaliphogat@gmail.com");
	 	mechanic.setmAddress("Phulabani");
	 	
	 Mechanic mechanic1 = new Mechanic();
	 mechanic1.setmFirstName("Arshi");
	 	mechanic1.setmLastName("Khan");
	 	mechanic1.setmContactNumber("9876543210");
	 	mechanic1.setmEmail("arshikhan@gmail.com");
	 	mechanic1.setmAddress("Agra");
			
			testEntityManager.persist(mechanic);
	        testEntityManager.persist(mechanic1);
			
			List<Mechanic> mechanicList= (List<Mechanic>) mechanicJpaDao.findAll();
			
	        Assert.assertEquals(2, mechanicList.size());
 }
 @Test
	public void testSaveAndFlush() {
	 Mechanic mechanic1 = new Mechanic();
	 mechanic1.setmFirstName("Soniya");
	 	mechanic1.setmLastName("Yadav");
	 	mechanic1.setmContactNumber("9993355666");
	 	mechanic1.setmEmail("soniyayadav@gmail.com");
	 	mechanic1.setmAddress("Agra");
		
		testEntityManager.persist(mechanic1);
		
		Mechanic getFromDb = mechanicJpaDao.findById(mechanic1.getMechanicId()).get();
		mechanic1.setmLastName("Mishra");
		testEntityManager.persist(getFromDb);
		
		assertThat(getFromDb.getmLastName()).isEqualTo("Mishra");
 }

	
}