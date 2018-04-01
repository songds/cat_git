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
 * 设置用户猫皮肤默认选择
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class SetByUserDefultCatSkinApi {
	
	@Autowired
	private UserCatSkinService userCatSkinService;
	
	@RequestMapping(value="/setByUserDefultCatSkin.do",method=RequestMethod.POST)
	public ResponeInfo<UserCatSkinPo> setByUserDefultCatSkin(@RequestBody String json){
		log.info(" method is /api/user/setByUserDefultCatSkin.do to customer input parameter message :  {}",json);
		ResponeInfo<UserCatSkinPo> result=userCatSkinService.setByUserDefultCatSkin(json);
		log.info(" /api/user/setByUserDefultCatSkin.do  to result message :  {}",result);
		return result;
	};
	
	
}
