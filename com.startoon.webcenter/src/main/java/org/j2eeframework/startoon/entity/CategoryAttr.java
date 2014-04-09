package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "category_attr")
public class CategoryAttr implements Serializable {

	private static final long serialVersionUID = 7436016612025230298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "attr_type_id")
	private AttrType attrType;

	private String attrName;

	private String attrValue;

	private String attrInput;

	private long ordernum;
	
	private boolean isDelete;

	@Transient
	private List<SupplyParam> supplyParams;

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

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public String getAttrInput() {
		return attrInput;
	}

	public void setAttrInput(String attrInput) {
		this.attrInput = attrInput;
	}

	public long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(long ordernum) {
		this.ordernum = ordernum;
	}

	public List<Map<String, String>> getOptions() {

		String input = getAttrInput();

		if (!"1".equals(input)) {
			return null;
		}

		String values = getAttrValue();
		String splitStr = ",";
		if (values.indexOf("，") > 0)
			splitStr = "，";

		if (values.indexOf(" ") > 0) {
			splitStr = " ";
		}
		if (values.indexOf("-") > 0) {
			splitStr = "-";
		}

		String[] vs = values.split(splitStr);

		List<Map<String, String>> options = new ArrayList<Map<String, String>>();
		for (String v : vs) {
			Map<String, String> option = new HashMap<String, String>();
			option.put("key", v);
			options.add(option);
		}

		return options;

	}

	public AttrType getAttrType() {
		return attrType;
	}

	public void setAttrType(AttrType attrType) {
		this.attrType = attrType;
	}

	public List<SupplyParam> getSupplyParams() {
		return supplyParams;
	}

	public void setSupplyParams(List<SupplyParam> supplyParams) {
		this.supplyParams = supplyParams;
	}

	@Override
	public String toString() {
		return "CategoryAttr [attrInput=" + attrInput + ", attrName="
				+ attrName + ", attrType=" + attrType + ", attrValue="
				+ attrValue + ", category=" + category + ", id=" + id
				+ ", ordernum=" + ordernum + ", supplyParams=" + supplyParams
				+ "]";
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

}
