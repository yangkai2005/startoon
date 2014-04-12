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
@Table(name = "t_post")
public class Post implements Serializable {

	private static final long serialVersionUID = -265877592488273093L;

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
	 * 创建人ID
	 */
	private Long creatorId;

	/**
	 * 创建人姓名
	 */
	private String creatorName;

	/**
	 * 创建日期
	 */
	private Date createTime = new Date();

	/**
	 * 点击数
	 */
	private Integer hits = 0;

	/**
	 * 回复数
	 */
	private Integer replys = 0;
	
	/**
	 * 状态
	 * 0-未审核
	 * 1-不通过
	 * 2-通过
	 * 3-删除
	 */
	private Integer status = 0;
	
	/**
	 * 置顶贴
	 */
	private Boolean isTop = false;
	
	/**
	 * 热贴
	 */
	private Boolean isHot = false;
	
	/**
	 * 所属的类别
	 */
	@ManyToOne
	@JoinColumn(name="post_type_id")
	private PostType postType;
	

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

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getReplys() {
		return replys;
	}

	public void setReplys(Integer replys) {
		this.replys = replys;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}
}
