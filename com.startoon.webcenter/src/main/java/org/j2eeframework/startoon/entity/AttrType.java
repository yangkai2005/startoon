package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AttrType implements Serializable {

	private static final long serialVersionUID = -5240702068238387143L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	private String description;
	
	@Transient
	private List<CategoryAttr> categoryAttrs;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CategoryAttr> getCategoryAttrs() {
		return categoryAttrs;
	}

	public void setCategoryAttrs(List<CategoryAttr> categoryAttrs) {
		this.categoryAttrs = categoryAttrs;
	}
}
