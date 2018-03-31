package com.cat.user.po;

import java.util.Date;

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
@Table(name="SYS_USER_SESSION")
@EqualsAndHashCode(callSuper=false)
@Data
public class SysUserSessionPo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int objectId;
	
	@Column (name="USER_NO")
	private String userNo;
	
	@Column (name="DEVICE_ID")
	private String deviceId;
	
	@Column (name="LOGIN_TYPE")
	private String loginType;
	
	@Column (name="LOGIN_MODE")
	private String loginMode;
	
	@Column (name="TOKEN")
	private String token;
	
	@Column (name="EXPIRATION_TIME")
	private Date expirationTime;
	
	
}
