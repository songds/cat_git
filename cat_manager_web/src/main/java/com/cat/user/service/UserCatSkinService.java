package com.cat.user.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.UserCatSkinDao;
import com.cat.user.po.UserCatSkinPo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserCatSkinService {

	@Autowired
	private UserCatSkinDao userCatSkinDao;
	
	
	/**
	 * 根据用户和猫编号查询该用户下猫皮肤
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<UserCatSkinPo>> getByUserCatSkin(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<List<UserCatSkinPo>> info=new ResponeInfo<List<UserCatSkinPo>>("F00003","查询用户下猫皮肤失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("catSpeciesId"))){
					ResponeInfo<List<UserCatSkinPo>> info=new ResponeInfo<List<UserCatSkinPo>>("F00003","查询用户下猫皮肤失败，参数猫种类编号不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				String catSpeciesId=parameter.getString("catSpeciesId");
				List<UserCatSkinPo> userCatSkins=userCatSkinDao.getByUserNoAndCatSpeciesId(userNo, catSpeciesId);
				return ResponeInfo.ok(userCatSkins);
			}else{
				ResponeInfo<List<UserCatSkinPo>> info=new ResponeInfo<List<UserCatSkinPo>>("F00002","查询用户下猫皮肤失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<UserCatSkinPo>> info=new ResponeInfo<List<UserCatSkinPo>>("F00001","查询用户下猫皮肤异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	
	/**
	 * 添加用户下猫皮肤
	 * @param json json格式的字段串
	 * {userNo/用户名,catSpeciesId/猫种类编号,catSkinType/皮肤类型,defaultSkinSel/默认选择（Y/N）}
	 */
	@Transactional
	public ResponeInfo<UserCatSkinPo> saveByUserCatSkin(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00003","添加用户猫皮肤失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("catSpeciesId"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00004","添加用户猫皮肤失败，参数猫种类编号不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("catSkinType"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00004","添加用户猫皮肤失败，参数皮肤类型不能为空！",null);
					return info;
				}
				
				/*if(StringUtils.isEmpty(parameter.getString("defaultSkinSel"))){
					ResponeInfo<UserCatPo> info=new ResponeInfo<UserCatPo>("F00005","添加用户猫失败，参数默认选择不能为空！",null);
					return info;
				}*/
				
				String userNo=parameter.getString("userNo");
				String catSpeciesId=parameter.getString("catSpeciesId");
				String catSkinType=parameter.getString("catSkinType");
				String defaultSkinSel=parameter.getString("defaultSkinSel");
				UserCatSkinPo userCatSkin=userCatSkinDao.getByUserNoAndCatSpeciesIdAndCatSkinType(userNo, catSpeciesId, catSkinType);
				if(userCatSkin!=null){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00006","添加用户猫皮肤失败，您已拥有该猫皮肤！",null);
					return info;
				}else{
					int count=userCatSkinDao.countByUserNoAndCatSpeciesId(userNo,catSpeciesId);
					if(count>0){
						if(!StringUtils.isEmpty(defaultSkinSel)&&defaultSkinSel.equals("Y")){
							UserCatSkinPo  UserCatDefultSkin =userCatSkinDao.getByUserNoAndCatSpeciesIdAndCatSkinTypeAndDefaultSkinSel(userNo, catSpeciesId, catSkinType, "Y");
							if(UserCatDefultSkin!=null){
								UserCatDefultSkin.setDefaultSkinSel("N");
								UserCatDefultSkin.setUpdatedDate(new Date(System.currentTimeMillis()));
								userCatSkinDao.save(UserCatDefultSkin);
							}
							
						}
						userCatSkin=new UserCatSkinPo();
						userCatSkin.setUserNo(userNo);
						userCatSkin.setCatSpeciesId(catSpeciesId);
						userCatSkin.setCatSkinType(catSkinType);
						userCatSkin.setDefaultSkinSel(StringUtils.isEmpty(defaultSkinSel)?"N":defaultSkinSel);
						userCatSkinDao.save(userCatSkin);
						return ResponeInfo.ok(userCatSkin);
					}else{
						userCatSkin=new UserCatSkinPo();
						userCatSkin.setUserNo(userNo);
						userCatSkin.setCatSpeciesId(catSpeciesId);
						userCatSkin.setDefaultSkinSel("Y");
						userCatSkinDao.save(userCatSkin);
						return ResponeInfo.ok(userCatSkin);
					}
				}
				
			}else{
				ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00002","添加用户猫皮肤失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00001","添加用户猫皮肤异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	/**
	 * 设置用户猫皮肤默认选择
	 * @param json json格式的字段串
	 * {userNo/用户名,catSpeciesId/猫种类编号,catSkinType/皮肤类型,defaultSkinSel/默认选择（Y/N）}
	 */
	@Transactional
	public ResponeInfo<UserCatSkinPo> setByUserDefultCatSkin(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00003","设置用户猫默皮肤认选择失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("catSpeciesId"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00004","设置用户猫皮肤默认选择失败，参数猫种类编号不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("catSkinType"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00004","设置用户猫皮肤默认选择失败，参数皮肤类型不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("defaultSkinSel"))){
					ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00005","设置用户猫皮肤默认选择失败，参数默认选择不能为空！",null);
					return info;
				}
				
				String userNo=parameter.getString("userNo");
				String catSpeciesId=parameter.getString("catSpeciesId");
				String catSkinType=parameter.getString("catSkinType");
				String defaultSkinSel=parameter.getString("defaultSkinSel");
				UserCatSkinPo userCatSkin=userCatSkinDao.getByUserNoAndCatSpeciesIdAndCatSkinType(userNo, catSpeciesId, catSkinType);
				UserCatSkinPo  UserCatDefultSkin =userCatSkinDao.getByUserNoAndCatSpeciesIdAndCatSkinTypeAndDefaultSkinSel(userNo, catSpeciesId, catSkinType, "Y");
				if(UserCatDefultSkin!=null){
					UserCatDefultSkin.setDefaultSkinSel("N");
					UserCatDefultSkin.setUpdatedDate(new Date(System.currentTimeMillis()));
					userCatSkinDao.save(UserCatDefultSkin);
				}
				if(userCatSkin!=null){
					userCatSkin.setDefaultSkinSel(defaultSkinSel.equals("Y")?defaultSkinSel:"Y");
					userCatSkin.setUpdatedDate(new Date(System.currentTimeMillis()));
					userCatSkinDao.save(userCatSkin);
					return ResponeInfo.ok(userCatSkin);
				}else{
					userCatSkin=new UserCatSkinPo();
					userCatSkin.setUserNo(userNo);
					userCatSkin.setCatSpeciesId(catSpeciesId);
					userCatSkin.setCatSkinType(catSkinType);
					userCatSkin.setDefaultSkinSel(defaultSkinSel.equals("Y")?defaultSkinSel:"Y");
					userCatSkinDao.save(userCatSkin);
					return ResponeInfo.ok(userCatSkin);
				}
				
			}else{
				ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00002","设置用户猫皮肤默认选择失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserCatSkinPo> info=new ResponeInfo<UserCatSkinPo>("F00001","设置用户猫皮肤默认选择异常，请您联系客服！",null);
			return info;
		}
	}
}
