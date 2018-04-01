package com.cat.user.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.UserCatDao;
import com.cat.user.po.UserCatPo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserCatService {

	@Autowired
	private UserCatDao userCatDao;
	/**
	 * 获取用户下的猫
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<UserCatPo>> getByUserCat(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<List<UserCatPo>> info=new ResponeInfo<List<UserCatPo>>("F00003","查询用户下的猫失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				List<UserCatPo> userCats=userCatDao.getByUserNo(userNo);
				return ResponeInfo.ok(userCats);
			}else{
				ResponeInfo<List<UserCatPo>> info=new ResponeInfo<List<UserCatPo>>("F00002","查询用户下的猫失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<UserCatPo>> info=new ResponeInfo<List<UserCatPo>>("F00001","查询用户下的猫异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	
	/**
	 * 添加用户猫种类
	 * @param json json格式的字段串
	 * {userNo/用户名,catSpeciesId/猫种类编号,defaultCatSel/默认选择（Y/N）}
	 */
	@Transactional
	public ResponeInfo<UserCatPo> saveByUserCat(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00003","添加用户猫失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("catSpeciesId"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00004","添加用户猫失败，参数猫种类编号不能为空！",null);
					return info;
				}
				
				/*if(StringUtils.isEmpty(parameter.getString("defaultCatSel"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00005","添加用户猫失败，参数默认选择不能为空！",null);
					return info;
				}*/
				
				String userNo=parameter.getString("userNo");
				String catSpeciesId=parameter.getString("catSpeciesId");
				String defaultCatSel=parameter.getString("defaultCatSel");
				UserCatPo userCat=userCatDao.getByUserNoAndCatSpeciesId(userNo, catSpeciesId);
				if(userCat!=null){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00006","添加用户猫失败，您已拥有该猫！",null);
					return info;
				}else{
					int count=userCatDao.countByUserNo(userNo);
					if(count>0){
						if(!StringUtils.isEmpty(defaultCatSel)&&defaultCatSel.equals("Y")){
							UserCatPo  userDefultCat =userCatDao.getByUserNoAndDefaultCatSel(userNo, "Y");
							if(userDefultCat!=null){
								userDefultCat.setDefaultCatSel("N");
								userDefultCat.setUpdatedDate(new Date(System.currentTimeMillis()));
								userCatDao.save(userDefultCat);
							}
							
						}
						userCat=new UserCatPo();
						userCat.setUserNo(userNo);
						userCat.setCatSpeciesId(catSpeciesId);
						userCat.setDefaultCatSel(StringUtils.isEmpty(defaultCatSel)?"N":defaultCatSel);
						userCatDao.save(userCat);
						return ResponeInfo.ok(userCat);
					}else{
						userCat=new UserCatPo();
						userCat.setUserNo(userNo);
						userCat.setCatSpeciesId(catSpeciesId);
						userCat.setDefaultCatSel("Y");
						userCatDao.save(userCat);
						return ResponeInfo.ok(userCat);
					}
				}
				
			}else{
				ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00002","添加用户猫失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00001","添加用户猫异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	/**
	 * 设置用户猫默认选择
	 * @param json json格式的字段串
	 * {userNo/用户名,catSpeciesId/猫种类编号,defaultCatSel/默认选择（Y/N）}
	 */
	@Transactional
	public ResponeInfo<UserCatPo> setByUserDefultCat(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00003","设置用户猫默认选择失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("catSpeciesId"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00004","设置用户猫默认选择失败，参数猫种类编号不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("defaultCatSel"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00005","设置用户猫默认选择失败，参数默认选择不能为空！",null);
					return info;
				}
				
				String userNo=parameter.getString("userNo");
				String catSpeciesId=parameter.getString("catSpeciesId");
				String defaultCatSel=parameter.getString("defaultCatSel");
				UserCatPo userCat=userCatDao.getByUserNoAndCatSpeciesId(userNo, catSpeciesId);
				UserCatPo  userDefultCat =userCatDao.getByUserNoAndDefaultCatSel(userNo, "Y");
				if(userDefultCat!=null){
					userDefultCat.setDefaultCatSel("N");
					userDefultCat.setUpdatedDate(new Date(System.currentTimeMillis()));
					userCatDao.save(userDefultCat);
				}
				if(userCat!=null){
					userCat.setDefaultCatSel(defaultCatSel.equals("Y")?defaultCatSel:"Y");
					userCat.setUpdatedDate(new Date(System.currentTimeMillis()));
					userCatDao.save(userCat);
					return ResponeInfo.ok(userCat);
				}else{
					userCat=new UserCatPo();
					userCat.setUserNo(userNo);
					userCat.setCatSpeciesId(catSpeciesId);
					userCat.setDefaultCatSel(defaultCatSel.equals("Y")?defaultCatSel:"Y");
					userCatDao.save(userCat);
					return ResponeInfo.ok(userCat);
				}
				
			}else{
				ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00002","设置用户猫默认选择失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00001","设置用户猫默认选择异常，请您联系客服！",null);
			return info;
		}
	}
}
