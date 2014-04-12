package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Helpclass implements Serializable {

	private static final long serialVersionUID = 1922837067859897719L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * 类别名称
	 */
	private String classname;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 排序编号 越小越靠前
	 */
	private Integer sortnum;
	
	private Long parentid;
//	@ManyToOne
//	@JoinColumn(name = "parentid")
//	private Helpclass helpclass;
	
	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

//	public Helpclass getHelpclass() {
//		return helpclass;
//	}
//
//	public void setHelpclass(Helpclass helpclass) {
//		this.helpclass = helpclass;
//	}

	public Long getId() {
		return id;
	}
	
	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
