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
@Table(name="CAT_CHIP")
@EqualsAndHashCode(callSuper=false)
@Data
public class CatChipPo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int OBJECT_ID;
	
	@Column (name="SPECIES_ID")
	private String speciesId;
	
	@Column (name="CHIP_TYPE")
	private String chipType;
	
	@Column (name="CHIP_DESC")
	private String chipDesc;
	
	@Column (name="CHIP_IMG_URL")
	private String chipImgUrl;
	
	
}
