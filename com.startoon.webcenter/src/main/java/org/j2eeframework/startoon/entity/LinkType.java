package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LinkType implements Serializable {

	private static final long serialVersionUID = 1922837067859897719L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 排序编号 越小越靠前
	 */
	private Integer orderNo;

	/**
	 * 删除标志
	 * 0 未删除
	 * 1 删除
	 */
	private Integer isDeleted = 0;

	@ManyToOne
	@JoinColumn(name = "pid")
	private LinkType parent;

	/**
	 * 级别
	 */
	private Integer lvl;

	//--------- helper ----------//

	public String getDisplayName() {
		StringBuffer sb = new StringBuffer(100);
		for (int i = 0; i < lvl - 1; i++) {
			sb.append("....");
		}
		sb.append("┣");
		sb.append(getName());
		return sb.toString();
	}

	//--------- helper ----------//

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

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LinkType getParent() {
		return parent;
	}

	public void setParent(LinkType parent) {
		this.parent = parent;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkType other = (LinkType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LinkType [id=" + id + ", name=" + name + ", description=" + description + ", orderNo=" + orderNo + ", isDeleted=" + isDeleted + ", parent=" + parent + ", lvl=" + lvl + "]";
	}

}
