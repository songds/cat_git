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
@Table(name="USER_ADDR_INFO")
@EqualsAndHashCode(callSuper=false)
@Data
public class UserAddrInfoPo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID") 
	private int objectId;
	
	@Column (name="USER_NO")
	private String userNo;
	
	@Column (name="PROVINCE")
	private String province;
	
	@Column (name="CITY")
	private String city;
	
	@Column (name="AREA")
	private String area;
	
	@Column (name="STREET")
	private String street;
	
	@Column (name="DETAILED_ADDRESS")
	private String detailedAddress;
	
	@Column (name="IS_DEFULT",columnDefinition="N")
	private String isDefult;
	
	@Column (name="ADDRESSEE")
	private String addressee;
	
	@Column (name="PHONE_NO")
	private String phoneNo;
	
	@Column (name="POST_CODE")
	private String postCode;
	
	
}
