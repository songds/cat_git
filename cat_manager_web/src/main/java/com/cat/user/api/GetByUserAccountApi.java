package com.cat.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.common.util.ResponeInfo;
import com.cat.user.po.UserAccountManagerPo;
import com.cat.user.service.UserAccountManagerService;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取用户账户信息
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class GetByUserAccountApi {


	@Autowired
	private UserAccountManagerService userAccountManagerService;
	
	@RequestMapping(value="/getByUserAccount.do",method=RequestMethod.POST)
	public ResponeInfo<UserAccountManagerPo> getByUserAccount(@RequestBody String json){
		log.info(" method is /api/user/getByUserAccount.do to customer input parameter message :  {}",json);
		ResponeInfo<UserAccountManagerPo> result=userAccountManagerService.getByUserAccount(json);
		log.info(" /api/user/getByUserAccount.do  to result message :  {}",result);
		return result;
	};
	
	
}
