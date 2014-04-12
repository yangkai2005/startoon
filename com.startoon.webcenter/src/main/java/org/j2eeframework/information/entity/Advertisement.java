package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.j2eeframework.startoon.commons.SystemConfig;

@Entity
@Table(name = "t_advertisement")
public class Advertisement implements Serializable {

	private static final long serialVersionUID = -2330664970836157521L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 广告编号
	 */
	private String adNo;

	/**
	 * 位置
	 */
	private String position;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 价格
	 */
	private Integer price;

	/**
	 * 到期日期
	 */
	private Date deadTime;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 默认广告
	 */
	private String defaultAdImgUrl;

	/**
	 * 广告存放的地址url
	 */
	private String smallAdImgUrl;

	/**
	 * 广告存放的地址url
	 */
	private String normalAdImgUrl;

	/**
	 *  广告的链接地址
	 */
	private String linkUrl;

	/**
	 * 广告所属类别ID
	 */
	private Long infoTypeId;

	/**
	 * 广告所属类别页面的索引
	 */
	private Integer positionIndex;

	/**
	 * 点击数
	 */
	private Integer hits = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdNo() {
		return adNo;
	}

	public void setAdNo(String adNo) {
		this.adNo = adNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getDeadTime() {
		return deadTime;
	}

	public void setDeadTime(Date deadTime) {
		this.deadTime = deadTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefaultAdImgUrl() {
		return defaultAdImgUrl;
	}

	public void setDefaultAdImgUrl(String defaultAdImgUrl) {
		this.defaultAdImgUrl = defaultAdImgUrl;
	}

	public String getSmallAdImgUrl() {
		return smallAdImgUrl;
	}

	public void setSmallAdImgUrl(String smallAdImgUrl) {
		this.smallAdImgUrl = smallAdImgUrl;
	}

	public String getNormalAdImgUrl() {
		return normalAdImgUrl;
	}

	public void setNormalAdImgUrl(String normalAdImgUrl) {
		this.normalAdImgUrl = normalAdImgUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Long getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(Long infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public Integer getPositionIndex() {
		return positionIndex;
	}

	public void setPositionIndex(Integer positionIndex) {
		this.positionIndex = positionIndex;
	}

	public String getDefaultAdImg() {
		String url = getDefaultAdImgUrl();
		return SystemConfig.CONTEXT_PATH + url;
	}

	public String getSmallAdImg() {
		String url = getSmallAdImgUrl();
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + url;
	}

	public String getNormalAdImg() {
		String url = getNormalAdImgUrl();
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + url;
	}

	/**
	 * 获取有效广告图片 自动判断广告是否过期
	 * 
	 * @return
	 */
	public String getValidAdImg() {

		String ad = null;
		if (getNormalAdImgUrl() != null) {
			ad = getNormalAdImg();
		} else {
			ad = getDefaultAdImg();
		}

		return ad;

	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

}
