package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TalentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long talentId;

	private String name;
	private int sex;
	
	private int bornYear;
	private int bornMonth;
	private int marriage;
	private int politics;
	private String home;
	private String nowAddr;
	private String affiliation;
	private String email;
	private String graduateSchool;
	private String speciality;
	private String degree;
	private String jobIntent;
	private String workExperience;
	private String selfEvaluate;
	private Long enterpriseId;
	private int isDelete=0;
	private String workAge="0";
	
	/**
	 * 注册时间
	 */
	private Date createTime = new Date();
	
	
	public Long getTalentId() {
		return talentId;
	}
	public void setTalentId(Long talentId) {
		this.talentId = talentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public int getBornYear() {
		return bornYear;
	}
	public void setBornYear(int bornYear) {
		this.bornYear = bornYear;
	}
	public int getBornMonth() {
		return bornMonth;
	}
	public void setBornMonth(int bornMonth) {
		this.bornMonth = bornMonth;
	}
	public int getMarriage() {
		return marriage;
	}
	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}
	public int getPolitics() {
		return politics;
	}
	public void setPolitics(int politics) {
		this.politics = politics;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getNowAddr() {
		return nowAddr;
	}
	public void setNowAddr(String nowAddr) {
		this.nowAddr = nowAddr;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getJobIntent() {
		return jobIntent;
	}
	public void setJobIntent(String jobIntent) {
		this.jobIntent = jobIntent;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getSelfEvaluate() {
		return selfEvaluate;
	}
	public void setSelfEvaluate(String selfEvaluate) {
		this.selfEvaluate = selfEvaluate;
	}
	public Long getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setWorkAge(String workAge) {
		this.workAge = workAge;
	}
	public String getWorkAge() {
		return workAge;
	}
}
