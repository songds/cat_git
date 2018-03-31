package com.cat.common.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.common.dao.SysAreaSettingDao;
import com.cat.common.po.SysAreaSettingPo;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysAreaSettingService {

	@Autowired
	private SysAreaSettingDao sysAreaSettingDao;
	
	/**
	 * 查询一级地区列表
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<SysAreaSettingPo>> getRootArea(){
		try {
			List<SysAreaSettingPo> sysAreaSettings=sysAreaSettingDao.getRootArea();
			return ResponeInfo.ok(sysAreaSettings);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<SysAreaSettingPo>> info=new ResponeInfo<List<SysAreaSettingPo>>("F00001","查询一级地区列表信息异常，请您联系客服！",null);
			return info;
		}
	}
	
	/**
	 * 根据父级地区编号查询子级地区列表
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<SysAreaSettingPo>> getAreaByParentAreaCode(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("parentAreaCode"))){
					ResponeInfo<List<SysAreaSettingPo>> info=new ResponeInfo<List<SysAreaSettingPo>>("F00003","查询下级地区列表信息失败，参数父地区编号不能为空！",null);
					return info;
				}
				String parentAreaCode=parameter.getString("parentAreaCode");
				List<SysAreaSettingPo> sysAreaSettings=sysAreaSettingDao.getAreaByParentAreaCode(parentAreaCode);
				return ResponeInfo.ok(sysAreaSettings);
			}else{
				ResponeInfo<List<SysAreaSettingPo>> info=new ResponeInfo<List<SysAreaSettingPo>>("F00002","查询下级地区列表信息失败，参数不能为空！",null);
				return info;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<SysAreaSettingPo>> info=new ResponeInfo<List<SysAreaSettingPo>>("F00001","查询下级地区列表信息异常，请您联系客服！",null);
			return info;
		}
	}
}
