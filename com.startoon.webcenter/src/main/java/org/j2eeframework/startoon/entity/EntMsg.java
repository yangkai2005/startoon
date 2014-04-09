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

@Entity
@Table(name = "t_ent_msg")
public class EntMsg implements Serializable {

	private static final long serialVersionUID = -1780644245537360502L;
	public static final int STATUS_ALL = -1;
	public static final int STATUS_NEW = 0;
	public static final int STATUS_UNPASS = 1;
	public static final int STATUS_PASS = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "enterprse_id")
	private Enterprise enterprise;

	private Date ctime = new Date();

	private String creatorName;

	private String contact;

	private String email;

	private String area;

	private String content;

	/**
	 * 审核状态<br/>
	 * 0：新建<br/>
	 * 1：审核未通过<br/>
	 * 2：审核通过<br/>
	 */
	private Integer status = 0;

	public String getStatusZh(){
		String s = "";
		if(status==2){
			s="审核通过";
		}else if(status==1){
			s="审核不通过";
		}else if(status==0){
			s="<font color='red'>新建</font>";
		}
		return s;
	}
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

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	@Override
	public String toString() {
		return "EntMsg [area=" + area + ", contact=" + contact + ", content=" + content + ", creatorName=" + creatorName + ", ctime=" + ctime + ", email=" + email + ", id=" + id + ", status=" + status + "]";
	}
}
