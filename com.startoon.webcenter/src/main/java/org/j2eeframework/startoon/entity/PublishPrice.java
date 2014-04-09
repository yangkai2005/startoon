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
public class PublishPrice implements Serializable {

	private static final long serialVersionUID = -6328738629489442827L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * 报价方
	 */
	@ManyToOne
	@JoinColumn(name="receiver_enterprise_id")
	private Enterprise receiver;
	
	/**
	 * 接受方
	 */
	@ManyToOne
	@JoinColumn(name="sender_enterprise_id")
	private Enterprise sender;
	
	/**
	 * 价格
	 */
	private Integer price;

	/**
	 * 起订量
	 */
	private Integer min;

	/**
	 * 付款方式
	 */
	private String payType;

	/**
	 * 运输方式
	 */
	private String transferType;

	/**
	 * 报价信息
	 */
	private String content;

	/**
	 * 创建时间
	 */	
	private Date createTime = new Date();

	/**
	 * 联系人
	 */
	private String linkman;

	/**
	 * 联系方式
	 */
	private String contact;

	/**
	 * 采购信息
	 */
	@ManyToOne
	@JoinColumn(name="posted_pro_id")
	private PostedPro postedPro;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Enterprise getReceiver() {
		return receiver;
	}

	public void setReceiver(Enterprise receiver) {
		this.receiver = receiver;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Enterprise getSender() {
		return sender;
	}

	public void setSender(Enterprise sender) {
		this.sender = sender;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}
}
