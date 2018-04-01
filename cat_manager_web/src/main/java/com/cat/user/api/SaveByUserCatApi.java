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
 * 添加用户猫种类
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class SaveByUserCatApi {
	
	@Autowired
	private UserCatService userCatService;
	
	@RequestMapping(value="/saveByUserCat.do",method=RequestMethod.POST)
	public ResponeInfo<UserCatPo> saveByUserCat(@RequestBody String json){
		log.info(" method is /api/user/saveByUserCat.do to customer input parameter message :  {}",json);
		ResponeInfo<UserCatPo> result=userCatService.saveByUserCat(json);
		log.info(" /api/user/saveByUserCat.do  to result message :  {}",result);
		return result;
	};
	
	
}
