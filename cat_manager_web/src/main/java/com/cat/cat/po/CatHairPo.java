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
@Table(name="CAT_HAIR")
@EqualsAndHashCode(callSuper=false)
@Data
public class CatHairPo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int OBJECT_ID;
	
	@Column (name="SPECIES_ID")
	private String speciesId;
	
	@Column (name="HAIR_TYPE")
	private String hairType;
	
	@Column (name="HAIR_DESC")
	private String hairDesc;
}
