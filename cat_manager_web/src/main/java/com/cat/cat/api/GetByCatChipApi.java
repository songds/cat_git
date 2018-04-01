package com.cat.cat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.cat.po.CatChipPo;
import com.cat.cat.service.CatChipService;
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
public class GetByCatChipApi {

	@Autowired
	private CatChipService catChipService;

	@RequestMapping(value="/getByCatChip.do",method=RequestMethod.POST)
	public ResponeInfo<List<CatChipPo>> getByCatChip(@RequestBody String json){	
		log.info(" method is /api/cat/getByCatChip.do to customer input parameter message :  {}",json);
		ResponeInfo<List<CatChipPo>> result=catChipService.getByCatChip(json);
		log.info(" /api/cat/getByCatChip.do  to result message :  {}",result);
		return result;
	};
	
	
	
}
