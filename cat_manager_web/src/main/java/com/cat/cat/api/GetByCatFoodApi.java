package com.cat.cat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.cat.po.CatFoodPo;
import com.cat.cat.service.CatFoodService;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 根据猫种类查询猫碎片
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/cat")
public class GetByCatFoodApi {

	@Autowired
	private CatFoodService catFoodService;

	@RequestMapping(value="/getByCatFood.do",method=RequestMethod.POST)
	public ResponeInfo<List<CatFoodPo>> getByCatFood(@RequestBody String json){	
		log.info(" method is /api/cat/getByCatFood.do to customer input parameter message :  {}",json);
		ResponeInfo<List<CatFoodPo>> result=catFoodService.getByCatFood(json);
		log.info(" /api/cat/getByCatFood.do  to result message :  {}",result);
		return result;
	};
	
	
	
}
