package com.cat.user.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.UserAddrInfoDao;
import com.cat.user.po.UserAddrInfoPo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserAddrInfoService {

	@Autowired
	private UserAddrInfoDao userAddrInfoDao;
	
	/**
	 * 添加用户收货地址信息
	 * @param json json格式的字段串
	 * {userNo/用户名,province/省,city/市,area/区,street/街道,isDefult/是否默认,detailedAddress/详细地址,addressee/收件人,phoneNo/手机号码,postCode/邮政编码}
	 */
	@Transactional
	public ResponeInfo<UserAddrInfoPo> saveByUserAddrInfo(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("province"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("city"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("area"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("detailedAddress"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("addressee"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数收件人不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("phoneNo"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数手机号码不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("postCode"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","添加用户收获地址失败，参数邮政编码不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				String province=parameter.getString("province");
				String city=parameter.getString("city");
				String area=parameter.getString("area");
				String detailedAddress=parameter.getString("detailedAddress");
				String phoneNo=parameter.getString("phoneNo");
				String postCode=parameter.getString("postCode");
				String street=parameter.getString("street");
				String addressee=parameter.getString("addressee");
				List<UserAddrInfoPo> userAddrInfos=userAddrInfoDao.getByUserNo(userNo);
				if(userAddrInfos!=null&&userAddrInfos.size()>0){
					UserAddrInfoPo userAddrInfoPo=userAddrInfos.get(0);
					if(StringUtils.isEmpty(parameter.getString("isDefult"))){
						parameter.put("isDefult", "N");
					}else{
						parameter.put("isDefult", "Y");
						userAddrInfoPo.setIsDefult("N");
						userAddrInfoPo.setUpdatedDate(new Date(System.currentTimeMillis()));
						userAddrInfoDao.save(userAddrInfoPo);
					}
				}else{
					parameter.put("isDefult", "Y");
				}
				String isDefult=parameter.getString("isDefult");
				UserAddrInfoPo userAddrInfoPo=new UserAddrInfoPo();
				userAddrInfoPo.setAddressee(addressee);
				userAddrInfoPo.setArea(area);
				userAddrInfoPo.setCity(city);
				userAddrInfoPo.setIsDefult(isDefult);
				userAddrInfoPo.setDetailedAddress(detailedAddress);
				userAddrInfoPo.setPhoneNo(phoneNo);
				userAddrInfoPo.setPostCode(postCode);
				userAddrInfoPo.setProvince(province);
				userAddrInfoPo.setStreet(street);
				userAddrInfoPo.setUserNo(userNo);
				userAddrInfoDao.save(userAddrInfoPo);
				return ResponeInfo.ok(userAddrInfoPo);
			}else{
				ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00002","添加用户收获地址失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00001","添加用户收获地址异常，请您联系客服！",null);
			return info;
		}
	}
	
	
	/**
	 * 修改用户收货地址信息
	 * @param json json格式的字段串
	 * {userNo/用户名,province/省,city/市,area/区,street/街道,isDefult/是否默认,detailedAddress/详细地址,addressee/收件人,phoneNo/手机号码,postCode/邮政编码,objectId/地址编号}
	 */
	@Transactional
	public ResponeInfo<UserAddrInfoPo> updateByUserAddrInfo(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("province"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("city"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("area"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("detailedAddress"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数用户名不能为空！",null);
					return info;
				}
				
				if(StringUtils.isEmpty(parameter.getString("addressee"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数收件人不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("phoneNo"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数手机号码不能为空！",null);
					return info;
				}
				if(StringUtils.isEmpty(parameter.getString("postCode"))){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数邮政编码不能为空！",null);
					return info;
				}
				if(parameter.getIntValue("objectId")>0){
					ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00003","修改用户收获地址失败，参数地址编号不能为空！",null);
					return info;
				}
				int objectId=parameter.getIntValue("objectId");
				String userNo=parameter.getString("userNo");
				String province=parameter.getString("province");
				String city=parameter.getString("city");
				String area=parameter.getString("area");
				String detailedAddress=parameter.getString("detailedAddress");
				String phoneNo=parameter.getString("phoneNo");
				String postCode=parameter.getString("postCode");
				String street=parameter.getString("street");
				String addressee=parameter.getString("addressee");
				UserAddrInfoPo userAddrInfo=userAddrInfoDao.getByObjectId(objectId);
				List<UserAddrInfoPo> userAddrInfos=userAddrInfoDao.getByUserNo(userNo);
				if(userAddrInfos!=null&&userAddrInfos.size()>0){
					UserAddrInfoPo userAddrInfoPo=userAddrInfos.get(0);
					if(StringUtils.isEmpty(parameter.getString("isDefult"))){
						parameter.put("isDefult", "N");
					}else{
						parameter.put("isDefult", "Y");
						userAddrInfoPo.setIsDefult("N");
						userAddrInfoPo.setUpdatedDate(new Date(System.currentTimeMillis()));
						userAddrInfoDao.save(userAddrInfoPo);
					}
				}else{
					parameter.put("isDefult", 1);
				}
				String isDefult=parameter.getString("isDefult");
				if(userAddrInfo!=null){
					userAddrInfo.setAddressee(addressee);
					userAddrInfo.setArea(area);
					userAddrInfo.setCity(city);
					userAddrInfo.setIsDefult(isDefult);
					userAddrInfo.setDetailedAddress(detailedAddress);
					userAddrInfo.setPhoneNo(phoneNo);
					userAddrInfo.setPostCode(postCode);
					userAddrInfo.setProvince(province);
					userAddrInfo.setStreet(street);
					userAddrInfo.setUserNo(userNo);
					userAddrInfo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					userAddrInfo=new UserAddrInfoPo();
					userAddrInfo.setAddressee(addressee);
					userAddrInfo.setArea(area);
					userAddrInfo.setCity(city);
					userAddrInfo.setIsDefult(isDefult);
					userAddrInfo.setDetailedAddress(detailedAddress);
					userAddrInfo.setPhoneNo(phoneNo);
					userAddrInfo.setPostCode(postCode);
					userAddrInfo.setProvince(province);
					userAddrInfo.setStreet(street);
					userAddrInfo.setUserNo(userNo);
					userAddrInfo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				userAddrInfoDao.save(userAddrInfo);
				return ResponeInfo.ok(userAddrInfo);
			}else{
				ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00002","添加用户收获地址失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<UserAddrInfoPo> info=new ResponeInfo<UserAddrInfoPo>("F00001","添加用户收获地址异常，请您联系客服！",null);
			return info;
		}
	}
	
	/**
	 * 查询用户地址信息
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<UserAddrInfoPo>> getByUserAddr(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("userNo"))){
					ResponeInfo<List<UserAddrInfoPo>> info=new ResponeInfo<List<UserAddrInfoPo>>("F00003","查询用户地址信息失败，参数用户名不能为空！",null);
					return info;
				}
				String userNo=parameter.getString("userNo");
				List<UserAddrInfoPo> userAddrInfos=userAddrInfoDao.getByUserNo(userNo);
				return ResponeInfo.ok(userAddrInfos);
			}else{
				ResponeInfo<List<UserAddrInfoPo>> info=new ResponeInfo<List<UserAddrInfoPo>>("F00002","查询用户地址信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<UserAddrInfoPo>> info=new ResponeInfo<List<UserAddrInfoPo>>("F00001","查询用户地址信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	
}
