package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_enterprise_ref_keyword")
public class EnterpriseRefKeyword implements Serializable {

	private static final long serialVersionUID = 2661246492003410163L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	@ManyToOne
	@JoinColumn(name = "enterprise_keyword_id")
	private EnterpriseKeyword enterpriseKeyword;

	private String keyword;

	private Integer price;

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

	public EnterpriseKeyword getEnterpriseKeyword() {
		return enterpriseKeyword;
	}

	public void setEnterpriseKeyword(EnterpriseKeyword enterpriseKeyword) {
		this.enterpriseKeyword = enterpriseKeyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
