package com.cat.cat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.cat.dao.CatSpeciesDao;
import com.cat.cat.po.CatSpeciesPo;
import com.cat.common.util.ResponeInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CatSpeciesService {

	@Autowired
	private CatSpeciesDao catSpeciesDao;
	/**
	 * 查询所有猫种类
	 * @param json
	 * @return
	 */
	public ResponeInfo<List<CatSpeciesPo>> getSpeciesAll(){
		try {
			List<CatSpeciesPo> catSpeciess=catSpeciesDao.findAll();
			return ResponeInfo.ok(catSpeciess);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			ResponeInfo<List<CatSpeciesPo>> info=new ResponeInfo<List<CatSpeciesPo>>("F00001","查询猫种类异常，请您联系客服！",null);
			return info;
		}
	}
}
