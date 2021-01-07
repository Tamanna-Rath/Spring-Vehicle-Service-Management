package com.cg.rest.service;

import java.util.List;

import com.cg.rest.model.Mechanic;

public interface MechanicService {
	public List<Mechanic> getAllMechanics();
	public Mechanic getMechanic(int mechanicId);
	public Mechanic addMechanic(Mechanic mechanic);
	public Mechanic saveAndFlush(Mechanic mechanic,int id);
	
}
