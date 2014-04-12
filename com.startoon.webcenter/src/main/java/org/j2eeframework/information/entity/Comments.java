package org.j2eeframework.information.entity;

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
@Table(name = "t_comments")
public class Comments implements Serializable {

	private static final long serialVersionUID = 1562672626784301996L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 新闻ID
	 */
	@ManyToOne
	@JoinColumn(name="info_id")
	private Info info;
	
	/**
	 * 创建人ID
	 */
	private Long creatorId;

	/**
	 * 创建人名称
	 */
	private String creatorName;

	/**
	 * 创建时间
	 */
	private Date createTime = new Date();

	/**
	 * 评论内容
	 */
	private String content;

	/**
	 * 评论纯文本
	 */
	private String contentTxt;

	/**
	 * 审核状态
	 * 0-未审核
	 * 1-不通过
	 * 2-审核通过
	 */
	private Integer status = 0;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
