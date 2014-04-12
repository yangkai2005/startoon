package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 7436016612025230298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "father_id")
	private Category category;

	private String name;
	
	private boolean isDelete = false;
	
	private String remark;
	
	private Integer orderNo = 9999; 
	
	private Integer categoryLevel;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "category")
	private List<CategoryAttr> categoryAttrs;

	@Transient
	private List<Supply> supplies;
	
	@Transient
	private List<Category> categories = new ArrayList<Category>();

	@Transient
	private List<Category> forthCategories = new ArrayList<Category>();
	
	@Transient
	private List<Enterprise> enterprises;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getForthCategories() {
		return forthCategories;
	}

	public void setForthCategories(List<Category> forthCategories) {
		this.forthCategories = forthCategories;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public List<CategoryAttr> getCategoryAttrs() {
		return categoryAttrs;
	}

	public void setCategoryAttrs(List<CategoryAttr> categoryAttrs) {
		this.categoryAttrs = categoryAttrs;
	}

	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

}
