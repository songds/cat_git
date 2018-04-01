package com.cat.cat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.cat.po.CatBodyPo;
import com.cat.cat.service.CatBodyService;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 根据猫种类查询猫体型
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/cat")
public class GetByCatBodyApi {

	@Autowired
	private CatBodyService catBodyService;
	

	@RequestMapping(value="/getByCatBody.do",method=RequestMethod.POST)
	public ResponeInfo<List<CatBodyPo>> getByCatBody(@RequestBody String json){	
		log.info(" method is /api/cat/getByCatBody.do to customer input parameter message :  {}",json);
		ResponeInfo<List<CatBodyPo>> result=catBodyService.getByCatBody(json);
		log.info(" /api/cat/getByCatBody.do  to result message :  {}",result);
		return result;
	};
}
