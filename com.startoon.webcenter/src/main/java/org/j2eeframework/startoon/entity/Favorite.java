package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_favorite")
public class Favorite implements Serializable {

	private static final long serialVersionUID = 1851997051742242581L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="enterprise_id")
	private Enterprise enterprise;
	
	private Long entityId;
	
	/**
	 * 类型标志
	 * 0-产品
	 * 1-采购
	 * 2-企业
	 */
	private Integer type;
	
	private Date createTime = new Date();
	
	@Transient
	private Supply supply;
	
	@Transient
	private Enterprise ent;
	
	@Transient
	private PostedPro postedPro;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Enterprise getEnt() {
		return ent;
	}

	public void setEnt(Enterprise ent) {
		this.ent = ent;
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
