package com.cat.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.user.po.QqLoginInfoPo;

public interface QqLoginInfoDao extends JpaRepository<QqLoginInfoPo, Integer>{

	public QqLoginInfoPo getQqPoByOpenId(String openId);
}
