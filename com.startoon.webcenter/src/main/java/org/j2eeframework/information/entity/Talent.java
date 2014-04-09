package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.j2eeframework.startoon.entity.Enterprise;

/**
 * 在线简历
 * @author kai
 *
 */
@Entity
@Table(name = "t_talent")
public class Talent implements Serializable {

	private static final long serialVersionUID = 3220657949586280838L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private Boolean sex;

	/**
	 * 出生日期
	 */
	private Date birthday;

	/**
	 * 婚姻 1-未婚 2-已婚 0-保密
	 */
	private Integer marriage;

	/**
	 * 政治面貌 1-中共党员（含预备党员） 2-团员 3-群众 4-民主党派 5-无党派人士 0-无可奉告
	 */
	private Integer politics;

	/**
	 * 户口所在地
	 */
	private String birthAddress;

	/**
	 * 现居地
	 */
	private String currentAddress;

	/**
	 * 联系方式
	 */
	private String contact;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 毕业院校
	 */
	private String graduateSchool;

	/**
	 * 专业
	 */
	private String speciality;

	/**
	 * 学位
	 */
	private String degree;

	/**
	 * 求职意向/职能
	 */
	private String jobIntent;

	/**
	 * 工作经历
	 */
	private String workExperience;

	/**
	 * 自我评价
	 */
	private String selfEvaluate;

	/**
	 * 企业ID
	 */
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	/**
	 * 创建人ID
	 */
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private Enterprise creator;

	/**
	 * 是否删除
	 */
	private Boolean isDeleted = false;

	/**
	 * 工作年限
	 */
	private String workedAge = "0";

	/**
	 * 注册时间
	 */
	private Date createTime = new Date();

	/**
	 * 更新时间
	 */
	private Date modifyTime = new Date();

	/**
	 * 状态
	 * 0：发布
	 * 1：冻结
	 */
	private Integer state = 0;

	/**
	 * 冻结原因描述
	 */
	private String freezeDesc;

	/**
	 * 应聘职位
	 */
	private String post;

	/**
	 * 头像
	 */
	private String avatar;

	//----------- helper start -----------//
	/**
	 * 获取求职意向列表
	 * @return
	 */
	public List<String> getIntent() {
		List<String> intents = null;
		if (jobIntent != null && jobIntent.contains(",")) {
			intents = new ArrayList<String>();
			String[] arr = jobIntent.split(",");
			for (String s : arr) {
				intents.add(s);
			}
		}

		return intents;
	}

	/**
	 * @return
	 */
	public String getPoliticsZh() {

		int p = getPolitics();
		String zh = null;
		switch (p) {
		case 1:
			zh = "中共党员（含预备党员）";
			break;

		case 2:
			zh = "团员";
			break;

		case 3:
			zh = "群众";
			break;

		case 4:
			zh = "民主党派";
			break;

		case 5:
			zh = "无党派人士";
			break;

		default:
			zh = "无可奉告";
			break;
		}

		return zh;
	}

	//----------- helper end -----------//

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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getMarriage() {
		return marriage;
	}

	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}

	public Integer getPolitics() {
		return politics;
	}

	public void setPolitics(Integer politics) {
		this.politics = politics;
	}

	public String getBirthAddress() {
		return birthAddress;
	}

	public void setBirthAddress(String birthAddress) {
		this.birthAddress = birthAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
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

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getWorkedAge() {
		return workedAge;
	}

	public void setWorkedAge(String workedAge) {
		this.workedAge = workedAge;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Enterprise getCreator() {
		return creator;
	}

	public void setCreator(Enterprise creator) {
		this.creator = creator;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getFreezeDesc() {
		return freezeDesc;
	}

	public void setFreezeDesc(String freezeDesc) {
		this.freezeDesc = freezeDesc;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
