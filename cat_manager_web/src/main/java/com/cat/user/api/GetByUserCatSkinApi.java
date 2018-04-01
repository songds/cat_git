package com.cat.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.common.util.ResponeInfo;
import com.cat.user.po.UserCatSkinPo;
import com.cat.user.service.UserCatSkinService;

import lombok.extern.slf4j.Slf4j;

/**
 * 根据用户和猫编号查询该用户下猫皮肤
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class GetByUserCatSkinApi {
	
	@Autowired
	private UserCatSkinService userCatSkinService;
	
	@RequestMapping(value="/getByUserCatSkin.do",method=RequestMethod.POST)
	public ResponeInfo<List<UserCatSkinPo>> getByUserCatSkin(@RequestBody String json){
		log.info(" method is /api/user/getByUserCatSkin.do to customer input parameter message :  {}",json);
		ResponeInfo<List<UserCatSkinPo>> result=userCatSkinService.getByUserCatSkin(json);
		log.info(" /api/user/getByUserCatSkin.do  to result message :  {}",result);
		return result;
	};
	
	
}
