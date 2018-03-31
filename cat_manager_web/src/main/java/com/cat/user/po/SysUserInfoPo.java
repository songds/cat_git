package com.cat.user.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cat.common.po.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="SYS_USER_INFO")
@EqualsAndHashCode(callSuper=false)
@Data
public class SysUserInfoPo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID") 
	private int objectId;
	
	@Column (name="USER_NO") 
	private String userNo;
	
	@Column (name="SEX") 
	private String sex;
	
	@Column (name="PROVINCE") 
	private String province;
	
	@Column (name="CITY_OR_AREA") 
	private String cityOrArea;
	
	
	
	@Column (name="PHONE_NO") 
	private String phoneNo;
	
	
}
