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
@Table(name="QQ_LOGIN_INFO")
@EqualsAndHashCode(callSuper=false)
@Data
public class QqLoginInfoPo extends BasePo{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID") 
	private int objectId;
	
	@Column (name="USER_NO") 
	private String userNo;
	
	@Column (name="OPEN_ID") 
    private String openId;
	
	@Column (name="QQ_ID") 
    private String qqId;
	
	@Column (name="QQ_NAME") 
    private String qqName;
	
	@Column (name="QQ_IMAGE_URL") 
    private String qqImageUrl;
	
	@Column (name="UNION_ID") 
    private String unionId;
}
