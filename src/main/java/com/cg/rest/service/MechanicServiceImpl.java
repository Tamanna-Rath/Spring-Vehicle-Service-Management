package com.cg.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.dao.MechanicJpaDao;
import com.cg.rest.model.Mechanic;

@Transactional
@Service
public class MechanicServiceImpl implements MechanicService{
	
	@Autowired
	private MechanicJpaDao mechRepo;

	@Override
	public List<Mechanic> getAllMechanics() {
		List<Mechanic> mechanic = (List<Mechanic>)mechRepo.findAll();
		return mechanic;
	}

	@Override
	public Mechanic getMechanic(int mechanicId) {
		Optional<Mechanic> mechanicResponse = mechRepo.findById(mechanicId);
		Mechanic mechanic = mechanicResponse.get();
		return mechanic;
	}

	@Override
	public Mechanic addMechanic(Mechanic mechanic) {
		mechRepo.save(mechanic);
		return mechanic;
	}

	@Override
	public Mechanic saveAndFlush(Mechanic mechanic, int id) {
		Mechanic mechanic1 = mechRepo.findById(id).get();
		mechanic1.setmFirstName(mechanic.getmFirstName());
		mechanic1.setmLastName(mechanic.getmLastName());
		mechanic1.setmContactNumber(mechanic.getmContactNumber());
		mechanic1.setmEmail(mechanic.getmEmail());
		mechanic1.setmAddress(mechanic.getmAddress());
		Mechanic response = mechRepo.saveAndFlush(mechanic1);
		return response;
	}
	
}
