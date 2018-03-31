package com.cat.common.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="SYS_AREA_SETTING")
@EqualsAndHashCode(callSuper=false)
@Data
public class SysAreaSettingPo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID") 
	private int bjectId;
	
	@Column (name="AREA_CODE")
	private String areaCode;
	
	@Column (name="AREA_DESC")
	private String areaDesc;
	
	@Column (name="AREA_LEVEL")
	private int areaLevel;
	
	@Column (name="PARENT_AREA_CODE")
	private String parentAreaCode;
	
}
