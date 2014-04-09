package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.j2eeframework.startoon.entity.Enterprise;

/**
 * 查看简历和发布招聘统计表
 * 
 * @author kai
 */
@Entity
@Table(name = "t_hr_limit")
public class HrLimit implements Serializable {

	private static final long serialVersionUID = 1265963557171870839L;
	public static final Integer JOB_COUNT_0 = 5;
	public static final Integer JOB_COUNT_1 = 15;
	public static final Integer JOB_COUNT_2 = 99999;

	public static final Integer VIEW_COUNT_0 = 50;
	public static final Integer VIEW_COUNT_1 = 200;
	public static final Integer VIEW_COUNT_2 = 99999;

	public static final Integer MEMBER_LEVEL_0 = 0;
	public static final Integer MEMBER_LEVEL_1 = 1;
	public static final Integer MEMBER_LEVEL_2 = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 企业
	 */
	@OneToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	/**
	 * 会员级别
	 * 0：普通会员
	 * 1：初级会员
	 * 2：高级会员
	 */
	private Integer memberLevel = 0;

	/**
	 * 发布招聘数
	 */
	private Integer jobCount = 0;

	/**
	 * 职位发布最大值
	 */
	private Integer maxJobCount = 5;

	/**
	 * 查看简历数
	 */
	private Integer viewCount = 0;

	/**
	 * 简历查看最大值
	 */
	private Integer maxViewCount = 50;

	/**
	 * 创建时间
	 */
	private Date ctime = new Date();

	/**
	 * 成为会员时间
	 */
	private Date becomeMemberTime = new Date();

	/**
	 * 会员到期时间
	 */
	private Date memberDeadTime;

	/**
	 * 是否报名
	 */
	private Boolean isApply = false;

	/**
	 * 报名时间
	 */
	private Date applyTime = new Date();

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

	public Integer getJobCount() {
		return jobCount;
	}

	public void setJobCount(Integer jobCount) {
		this.jobCount = jobCount;
	}

	public Integer getMaxJobCount() {
		return maxJobCount;
	}

	public void setMaxJobCount(Integer maxJobCount) {
		this.maxJobCount = maxJobCount;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getMaxViewCount() {
		return maxViewCount;
	}

	public void setMaxViewCount(Integer maxViewCount) {
		this.maxViewCount = maxViewCount;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getBecomeMemberTime() {
		return becomeMemberTime;
	}

	public void setBecomeMemberTime(Date becomeMemberTime) {
		this.becomeMemberTime = becomeMemberTime;
	}

	public Date getMemberDeadTime() {
		return memberDeadTime;
	}

	public void setMemberDeadTime(Date memberDeadTime) {
		this.memberDeadTime = memberDeadTime;
	}

	public Boolean getIsApply() {
		return isApply;
	}

	public void setIsApply(Boolean isApply) {
		this.isApply = isApply;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(Integer memberLevel) {
		this.memberLevel = memberLevel;
	}

}
