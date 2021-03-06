package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeInfo implements Serializable {

	private static final long serialVersionUID = -9218113408584718618L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	private String name;
	private int sex;
	private Date bornDate;
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
	private int isDelete;
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
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
}
