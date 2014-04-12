package org.j2eeframework.information.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.j2eeframework.startoon.commons.SystemConfig;

@Entity
@Table(name = "t_copartnership")
public class Copartnership implements Serializable {

	private static final long serialVersionUID = 722818348772125889L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String siteUrl;

	private String normalLogoUrl;

	private String smallLogoUrl;

	/**
	 * 所在的位置
	 * 0-资讯中心首页
	 * 1-创意show首页
	 *
	 */
	private Integer position = 0;

	private Long infoTypeId;

	private Integer orderNo;

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

	public String getSiteUrl() {
		return siteUrl == null ? "#" : siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getNormalLogoUrl() {
		return normalLogoUrl;
	}

	public void setNormalLogoUrl(String normalLogoUrl) {
		this.normalLogoUrl = normalLogoUrl;
	}

	public String getSmallLogoUrl() {
		return smallLogoUrl;
	}

	public void setSmallLogoUrl(String smallLogoUrl) {
		this.smallLogoUrl = smallLogoUrl;
	}

	// ------------------ 实体的辅助方法 --------------------//

	/*
	 * 获取小图
	 */
	public String getSmallLogo() {
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + getSmallLogoUrl();
	}

	/*
	 * 获取大图
	 */
	public String getNormalLogo() {
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + getNormalLogoUrl();
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Long getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(Long infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
}
