package com.cat.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.common.util.ResponeInfo;
import com.cat.user.po.UserCatPo;
import com.cat.user.service.UserCatService;

import lombok.extern.slf4j.Slf4j;

/**
 * 设置用户猫默认选择
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class SetByUserDefultCatApi {
	
	@Autowired
	private UserCatService userCatService;
	
	@RequestMapping(value="/setByUserDefultCat.do",method=RequestMethod.POST)
	public ResponeInfo<UserCatPo> setByUserDefultCat(@RequestBody String json){
		log.info(" method is /api/user/setByUserDefultCat.do to customer input parameter message :  {}",json);
		ResponeInfo<UserCatPo> result=userCatService.setByUserDefultCat(json);
		log.info(" /api/user/setByUserDefultCat.do  to result message :  {}",result);
		return result;
	};
	
	
}
