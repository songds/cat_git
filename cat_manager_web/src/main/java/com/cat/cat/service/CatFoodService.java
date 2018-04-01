package com.cat.cat.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cat.cat.dao.CatFoodDao;
import com.cat.cat.po.CatFoodPo;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CatFoodService {

	@Autowired
	private CatFoodDao catFoodDao;
	
	/**
	 * 根据猫种类查询猫食物
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<CatFoodPo>> getByCatFood(String json){
		try {
			if(!StringUtils.isEmpty(json)){
				JSONObject parameter=JSONObject.parseObject(json);
				if(StringUtils.isEmpty(parameter.getString("speciesId"))){
					ResponeInfo<List<CatFoodPo>> info=new ResponeInfo<List<CatFoodPo>>("F00003","查询猫食物信息失败，参数猫种类编号不能为空！",null);
					return info;
				}
				String speciesId=parameter.getString("speciesId");
				List<CatFoodPo> catFoods=catFoodDao.getBySpeciesId(speciesId);
				return ResponeInfo.ok(catFoods);
			}else{
				ResponeInfo<List<CatFoodPo>> info=new ResponeInfo<List<CatFoodPo>>("F00002","查询猫食物信息失败，参数不能为空！",null);
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<CatFoodPo>> info=new ResponeInfo<List<CatFoodPo>>("F00001","查询猫食物信息异常，请您联系客服！",null);
			return info;
		}
	}
	
}
