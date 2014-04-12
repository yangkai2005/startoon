package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_clicked_keyword")
public class ClickedKeyword implements Serializable {

	private static final long serialVersionUID = -5037903304250419559L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String ip;

	private Long lip;

	private Date clickedTime = new Date();

	private String keyword;

	private Long keywordId;

	private Long enterpriseId;

	@ManyToOne
	@JoinColumn(name = "enterprise_keyword_id")
	private EnterpriseKeyword enterpriseKeyword;
	
	/**
	 * 关键字点击标志
	 * 0-产品
	 * 1-企业
	 */
	private Integer flag = 0;
	
	@Transient
	private Supply supply;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getLip() {
		return lip;
	}

	public void setLip(Long lip) {
		this.lip = lip;
	}

	public Date getClickedTime() {
		return clickedTime;
	}

	public void setClickedTime(Date clickedTime) {
		this.clickedTime = clickedTime;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public EnterpriseKeyword getEnterpriseKeyword() {
		return enterpriseKeyword;
	}

	public void setEnterpriseKeyword(EnterpriseKeyword enterpriseKeyword) {
		this.enterpriseKeyword = enterpriseKeyword;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
