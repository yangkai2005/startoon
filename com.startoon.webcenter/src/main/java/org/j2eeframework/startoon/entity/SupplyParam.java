package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SupplyParam implements Serializable {

	private static final long serialVersionUID = 6217753553615124130L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "supply_id")
	private Supply supply;
	
	@ManyToOne
	@JoinColumn(name="category_attr_id")
	private CategoryAttr categoryAttr;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	private String pkey;

	private String pvalue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}

	public String getPkey() {
		return pkey;
	}

	public void setPkey(String pkey) {
		this.pkey = pkey;
	}

	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	@Override
	public String toString() {
		return "SupplyParam [id=" + id + ", pkey=" + pkey + ", pvalue="
				+ pvalue + ", supply=" + supply + "]";
	}

	public CategoryAttr getCategoryAttr() {
		return categoryAttr;
	}

	public void setCategoryAttr(CategoryAttr categoryAttr) {
		this.categoryAttr = categoryAttr;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
