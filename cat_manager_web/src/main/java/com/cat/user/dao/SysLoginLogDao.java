package com.cat.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.user.po.SysLoginLogPo;

public interface SysLoginLogDao extends JpaRepository<SysLoginLogPo, Integer>{

}
