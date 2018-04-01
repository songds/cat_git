package com.cat.cat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.cat.po.CatFoodPo;

public interface CatFoodDao extends JpaRepository<CatFoodPo, Integer>{

	public List<CatFoodPo> getBySpeciesId(String speciesId);
}
