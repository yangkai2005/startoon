package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "b2b_ptags")
public class PTags implements Serializable {

	private static final long serialVersionUID = -1623818787899557548L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 标签名称
	 */
	private String name;
	/**
	 * 是否通过
	 */
	private Boolean pass;

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

	public Boolean getPass() {
		return pass;
	}

	public void setPass(Boolean pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "PTags [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}

}
