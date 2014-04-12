package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class EnterpriseKeyword implements Serializable {

	private static final long serialVersionUID = 2680799221118803670L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 企业ID
	 */
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	/**
	 * 关键字
	 */
	@ManyToOne
	@JoinColumn(name = "keyword_id")
	private Keyword keyword;

	/**
	 * 排序
	 */
	private Integer orderNo = 99999;
	
	/**
	 * 关键字购买价格
	 */
	private Float price = 0F;

	/**
	 * 删除标志
	 */
	private Boolean isDeleted = false;

	/**
	 * 审核状态 0-未审核 1-不通过 2-通过
	 */
	private Integer status = 0;
	/**
	 * 关键字购买时间
	 */
	private Date ctime = new Date();

	/**
	 * 使用次数限制
	 */
	private Integer usedLimit = 0;
	
	/**
	 * 关键字的类别
	 * 0-点击关键字
	 * 1-类别关键字
	 */
	private int type;
	
	/**
	 * 类别关键字
	 */
	@ManyToOne
	@JoinColumn(name="category_keyword_id")
	private CategoryKeyword categoryKeyword;
	
	/**
	 * 是否绑定到企业
	 */
	private boolean isBindEnt = false;
	
	/**
	 * 是否绑定到产品
	 */
	private boolean isBindSupply = false;
	
	/**
	 * 绑定产品ID
	 */
	private Long supplyId;
	
	@Transient
	private Supply supply;
	
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

	public Keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Integer getUsedLimit() {
		return usedLimit;
	}

	public void setUsedLimit(Integer usedLimit) {
		this.usedLimit = usedLimit;
	}

	@Override
	public String toString() {
		return "EnterpriseKeyword [ctime=" + ctime + ", enterprise="
				+ enterprise + ", id=" + id + ", isDeleted=" + isDeleted
				+ ", keyword=" + keyword + ", orderNo=" + orderNo + ", price="
				+ price + ", status=" + status + ", usedLimit=" + usedLimit
				+ "]";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public CategoryKeyword getCategoryKeyword() {
		return categoryKeyword;
	}

	public void setCategoryKeyword(CategoryKeyword categoryKeyword) {
		this.categoryKeyword = categoryKeyword;
	}
	
	public boolean getCanBind() {
		return getUsedLimit()>0;
	}

	public boolean isBindEnt() {
		return isBindEnt;
	}

	public void setBindEnt(boolean isBindEnt) {
		this.isBindEnt = isBindEnt;
	}

	public boolean isBindSupply() {
		return isBindSupply;
	}

	public void setBindSupply(boolean isBindSupply) {
		this.isBindSupply = isBindSupply;
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}
}
