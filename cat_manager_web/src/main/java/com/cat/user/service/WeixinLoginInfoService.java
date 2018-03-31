package com.cat.user.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.dao.SysLoginLogDao;
import com.cat.user.dao.SysUserDeviceDao;
import com.cat.user.dao.SysUserSessionDao;
import com.cat.user.dao.WeixinLoginInfoDao;
import com.cat.user.po.SysLoginLogPo;
import com.cat.user.po.SysUserDevicePo;
import com.cat.user.po.SysUserSessionPo;
import com.cat.user.po.WeixinLoginInfoPo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeixinLoginInfoService {

	@Autowired
	private WeixinLoginInfoDao weixinLoginInfoDao;
	
	@Autowired
	private SysLoginLogDao sysLoginLogDao;
	
	@Autowired
	private SysUserSessionDao sysUserSessionDao;
	
	@Autowired
	private SysUserDeviceDao sysUserDeviceDao;
	
	/**
	 * 微信快捷登陆接口
	 * @param json json格式的字段串
	 * {openId,unionId,token,weixinImageUrl,weixinName,weixinId}
	 */
	@Transactional
	public ResponeInfo<JSONObject> weixinLogin(String json){
		JSONObject result=new JSONObject();
		try {
			JSONObject jsonParameter=JSONObject.parseObject(json);
			String openId=jsonParameter.getString("openId");
			String unionId=jsonParameter.getString("unionId");
			String token=jsonParameter.getString("token");
			//String ipAddr=jsonParameter.getString("ipAddr");
			WeixinLoginInfoPo weixin=weixinLoginInfoDao.getWeixinPoByOpenId(openId);
			SysLoginLogPo sysLoginLog=new SysLoginLogPo();
			sysLoginLog.setDeviceId(jsonParameter.getString("deviceId"));
			sysLoginLog.setIpAddr(jsonParameter.getString("ipAddr"));
			sysLoginLog.setLoginMode("W");
			sysLoginLog.setLoginType("LOGIN");
			if(weixin!=null){
				SysUserSessionPo sysUserSessionPo=sysUserSessionDao.getByUserNoAndLoginMode(weixin.getUserNo(),"W");
				if(sysUserSessionPo!=null){
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserSessionPo=new SysUserSessionPo();
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setLoginType("LOGIN");
					sysUserSessionPo.setLoginMode("W");
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				sysUserSessionDao.save(sysUserSessionPo);
				result.put("data", weixin);
				result.put("toke", token);
			}else{
				weixin=new WeixinLoginInfoPo();
				String userNo="Q"+System.currentTimeMillis();
				weixin.setUserNo(userNo);
				weixin.setOpenId(openId);
				weixin.setUnionId(unionId);
				weixin.setWeixinImageUrl(jsonParameter.getString("weixinImageUrl"));
				weixin.setWeixinName(jsonParameter.getString("weixinName"));
				weixin.setWeixinId(jsonParameter.getString("weixinId"));
				SysUserSessionPo sysUserSessionPo=sysUserSessionDao.getByUserNoAndLoginMode(weixin.getUserNo(),"W");
				if(sysUserSessionPo!=null){
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}else{
					sysUserSessionPo=new SysUserSessionPo();
					sysUserSessionPo.setToken(token);
					sysUserSessionPo.setLoginType("LOGIN");
					sysUserSessionPo.setLoginMode("W");
					sysUserSessionPo.setDeviceId(jsonParameter.getString("deviceId"));
					sysUserSessionPo.setExpirationTime(new Date(System.currentTimeMillis()));
					sysUserSessionPo.setUpdatedDate(new Date(System.currentTimeMillis()));
				}
				sysUserSessionDao.save(sysUserSessionPo);
				result.put("data", jsonParameter);
				result.put("token", token);
			}
			weixinLoginInfoDao.save(weixin);
			sysLoginLog.setUserNo(weixin.getUserNo());
			sysLoginLogDao.save(sysLoginLog);
			SysUserDevicePo sysUserDevicePo=new SysUserDevicePo();
			sysUserDevicePo.setAppVersion(jsonParameter.getString("appVersion"));
			sysUserDevicePo.setClientV(jsonParameter.getString("clientV"));
			sysUserDevicePo.setDevice(jsonParameter.getString("device"));
			sysUserDevicePo.setDeviceId(jsonParameter.getString("deviceId"));
			sysUserDevicePo.setIpAddr(jsonParameter.getString("ipAddr"));
			sysUserDevicePo.setUserNo(weixin.getUserNo());
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
