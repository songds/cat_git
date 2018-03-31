package com.cat.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cat.common.po.SysAreaSettingPo;

public interface SysAreaSettingDao extends JpaRepository<SysAreaSettingPo, Integer>{

	@Query("FROM SysAreaSettingPo WHERE areaLevel=0 ")
	public List<SysAreaSettingPo> getRootArea();
	
	public List<SysAreaSettingPo> getAreaByParentAreaCode(String parentAreaCode);
	
}
