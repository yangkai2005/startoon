package org.j2eeframework.information.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_info_type")
public class InfoType implements Serializable {

	private static final long serialVersionUID = -8102888011310776958L;
	
	public static final Long INFO_TYPE_INFO_CENTER = 2L; //资讯中心
	public static final Long INFO_TYPE_MARKET_RESEARCH = 3L; //市场调查
	public static final Long INFO_TYPE_HIGH_VISITATION = 4L; //高端访谈
	public static final Long INFO_TYPE_STOREFRONT = 5L; //店长吧
	public static final Long INFO_TYPE_OBSERVE = 6L; // 星力观察家
	public static final Long INFO_TYPE_ORIGINALITY_SHOW = 7L;
//	public static final Long INFO_TYPE_OBSERVE = 7L;
//	public static final Long INFO_TYPE_OBSERVE = 8L;
//	public static final Long INFO_TYPE_OBSERVE = 9L;
//	public static final Long INFO_TYPE_OBSERVE = 10L;
//	public static final Long INFO_TYPE_OBSERVE = 11L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 类别编号
	 */
	private String typeNo;

	/**
	 * 类别级别
	 */
	private Integer typeLevel;

	/**
	 * 删除标志
	 */
	private Boolean isDeleted = false;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 父ID
	 */
	@ManyToOne
	@JoinColumn(name = "father_id")
	private InfoType infoType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}

	public Integer getTypeLevel() {
		return typeLevel;
	}

	public void setTypeLevel(Integer typeLevel) {
		this.typeLevel = typeLevel;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
