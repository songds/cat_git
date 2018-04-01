package com.cat.cat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.cat.po.CatSkinPo;
import com.cat.cat.service.CatSkinService;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 根据猫种类查询猫皮肤
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/cat")
public class GetByCatSkinApi {

	@Autowired
	private CatSkinService catSkinService;

	@RequestMapping(value="/getByCatSkin.do",method=RequestMethod.POST)
	public ResponeInfo<List<CatSkinPo>> getByCatSkin(@RequestBody String json){	
		log.info(" method is /api/cat/getByCatSkin.do to customer input parameter message :  {}",json);
		ResponeInfo<List<CatSkinPo>> result=catSkinService.getByCatSkin(json);
		log.info(" /api/cat/getByCatSkin.do  to result message :  {}",result);
		return result;
	};
	
	
}
