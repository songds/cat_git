package com.cat.cat.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.cat.dao.CatHairDao;
import com.cat.cat.po.CatHairPo;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CatHairService {

	@Autowired
	private CatHairDao catHairDao;
	
	/**
	 * 根据猫种类查询猫毛长
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<CatHairPo>> getByCatHair(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("speciesId"))){
					ResponeInfo<List<CatHairPo>> info=new ResponeInfo<List<CatHairPo>>("F00003","查询猫毛长信息失败，参数猫种类编号不能为空！",null);
					return info;
				}
				String speciesId=parameter.getString("speciesId");
				List<CatHairPo> catHairs=catHairDao.getBySpeciesId(speciesId);
				return ResponeInfo.ok(catHairs);
			}else{
				ResponeInfo<List<CatHairPo>> info=new ResponeInfo<List<CatHairPo>>("F00002","查询猫毛长信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<CatHairPo>> info=new ResponeInfo<List<CatHairPo>>("F00001","查询猫毛长信息异常，请您联系客服！",null);
			return info;
		}
	}
	
}
