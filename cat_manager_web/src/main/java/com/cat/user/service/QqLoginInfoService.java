package com.cat.user.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.QqLoginInfoDao;
import com.cat.user.dao.SysLoginLogDao;
import com.cat.user.dao.SysUserDeviceDao;
import com.cat.user.dao.SysUserSessionDao;
import com.cat.user.po.QqLoginInfoPo;
import com.cat.user.po.SysLoginLogPo;
import com.cat.user.po.SysUserDevicePo;
import com.cat.user.po.SysUserSessionPo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class QqLoginInfoService {

	
	@Autowired
	private QqLoginInfoDao qqLoginInfoDao;
	
	@Autowired
	private SysLoginLogDao sysLoginLogDao;
	
	@Autowired
	private SysUserSessionDao sysUserSessionDao;
	
	@Autowired
	private SysUserDeviceDao sysUserDeviceDao;
	
	/**
	 * QQ快捷登陆接口
	 * @param json json格式的字段串
	 * {openId,unionId,token,qqId,qqName,qqImageUrl}
	 */
	@Transactional
	public ResponeInfo<JSONObject> qqLogin(String json){
		
		try {
			JSONObject result=new JSONObject();
			JSONObject jsonParameter=JSONObject.parseObject(json);
			String openId=jsonParameter.getString("opendId");
			String unionId=jsonParameter.getString("unionId");
			String token=jsonParameter.getString("token");
			//String ipAddr=jsonParameter.getString("ipAddr");
			QqLoginInfoPo qqInfo=qqLoginInfoDao.getQqPoByOpenId(openId);
			SysLoginLogPo sysLoginLog=new SysLoginLogPo();
			sysLoginLog.setDeviceId(jsonParameter.getString("deviceId"));
			sysLoginLog.setIpAddr(jsonParameter.getString("ipAddr"));
			sysLoginLog.setLoginMode("Q");
			sysLoginLog.setLoginType("LOGIN");
			if(qqInfo!=null){
				SysUserSessionPo sysUserSessionPo=sysUserSessionDao.getByUserNoAndLoginMode(qqInfo.getUserNo(),"Q");
				if(sysUserSessionPo!=null){
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserSessionPo=new SysUserSessionPo();
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setLoginType("LOGIN");
					sysUserSessionPo.setLoginMode("Q");
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				sysUserSessionDao.save(sysUserSessionPo);
				result.put("data", qqInfo);
				result.put("toke", token);
			}else{
				qqInfo=new QqLoginInfoPo();
				String userNo="Q"+System.currentTimeMillis();
				qqInfo.setUserNo(userNo);
				qqInfo.setOpenId(openId);
				qqInfo.setUnionId(unionId);
				qqInfo.setQqImageUrl(jsonParameter.getString("qqImageUrl"));
				qqInfo.setQqName(jsonParameter.getString("qqName"));
				qqInfo.setQqId(jsonParameter.getString("qqId"));
				SysUserSessionPo sysUserSessionPo=sysUserSessionDao.getByUserNoAndLoginMode(qqInfo.getUserNo(),"Q");
				if(sysUserSessionPo!=null){
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserSessionPo=new SysUserSessionPo();
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setLoginType("LOGIN");
					sysUserSessionPo.setLoginMode("Q");
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				sysUserSessionDao.save(sysUserSessionPo);
				result.put("data", qqInfo);
				result.put("toke", token);
			}
			qqLoginInfoDao.save(qqInfo);
			sysLoginLog.setUserNo(qqInfo.getUserNo());
			sysLoginLogDao.save(sysLoginLog);
			SysUserDevicePo sysUserDevicePo=new SysUserDevicePo();
			sysUserDevicePo.setAppVersion(jsonParameter.getString("appVersion"));
			sysUserDevicePo.setClientV(jsonParameter.getString("clientV"));
			sysUserDevicePo.setDevice(jsonParameter.getString("device"));
			sysUserDevicePo.setDeviceId(jsonParameter.getString("deviceId"));
			sysUserDevicePo.setIpAddr(jsonParameter.getString("ipAddr"));
			sysUserDevicePo.setUserNo(qqInfo.getUserNo());
			sysUserDeviceDao.save(sysUserDevicePo);
			return ResponeInfo.ok(result);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<JSONObject> info=new ResponeInfo<JSONObject>("F00001","登录异常，请您联系客服！",null);
			return info;
		}
		
	}
}
