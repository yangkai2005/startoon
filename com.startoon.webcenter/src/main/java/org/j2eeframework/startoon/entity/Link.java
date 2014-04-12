package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.j2eeframework.startoon.commons.SystemConfig;

@Entity
public class Link implements Serializable {

	private static final long serialVersionUID = -4015723787477015123L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "link_type_id")
	private LinkType linkType;

	private String name;

	private String url;

	private Integer orderNo = 0;

	private String normalLogoUrl;

	private String smallLogoUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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
		String slogo = getSmallLogoUrl();
		if (slogo == null) {
			slogo = SystemConfig.CONTEXT_PATH + "/information/images/links1.jpg";
		} else {
			slogo = SystemConfig.CONTEXT_PATH + "/FileView?id=" + getSmallLogoUrl();
		}
		return slogo;
	}

	/*
	 * 获取大图
	 */
	public String getNormalLogo() {
		String logo = getSmallLogoUrl();
		if (logo == null) {
			logo = SystemConfig.CONTEXT_PATH + "/information/images/links1.jpg";
		} else {
			logo = SystemConfig.CONTEXT_PATH + "/FileView?id=" + getNormalLogoUrl();
		}
		return logo;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", linkType=" + linkType + ", name=" + name + ", normalLogoUrl=" + normalLogoUrl + ", orderNo=" + orderNo + ", smallLogoUrl=" + smallLogoUrl + ", url=" + url + "]";
	}

}
