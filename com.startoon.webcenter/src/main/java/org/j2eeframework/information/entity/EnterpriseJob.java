package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.j2eeframework.startoon.entity.Enterprise;

@Entity
public class EnterpriseJob implements Serializable {

	private static final long serialVersionUID = -2891987490003340853L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobId;
	//企业用户id
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;
	//企业名称
	private String enterpriseName;
	//职位名称
	private String jobName;
	//招聘人数
	private int jobNum;
	//工作地点
	private String workAddr;
	//工作年限
	private String workAge;
	//职位描述
	private String jobDescription;
	//任职条件
	private String jobCompetence;
	//待遇
	private String jobStipend;
	//学历
	private String certificate;
	
	//是否删除
	private int isDelete=0;
	// 企业介绍
	private String enterpriseDetail;
	
	// 职位发布日期
	
	private Date releaseDate=new Date();
	
	//置顶
	
	private int isTop;
	
	//推荐
	private int isCommend;
	
	
	
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getIsTop() {
		return isTop;
	}
	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}
	public int getIsCommend() {
		return isCommend;
	}
	public void setIsCommend(int isCommend) {
		this.isCommend = isCommend;
	}
	
	
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getJobNum() {
		return jobNum;
	}
	public void setJobNum(int jobNum) {
		this.jobNum = jobNum;
	}
	public String getWorkAddr() {
		return workAddr;
	}
	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}
	
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobCompetence() {
		return jobCompetence;
	}
	public void setJobCompetence(String jobCompetence) {
		this.jobCompetence = jobCompetence;
	}
	public String getJobStipend() {
		return jobStipend;
	}
	public void setJobStipend(String jobStipend) {
		this.jobStipend = jobStipend;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getEnterpriseDetail() {
		return enterpriseDetail;
	}
	public void setEnterpriseDetail(String enterpriseDetail) {
		this.enterpriseDetail = enterpriseDetail;
	}
	public void setWorkAge(String workAge) {
		this.workAge = workAge;
	}
	public String getWorkAge() {
		return workAge;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	
	
	
	
	
}
