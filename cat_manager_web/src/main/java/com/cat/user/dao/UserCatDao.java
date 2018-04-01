package com.cat.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cat.user.po.UserCatPo;

public interface UserCatDao extends JpaRepository<UserCatPo, Integer>{

	public List<UserCatPo> getByUserNo(String userNo);
	
	public UserCatPo getByUserNoAndCatSpeciesId(String userNo,String catSpeciesId);
	
	public UserCatPo getByUserNoAndDefaultCatSel(String userNo,String defaultCatSel);
	
	@Query("FROM UserCatPo WHERE userNo=?1")
	public int countByUserNo(String userNo);
	
}
