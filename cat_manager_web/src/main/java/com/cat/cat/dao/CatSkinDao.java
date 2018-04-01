package com.cat.cat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.cat.po.CatSkinPo;

public interface CatSkinDao extends JpaRepository<CatSkinPo, Integer>{

	public List<CatSkinPo> getBySpeciesId(String speciesId);
}