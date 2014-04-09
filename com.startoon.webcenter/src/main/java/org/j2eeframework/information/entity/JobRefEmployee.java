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
@Table(name = "t_job_ref_employee")
public class JobRefEmployee implements Serializable {

	private static final long serialVersionUID = 6598810807910246136L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 应聘职位
	 */
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Jobs jobs;

	/**
	 * 离线简历
	 */
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;

	/**
	 * 在线简历
	 */
	@ManyToOne
	@JoinColumn(name = "talent_id")
	private Talent talent;

	/**
	 * 招聘企业
	 */
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	private Date ctime = new Date();

	/**
	 * 类别 0-在线简历；1-word简历；
	 */
	private Integer type = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Talent getTalent() {
		return talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
}
