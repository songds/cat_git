package com.cat.user.api;

import java.util.List;

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
 * 获取用户下的猫
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class GetByUserCatApi {
	
	@Autowired
	private UserCatService userCatService;
	
	@RequestMapping(value="/getByUserCat.do",method=RequestMethod.POST)
	public ResponeInfo<List<UserCatPo>> getByUserCat(@RequestBody String json){
		log.info(" method is /api/user/getByUserCat.do to customer input parameter message :  {}",json);
		ResponeInfo<List<UserCatPo>> result=userCatService.getByUserCat(json);
		log.info(" /api/user/getByUserCat.do  to result message :  {}",result);
		return result;
	};
	
	
}
