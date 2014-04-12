package org.j2eeframework.information.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.Enterprise;

@Entity
@Table(name = "t_hr_enterprise")
public class HrEnterprise implements Serializable {

	private static final long serialVersionUID = 5947538668947613895L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String logo;

	private String slogo;

	private String site;

	private String name;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	/**
	 * 分类
	 * 0：人才服务-名企招聘
	 * 1：招聘主题-名企招聘
	 * 2：招聘主题-名校直通车
	 */
	private Integer type = 0;

	/**
	 * 
	 */
	private Integer orderNo = 0;

	// ------------------ 实体的辅助方法 --------------------//

	/*
	 * 获取小图
	 */
	public String getSmallLogo() {
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + getSlogo();
	}

	/*
	 * 获取大图
	 */
	public String getNormalLogo() {
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + getLogo();
	}

	// ------------------ getter and setter --------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getSlogo() {
		return slogo;
	}

	public void setSlogo(String slogo) {
		this.slogo = slogo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}
