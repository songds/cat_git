package com.cat.user.api;

import java.util.List;

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
 * 获取用户地址信息
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/user")
public class GetByUserAddrApi {


	@Autowired
	private UserAddrInfoService userAddrInfoService;
	
	@RequestMapping(value="/getByUserAddr.do",method=RequestMethod.POST)
	public ResponeInfo<List<UserAddrInfoPo>> getByUserAddr(@RequestBody String json){
		log.info(" method is /api/user/getByUserAddr.do to customer input parameter message :  {}",json);
		ResponeInfo<List<UserAddrInfoPo>> result=userAddrInfoService.getByUserAddr(json);
		log.info(" /api/user/getByUserAddr.do  to result message :  {}",result);
		return result;
	};
}
