package com.cat.cat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.cat.po.CatBodyPo;

public interface CatBodyDao  extends JpaRepository<CatBodyPo, Integer>{

	public List<CatBodyPo> getBySpeciesId(String speciesId);
}
