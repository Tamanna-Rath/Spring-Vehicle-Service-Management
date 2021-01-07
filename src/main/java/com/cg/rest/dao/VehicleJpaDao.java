package com.cg.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.rest.model.Vehicle;

@Repository
public interface VehicleJpaDao extends JpaRepository<Vehicle, Integer> {
	

	 
	
}