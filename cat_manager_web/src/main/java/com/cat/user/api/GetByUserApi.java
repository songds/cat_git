package com.cat.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.common.util.ResponeInfo;
import com.cat.user.po.SysUserInfoPo;
import com.cat.user.service.SysUserInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取用户信息
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class GetByUserApi {
	
	@Autowired
	private SysUserInfoService sysUserInfoService;
	
	@RequestMapping(value="/getByUser.do",method=RequestMethod.POST)
	public ResponeInfo<SysUserInfoPo> getByUser(@RequestBody String json){
		log.info(" method is /api/user/getByUser.do to customer input parameter message :  {}",json);
		ResponeInfo<SysUserInfoPo> result=sysUserInfoService.getByUser(json);
		log.info(" /api/user/getByUser.do  to result message :  {}",result);
		return result;
	};
	
}
