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
 * 修改用户地址信息
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class UpdateByUserAddrInfoApi {

	@Autowired
	private UserAddrInfoService userAddrInfoService;
	
	@RequestMapping(value="/updateByUserAddrInfo.do",method=RequestMethod.POST)
	public ResponeInfo<UserAddrInfoPo> updateByUserAddrInfo(@RequestBody String json){
		log.info(" method is /api/user/updateByUserAddrInfo.do to customer input parameter message :  {}",json);
		ResponeInfo<UserAddrInfoPo> result=userAddrInfoService.updateByUserAddrInfo(json);
		log.info(" /api/user/updateByUserAddrInfo.do  to result message :  {}",result);
		return result;
	};
}
