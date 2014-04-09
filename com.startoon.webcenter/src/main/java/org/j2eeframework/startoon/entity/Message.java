package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_message")
public class Message implements Serializable {

	private static final long serialVersionUID = 6613057422617288176L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 创建时间
	 */
	private Date createTime = new Date();

	/**
	 * 发送人ID
	 */
	private Long senderId;

	/**
	 * 发送人姓名
	 */
	private String senderName;

	/**
	 * 接受者ID
	 */
	private Long receiverId;

	/**
	 * 状态 0-未读 1-已读
	 */
	private Integer status = 0;

	/**
	 * 信息类型 0-普通消息 1-询盘信息 2-系统消息
	 */
	private Integer messageType = 0;

	/**
	 * 接收人名称
	 */
	@Transient
	private String receiverName;

	@Transient
	private Enterprise receiver;

	public String getStatusZh() {
		String s = "";
		switch (status.intValue()) {
			case 0 :
				s = "未读";
				break;
			case 1 :
				s = "已读";
				break;
		}

		return s;
	}

	public String getMessageTypeZh() {
		String s = "";
		switch (messageType.intValue()) {
			case 0 :
				s = "普通信息";
				break;
			case 1 :
				s = "询盘信息";
				break;
			case 2 :
				s = "系统信息";
				break;
		}
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Enterprise getReceiver() {
		return receiver;
	}

	public void setReceiver(Enterprise receiver) {
		this.receiver = receiver;
	}
}
