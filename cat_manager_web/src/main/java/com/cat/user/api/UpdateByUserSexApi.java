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
 * 添加用户性别接口
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class UpdateByUserSexApi {

	@Autowired
	private SysUserInfoService sysUserInfoService;
	
	@RequestMapping(value="/updateByUserSex.do",method=RequestMethod.POST)
	public ResponeInfo<SysUserInfoPo> updateByUserSex(@RequestBody String json){
		log.info(" method is /api/user/updateByUserSex.do to customer input parameter message :  {}",json);
		ResponeInfo<SysUserInfoPo> result=sysUserInfoService.updateByUserSex(json);
		log.info(" /api/user/updateByUserSex.do  to result message :  {}",result);
		return result;
	};
}
