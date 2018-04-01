package com.cat.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cat.user.po.UserCatSkinPo;

public interface UserCatSkinDao extends JpaRepository<UserCatSkinPo, Integer>{

	public List<UserCatSkinPo> getByUserNoAndCatSpeciesId(String userNo,String catSpeciesId);
	
	public UserCatSkinPo getByUserNoAndCatSpeciesIdAndCatSkinType(String userNo,String catSpeciesId,String catSkinType);
	
	public UserCatSkinPo getByUserNoAndCatSpeciesIdAndCatSkinTypeAndDefaultSkinSel(String userNo,String catSpeciesId,String catSkinType,String defaultSkinSel);
	
	@Query("FROM UserCatSkinPo WHERE userNo=?1 AND catSpeciesId=?2")
	public int countByUserNoAndCatSpeciesId(String userNo,String catSpeciesId);
	
}
