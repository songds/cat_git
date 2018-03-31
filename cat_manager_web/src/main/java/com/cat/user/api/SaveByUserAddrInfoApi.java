package com.cat.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.common.util.ResponeInfo;
import com.cat.user.po.UserAddrInfoPo;
import com.cat.user.service.UserAddrInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 添加用户地址信息
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class SaveByUserAddrInfoApi {


	@Autowired
	private UserAddrInfoService userAddrInfoService;
	
	@RequestMapping(value="/saveByUserAddrInfo.do",method=RequestMethod.POST)
	public ResponeInfo<UserAddrInfoPo> saveByUserAddrInfo(@RequestBody String json){
		log.info(" method is /api/user/saveByUserAddrInfo.do to customer input parameter message :  {}",json);
		ResponeInfo<UserAddrInfoPo> result=userAddrInfoService.saveByUserAddrInfo(json);
		log.info(" /api/user/saveByUserAddrInfo.do  to result message :  {}",result);
		return result;
	};
}
