package com.cat.user.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.SysUserInfoDao;
import com.cat.user.po.SysUserInfoPo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysUserInfoService {

	@Autowired
	private SysUserInfoDao sysUserInfoDao;
	
	/**
	 * 修改用户信息
	 * @param json json格式的字段串
	 * {userNo/用户名,sex/性别,province/省份,cityOrArea/市/区,phoneNo/手机号码}
	 */
	@Transactional
	public ResponeInfo<SysUserInfoPo> saveByUserInfo(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				String sex=parameter.getString("sex");
				String cityOrArea=parameter.getString("cityOrArea");
				String province=parameter.getString("province");
				String phoneNo=parameter.getString("phoneNo");
				SysUserInfoPo sysUserInfo=sysUserInfoDao.getByUserNo(userNo);
				if(sysUserInfo!=null){
					sysUserInfo.setSex(sex);
					sysUserInfo.setProvince(province);
					sysUserInfo.setCityOrArea(cityOrArea);
					sysUserInfo.setPhoneNo(phoneNo);
					sysUserInfo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserInfo=new SysUserInfoPo();
					sysUserInfo.setUserNo(userNo);
					sysUserInfo.setSex(sex);
					sysUserInfo.setProvince(province);
					sysUserInfo.setCityOrArea(cityOrArea);
					sysUserInfo.setPhoneNo(phoneNo);
				}
				sysUserInfoDao.save(sysUserInfo);
				return ResponeInfo.ok(sysUserInfo);
			}else{
				ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00002","修改用户信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00001","修改用户信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	/**
	 * 修改用户性别
	 * @param json json格式的字段串
	 * {userNo/用户名,sex/性别}
	 */
	@Transactional
	public ResponeInfo<SysUserInfoPo> updateByUserSex(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户性别失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("sex"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户性别失败，参数性别不能为空！",null);
					return info;
				}
				
				String userNo=parameter.getString("userNo");
				String sex=parameter.getString("sex");
				SysUserInfoPo sysUserInfo=sysUserInfoDao.getByUserNo(userNo);
				if(sysUserInfo!=null){
					sysUserInfo.setSex(sex);
					sysUserInfo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserInfo=new SysUserInfoPo();
					sysUserInfo.setUserNo(userNo);
					sysUserInfo.setSex(sex);
				}
				sysUserInfoDao.save(sysUserInfo);
				return ResponeInfo.ok(sysUserInfo);
			}else{
				ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00002","修改用户性别失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00001","修改用户性别异常，请您联系客服！",null);
			return info;
		}
	}
	
	/**
	 * 修改用户地区
	 * @param json json格式的字段串
	 * {userNo/用户名,province/省份,cityOrArea/市/区}
	 */
	@Transactional
	public ResponeInfo<SysUserInfoPo> updateByUserArea(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户地区失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("area"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户地区失败，参数性别不能为空！",null);
					return info;
				}
				
				String userNo=parameter.getString("userNo");
				String cityOrArea=parameter.getString("cityOrArea");
				String province=parameter.getString("province");
				SysUserInfoPo sysUserInfo=sysUserInfoDao.getByUserNo(userNo);
				if(sysUserInfo!=null){
					sysUserInfo.setProvince(province);
					sysUserInfo.setCityOrArea(cityOrArea);
					sysUserInfo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserInfo=new SysUserInfoPo();
					sysUserInfo.setUserNo(userNo);
					sysUserInfo.setProvince(province);
					sysUserInfo.setCityOrArea(cityOrArea);
				}
				sysUserInfoDao.save(sysUserInfo);
				return ResponeInfo.ok(sysUserInfo);
			}else{
				ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00002","修改用户地区失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00001","修改用户地区异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	/**
	 * 修改用户绑定手机号码
	 * @param json json格式的字段串
	 * {userNo/用户名,phoneNo/手机号码}
	 */
	@Transactional
	public ResponeInfo<SysUserInfoPo> updateByUserBindPhoneNo(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户绑定手机号码失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("phoneNo"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","修改用户绑定手机号码失败，参数手机号码不能为空！",null);
					return info;
				}
				
				String userNo=parameter.getString("userNo");
				String phoneNo=parameter.getString("phoneNo");
				SysUserInfoPo sysUserInfo=sysUserInfoDao.getByUserNo(userNo);
				if(sysUserInfo!=null){
					sysUserInfo.setPhoneNo(phoneNo);
					sysUserInfo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserInfo=new SysUserInfoPo();
					sysUserInfo.setUserNo(userNo);
					sysUserInfo.setPhoneNo(phoneNo);
				}
				sysUserInfoDao.save(sysUserInfo);
				return ResponeInfo.ok(sysUserInfo);
			}else{
				ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00002","修改绑定手机号码失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00001","修改绑定手机号码异常，请您联系客服！",null);
			return info;
		}
	}
	
	public ResponeInfo<SysUserInfoPo> getByUser(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00003","查询用户信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				SysUserInfoPo sysUserInfo=sysUserInfoDao.getByUserNo(userNo);
				return ResponeInfo.ok(sysUserInfo);
			}else{
				ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00002","查询用户信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<SysUserInfoPo> info=new ResponeInfo<SysUserInfoPo>("F00001","查询用户信息异常，请您联系客服！",null);
			return info;
		}
	}
	
}
