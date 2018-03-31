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
@Table(name="SYS_USER_DEVICE")
@EqualsAndHashCode(callSuper=false)
@Data
public class SysUserDevicePo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID") 
	private int objectId;
	
	@Column (name="DEVICE_ID") 
	private String deviceId;
	
	@Column (name="DEVICE") 
	private String device;
	 
	@Column (name="USER_NO") 
	private String userNo;
	 
	@Column (name="CLIENT_V") 
	private String clientV;
	 
	@Column (name="APP_VERSION") 
	private String appVersion;
	 
	@Column (name="IP_ADDR") 
	private String ipAddr;
	 
	 
}
