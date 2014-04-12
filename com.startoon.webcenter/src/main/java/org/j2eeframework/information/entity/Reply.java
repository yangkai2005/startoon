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
@Table(name = "t_reply")
public class Reply implements Serializable {

	private static final long serialVersionUID = 826272649675241833L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 回复的主题
	 */
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	/**
	 * 回复内容
	 */
	private String content;
	
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
	 * 状态
	 * 0-未审核
	 * 1-不通过
	 * 2-通过
	 * 3-删除
	 */
	private Integer status = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
