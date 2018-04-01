package com.cat.cat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.cat.po.CatHairPo;
import com.cat.cat.service.CatHairService;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 根据猫种类查询猫毛长
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/cat")
public class GetByCatHairApi {

	@Autowired
	private CatHairService catHairService;

	@RequestMapping(value="/getByCatHair.do",method=RequestMethod.POST)
	public ResponeInfo<List<CatHairPo>> getByCatHair(@RequestBody String json){	
		log.info(" method is /api/cat/getByCatHair.do to customer input parameter message :  {}",json);
		ResponeInfo<List<CatHairPo>> result=catHairService.getByCatHair(json);
		log.info(" /api/cat/getByCatHair.do  to result message :  {}",result);
		return result;
	};
	
	
}
