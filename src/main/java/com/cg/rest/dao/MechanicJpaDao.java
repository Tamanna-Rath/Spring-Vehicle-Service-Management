package com.cg.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.model.Mechanic;

@Repository
public interface MechanicJpaDao extends JpaRepository<Mechanic,Integer> {

}
