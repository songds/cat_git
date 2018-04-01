package com.cat.cat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.cat.po.CatSpeciesPo;

public interface CatSpeciesDao extends JpaRepository<CatSpeciesPo, Integer>{

	
}
