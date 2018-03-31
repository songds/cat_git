package com.cat.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.service.WeixinLoginInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 微信快捷登录接口
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class WeixinLoginApi {

	@Autowired
	private WeixinLoginInfoService weixinLoginInfoService;
	
	@RequestMapping(value="/weixinLogin.do",method=RequestMethod.POST)
	public ResponeInfo<JSONObject> weixinLogin(@RequestBody String json){
		log.info(" method is /api/user/weixinLogin.do to customer input parameter message :  {}",json);
		ResponeInfo<JSONObject> result=weixinLoginInfoService.weixinLogin(json);
		log.info(" /api/user/weixinLogin.do  to result message :  {}",result);
		return result;
	};
	
	
}
