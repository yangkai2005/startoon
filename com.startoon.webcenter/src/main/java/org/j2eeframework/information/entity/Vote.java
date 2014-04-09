package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.j2eeframework.startoon.entity.AdminUser;

@Entity
@Table(name = "t_vote")
public class Vote implements Serializable {

	private static final long serialVersionUID = -588441048609617881L;
	
	public static final Integer STATUS_NEW = 0;
	public static final Integer STATUS_PUBLISH = 1;
	public static final Integer STATUS_OVERDUE = 2;
	public static final Integer STATUS_DELETED = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 调查标题
	 */
	private String title;
	
	/**
	 * 调查描述 
	 */
	private String description;
	
	/**
	 * 对应的主题
	 */
	@ManyToOne
	@JoinColumn(name = "info_id")
	private Info info;

	/**
	 * 创建人
	 */
	private AdminUser creator;

	/**
	 * 创建时间
	 */
	private Date createTime = new Date();
	
	/**
	 * 调查选项
	 */
	private String options;
	
	/**
	 * 状态
	 * 0-创建
	 * 1-发布
	 * 2-过期
	 * 3-删除
	 */
	private Integer status = 0;
	
	/**
	 * 关联的选项
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "vote")
	private List<VoteOption> voteOptions;
	
	@Transient
	private Integer totalVoteCount; 

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public AdminUser getCreator() {
		return creator;
	}

	public void setCreator(AdminUser creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<VoteOption> getVoteOptions() {
		return voteOptions;
	}

	public void setVoteOptions(List<VoteOption> voteOptions) {
		this.voteOptions = voteOptions;
	}

	public Integer getTotalVoteCount() {
		return totalVoteCount;
	}

	public void setTotalVoteCount(Integer totalVoteCount) {
		this.totalVoteCount = totalVoteCount;
	}
}
