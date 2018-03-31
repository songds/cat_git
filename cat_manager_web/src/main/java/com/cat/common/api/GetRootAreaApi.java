package com.cat.common.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cat.common.po.SysAreaSettingPo;
import com.cat.common.service.SysAreaSettingService;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 查询一级地区列表
 * @author ex-songdeshun
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/common")
public class GetRootAreaApi {
	
	@Autowired
	private SysAreaSettingService sysAreaSettingService;
	
	@RequestMapping(value="/getRootArea.do",method=RequestMethod.POST)
	public ResponeInfo<List<SysAreaSettingPo>> getRootArea(@RequestBody String json){
		log.info(" method is /api/common/getRootArea.do to customer input parameter message :  {}",json);
		ResponeInfo<List<SysAreaSettingPo>> result=sysAreaSettingService.getRootArea();
		log.info(" /api/common/getRootArea.do  to result message :  {}",result);
		return result;
	};
}
