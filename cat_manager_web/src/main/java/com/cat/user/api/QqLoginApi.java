package com.cat.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.util.ResponeInfo;
import com.cat.user.service.QqLoginInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * QQ快捷登录接口
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class QqLoginApi {

	@Autowired
	private QqLoginInfoService qqLoginInfoService;
	
	@RequestMapping(value="/qqLogin.do",method=RequestMethod.POST)
	public ResponeInfo<JSONObject> qqLogin(@RequestBody String json){
		log.info(" method is /api/user/qqLogin.do to customer input parameter message :  {}",json);
		ResponeInfo<JSONObject> result=qqLoginInfoService.qqLogin(json);
		log.info(" /api/user/qqLogin.do  to result message :  {}",result);
		return result;
	};
}
