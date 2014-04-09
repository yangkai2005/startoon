package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 发送信息的历史记录
 * 每发送一次生成一条记录
 * @author kai
 *
 */
@Entity
@Table(name = "b2b_msg_record")
public class MsgRecord implements Serializable {

	private static final long serialVersionUID = 8229516861421456240L;

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
	private Date ctime = new Date();

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
	private String receiverIds;

	/**
	 * 接收人名称
	 */
	private String receiverNames;

	/**
	 * 信息类型 0-普通消息 1-询盘信息 2-系统消息
	 */
	private Integer messageType;

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

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
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

	public String getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
	}

	public String getReceiverNames() {
		return receiverNames;
	}

	public void setReceiverNames(String receiverNames) {
		this.receiverNames = receiverNames;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MsgRecord [id=" + id + ", title=" + title + ", content=" + content + ", ctime=" + ctime + ", senderId=" + senderId + ", senderName=" + senderName + ", receiverIds=" + receiverIds + ", receiverNames=" + receiverNames + ", messageType=" + messageType + "]";
	}

}
