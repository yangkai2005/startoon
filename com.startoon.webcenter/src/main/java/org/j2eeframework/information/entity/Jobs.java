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

import org.j2eeframework.startoon.entity.Enterprise;

@Entity
@Table(name = "t_jobs")
public class Jobs implements Serializable {

	private static final long serialVersionUID = 4697853933656368193L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	/**
	 * 职位名称
	 */
	private String name;

	/**
	 * 招聘人数
	 */
	private Integer num;

	/**
	 * 工作性质 0-全职 1-兼职
	 */
	private Integer type = 0;

	/**
	 * 专业
	 */
	private String speciality;

	/**
	 * 工作地点
	 */
	private String workAddress;

	/**
	 * 工作年限
	 */
	private String workedAge;

	/**
	 * 截止日期
	 */
	private Date endTime = new Date();

	/**
	 * 职位描述
	 */
	private String description = "工作职责：\r\n\r\n职位要求：\r\n\r\n";

	/**
	 * 性别要求 0-不限 1-男 2-女
	 */
	private Integer sexLimit = 0;

	/**
	 * 年龄要求
	 */
	private String ageLimit;

	/**
	 * 学历
	 */
	private String certificate;

	/**
	 * 待遇
	 */
	private String salary;

	/**
	 * 是否删除
	 */
	private Boolean isDeleted = false;

	/**
	 * 职位发布日期
	 */
	private Date createTime = new Date();

	/**
	 * 置顶 0-未置顶 1-置顶
	 */
	private Integer isTop = 0;

	/**
	 * 推荐 0-未推荐 1-推荐
	 */
	private Integer isRecommend = 0;

	/**
	 * 状态
	 * 0：发布
	 * 1：冻结
	 */
	private Integer status = 0;

	/**
	 * 冻结原因描述
	 */
	private String freezeDesc;

	/**
	 * 公司名称（冗余）
	 */
	private String enterpriseName;

	/**
	 * 职能
	 */
	private String jobFun;

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkedAge() {
		return workedAge;
	}

	public void setWorkedAge(String workedAge) {
		this.workedAge = workedAge;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSexLimit() {
		return sexLimit;
	}

	public void setSexLimit(Integer sexLimit) {
		this.sexLimit = sexLimit;
	}

	public String getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getFreezeDesc() {
		return freezeDesc;
	}

	public void setFreezeDesc(String freezeDesc) {
		this.freezeDesc = freezeDesc;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getJobFun() {
		return jobFun;
	}

	public void setJobFun(String jobFun) {
		this.jobFun = jobFun;
	}

}
