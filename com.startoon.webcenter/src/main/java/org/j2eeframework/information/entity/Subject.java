package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = -6474160066266598831L;

	public static final Integer STATUS_NEW = 0;
	public static final Integer STATUS_ONLINE = 1;
	public static final Integer STATUS_OFFLINE = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Date ctime = new Date();

	/**
	 * 状态<br>
	 * 0-新建<br>
	 * 1-上线<br>
	 * 2-下线<br>
	 */
	private Integer status = 0;

	/**
	 * 排序
	 */
	private Integer orderNo = 0;

	private String content;

	private String contentTxt;

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

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentTxt() {
		return contentTxt;
	}

	public void setContentTxt(String contentTxt) {
		this.contentTxt = contentTxt;
	}
}
