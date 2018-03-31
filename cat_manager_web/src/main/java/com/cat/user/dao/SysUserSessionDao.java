package com.cat.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.user.po.SysUserSessionPo;

public interface SysUserSessionDao extends JpaRepository<SysUserSessionPo, Integer>{

	public SysUserSessionPo getByUserNoAndLoginMode(String userNo,String loginMode);
}
