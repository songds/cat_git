package com.cat.cat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.cat.po.CatChipPo;

public interface CatChipDao extends JpaRepository<CatChipPo, Integer>{

	public List<CatChipPo> getBySpeciesId(String speciesId);
}
