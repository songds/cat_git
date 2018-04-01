package com.cat.cat.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="CAT_SKIN")
@EqualsAndHashCode(callSuper=false)
@Data
public class CatSkinPo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int OBJECT_ID;
	
	@Column (name="SPECIES_ID")
	private String speciesId;
	
	@Column (name="SKIN_TYPE")
	private String skinType;
	
	@Column (name="SKIN_DESC")
	private String skinDesc;
	
	@Column (name="SKIN_BROWSE_URL")
	private String skinBrowseUrl;
	
	
}
