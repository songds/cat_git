package com.cat.cat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.cat.po.CatSpeciesPo;
import com.cat.cat.service.CatSpeciesService;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;
/**
 * 查询所有猫种类
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/cat")
public class GetSpeciesAllApi {

	@Autowired
	private CatSpeciesService catSpeciesService;
	

	@RequestMapping(value="/getSpeciesAll.do",method=RequestMethod.POST)
	public ResponeInfo<List<CatSpeciesPo>> getSpeciesAll(){	
		log.info(" method is /api/cat/getSpeciesAll.do to customer input parameter message :  {}");
		ResponeInfo<List<CatSpeciesPo>> result=catSpeciesService.getSpeciesAll();
		log.info(" /api/cat/getSpeciesAll.do  to result message :  {}",result);
		return result;
	};
}
