package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AskPrice implements Serializable {

	private static final long serialVersionUID = -7931129440057165651L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="enterprise_id")
	private Enterprise enterprise;
	
	/**
	 * 订货总量
	 */
	private Integer total;
	
	/**
	 * 订货价格
	 */
	private Integer price;
	
	/**
	 * 联系电话
	 */
	private String contact;

	/**
	 * 联系人
	 */
	private String linkman;
	
	/**
	 * 联系人的性别 
	 */
	private Boolean sex;

	/**
	 * 联系人的邮箱
	 */
	private String email;

	/**
	 * 是否为注册会员
	 */
	private Integer isVip;

	/**
	 * 创建时间
	 */
	private Date createTime = new Date();
	
	/**
	 * 询价的内容
	 */
	private String content;
	
	/**
	 * 询价状态
	 * 0-未读
	 * 1-已读
	 */
	private Integer status = 0;
	
	/**
	 * 分类
	 * 0 产品询价
	 * 1-采购留言 
	 */
	private Integer type = 0;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
