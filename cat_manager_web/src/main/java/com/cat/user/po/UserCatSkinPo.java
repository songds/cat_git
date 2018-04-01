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
@Table(name="USER_CAT_SKIN")
@EqualsAndHashCode(callSuper=false)
@Data
public class UserCatSkinPo extends BasePo{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int objectId;
	
	@Column (name="USER_NO")
	private String userNo;
	
	@Column (name="CAT_SPECIES_ID")
	private String catSpeciesId;
	
	@Column (name="CAT_SKIN_TYPE")
	private String catSkinType;
	
	@Column (name="DEFAULT_SKIN_SEL")
	private String defaultSkinSel;
	
	
}
