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
@Table(name="CAT_BODY")
@EqualsAndHashCode(callSuper=false)
@Data
public class CatBodyPo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column (name="OBJECT_ID")
	private int objectId;
	
	@Column (name="SPECIES_ID")
	private String speciesId;
	
	@Column (name="BODY_TYPE")
	private String bodyType;
	
	@Column (name="BODY_DESC")
	private String bodyDesc;
}
