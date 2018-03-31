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
@Table(name="USER_ACCOUNT_MANAGER")
@EqualsAndHashCode(callSuper=false)
@Data
public class UserAccountManagerPo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int objectId;
	
	@Column (name="USER_NO")
	private String userNo;
	
	@Column (name="CAT_MONEY")
	private int catMoney;
	
	@Column (name="CAT_DNF")
	private int catDnf;
	
	@Column (name="CAT_DIAMOND")
	private int catDiamond;
	
	@Column (name="CAT_INTEGRAL")
	private int catIntegral;
	
	
}
