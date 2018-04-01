package com.cat.user.api;

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
 * 添加用户下猫皮肤
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class SaveByUserCatSkinApi {
	
	@Autowired
	private UserCatSkinService userCatSkinService;
	
	@RequestMapping(value="/saveByUserCatSkin.do",method=RequestMethod.POST)
	public ResponeInfo<UserCatSkinPo> saveByUserCatSkin(@RequestBody String json){
		log.info(" method is /api/user/saveByUserCatSkin.do to customer input parameter message :  {}",json);
		ResponeInfo<UserCatSkinPo> result=userCatSkinService.saveByUserCatSkin(json);
		log.info(" /api/user/saveByUserCatSkin.do  to result message :  {}",result);
		return result;
	};
	
	
}
