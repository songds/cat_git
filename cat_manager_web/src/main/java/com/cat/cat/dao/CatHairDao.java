package com.cat.cat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.cat.po.CatHairPo;

public interface CatHairDao extends JpaRepository<CatHairPo, Integer>{

	public List<CatHairPo> getBySpeciesId(String speciesId);
}
