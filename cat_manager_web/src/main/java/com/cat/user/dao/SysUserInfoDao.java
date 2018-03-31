package com.cat.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.user.po.SysUserInfoPo;

public interface SysUserInfoDao  extends JpaRepository<SysUserInfoPo, Integer>{

	public SysUserInfoPo getByUserNo(String userNo);
}
