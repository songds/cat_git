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
@Table(name="USER_CAT")
@EqualsAndHashCode(callSuper=false)
@Data
public class UserCatPo extends BasePo{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int OBJECT_ID;
	
	@Column (name="USER_NO")
	private String userNo;
	
	@Column (name="CAT_SPECIES_ID")
	private String catSpeciesId;
	
	@Column (name="DEFAULT_CAT_SEL")
	private String defaultCatSel;
	
}
