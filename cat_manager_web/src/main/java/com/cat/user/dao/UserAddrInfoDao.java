package com.cat.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cat.user.po.UserAddrInfoPo;

public interface UserAddrInfoDao extends JpaRepository<UserAddrInfoPo, Integer>{

	@Query("FROM UserAddrInfoPo ORDER BY isDefult DESC ")
	public List<UserAddrInfoPo> getByUserNo(String userNo);
	
	public UserAddrInfoPo getByObjectId(int objectId);
}
