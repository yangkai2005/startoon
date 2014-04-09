package org.j2eeframework.information.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_post_type")
public class PostType implements Serializable {

	private static final long serialVersionUID = -7660803482837471409L;

	public static final boolean IS_DELETED_YES = true;
	
	public static final boolean IS_DELETED_NO  = false; //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * 类别名称
	 */
	private String name;
	
	/**
	 * 是否删除
	 */
	private Boolean isDeleted = false;
	
	/**
	 * 描述 
	 */
	private String description;
	
	/**
	 * 排序编号
	 */
	private Integer orderNo = 99999;

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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
}
