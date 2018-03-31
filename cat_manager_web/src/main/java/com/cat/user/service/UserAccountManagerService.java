package com.cat.user.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.UserAccountManagerDao;
import com.cat.user.po.UserAccountManagerPo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserAccountManagerService {

	@Autowired
	private UserAccountManagerDao userAccountManagerDao;
	
	
	/**
	 * 查询用户账户信息
	 * @param json
	 * @return
	 */
	public ResponeInfo<UserAccountManagerPo> getByUserAccount(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00003","查询用户账户信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				UserAccountManagerPo userAccountManager=userAccountManagerDao.getByUserNo(userNo);
				return ResponeInfo.ok(userAccountManager);
			}else{
				ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00002","查询用户账户信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00001","查询用户账户信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	/**
	 * 修改用户账户金币信息
	 * @param json json格式的字段串
	 * {userNo/用户名,catMoney/金币}
	 */
	@Transactional
	public ResponeInfo<UserAccountManagerPo> updateByUserMoney(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00003","修改用户账户金币信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				int catMoney=parameter.getIntValue("catMoney");
				if(catMoney<0){
					catMoney=0;
				}
				UserAccountManagerPo userAccountManager=userAccountManagerDao.getByUserNo(userNo);
				if(userAccountManager!=null){
					userAccountManager.setCatMoney(catMoney);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					userAccountManager=new UserAccountManagerPo();
					userAccountManager.setUserNo(userNo);
					userAccountManager.setCatMoney(catMoney);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				userAccountManagerDao.save(userAccountManager);
				return ResponeInfo.ok(userAccountManager);
			}else{
				ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00002","修改用户账户金币信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00001","修改用户账户金币信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	/**
	 * 修改用户账户点卷信息
	 * @param json json格式的字段串
	 * {userNo/用户名,catDnf/点卷}
	 */
	@Transactional
	public ResponeInfo<UserAccountManagerPo> updateByUserDNF(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00003","修改用户账户点券信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				int catDnf=parameter.getIntValue("catDnf");
				if(catDnf<0){
					catDnf=0;
				}
				UserAccountManagerPo userAccountManager=userAccountManagerDao.getByUserNo(userNo);
				if(userAccountManager!=null){
					userAccountManager.setCatDnf(catDnf);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					userAccountManager=new UserAccountManagerPo();
					userAccountManager.setUserNo(userNo);
					userAccountManager.setCatDnf(catDnf);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				userAccountManagerDao.save(userAccountManager);
				return ResponeInfo.ok(userAccountManager);
			}else{
				ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00002","修改用户账户点券信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00001","修改用户账户点券信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	
	/**
	 * 修改用户账户钻石信息
	 * @param json json格式的字段串
	 * {userNo/用户名,catDiamond/钻石}
	 */
	@Transactional
	public ResponeInfo<UserAccountManagerPo> updateByUserDiamond(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00003","修改用户账户钻石信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				int catDiamond=parameter.getIntValue("catDiamond");
				if(catDiamond<0){
					catDiamond=0;
				}
				UserAccountManagerPo userAccountManager=userAccountManagerDao.getByUserNo(userNo);
				if(userAccountManager!=null){
					userAccountManager.setCatDiamond(catDiamond);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					userAccountManager=new UserAccountManagerPo();
					userAccountManager.setUserNo(userNo);
					userAccountManager.setCatDiamond(catDiamond);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				userAccountManagerDao.save(userAccountManager);
				return ResponeInfo.ok(userAccountManager);
			}else{
				ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00002","修改用户账户钻石信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00001","修改用户账户钻石信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	
	/**
	 * 修改用户账户积分信息
	 * @param json json格式的字段串
	 * {userNo/用户名,catIntegral/积分}
	 */
	@Transactional
	public ResponeInfo<UserAccountManagerPo> updateByUserIntegral(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00003","修改用户账户积分信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				int catIntegral=parameter.getIntValue("catIntegral");
				if(catIntegral<0){
					catIntegral=0;
				}
				UserAccountManagerPo userAccountManager=userAccountManagerDao.getByUserNo(userNo);
				if(userAccountManager!=null){
					userAccountManager.setCatIntegral(catIntegral);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					userAccountManager=new UserAccountManagerPo();
					userAccountManager.setUserNo(userNo);
					userAccountManager.setCatIntegral(catIntegral);
					userAccountManager.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				userAccountManagerDao.save(userAccountManager);
				return ResponeInfo.ok(userAccountManager);
			}else{
				ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00002","修改用户账户积分信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAccountManagerPo> info=new ResponeInfo<UserAccountManagerPo>("F00001","修改用户账户积分信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	
}
