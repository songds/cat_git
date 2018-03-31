package com.cat.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.user.po.UserAccountManagerPo;

public interface UserAccountManagerDao  extends JpaRepository<UserAccountManagerPo, Integer>{

	public UserAccountManagerPo getByUserNo(String userNo);
}
