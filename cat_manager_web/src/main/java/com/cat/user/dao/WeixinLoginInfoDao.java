package com.cat.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cat.user.po.WeixinLoginInfoPo;

public interface WeixinLoginInfoDao extends JpaRepository<WeixinLoginInfoPo, Integer>{

	public WeixinLoginInfoPo getWeixinPoByOpenId(String openId);
}
