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

@Entity
@Table(name = "t_enterprise_category_keyword")
public class EnterpriseCategoryKeyword implements Serializable {

	private static final long serialVersionUID = 7767020219040699102L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	@ManyToOne
	@JoinColumn(name = "category_keyword_id")
	private CategoryKeyword categoryKeyword;

	private Date stime = new Date();

	private Date etime;

	private float price = 0;

	private int useLimit = 1;

	private int orderNo = 9999;

	private int status = 0;
	
	private int amount;

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

	public CategoryKeyword getCategoryKeyword() {
		return categoryKeyword;
	}

	public void setCategoryKeyword(CategoryKeyword categoryKeyword) {
		this.categoryKeyword = categoryKeyword;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getUseLimit() {
		return useLimit;
	}

	public void setUseLimit(int useLimit) {
		this.useLimit = useLimit;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * 获取使用期限
	 * @return
	 */
	public int getUseTime() {
		
		if (etime != null && stime != null) {
			long eMillis = etime.getTime();
			long sMillis = stime.getTime();

			long diff = eMillis - sMillis;
			
			return (int) Math.round((diff / (30 * 24 * 60 * 60 * 1000 * 1.0)));
		}
		
		return 0;
		
	}
	
	/**
	 * 获取折扣
	 * @return
	 */
	public float getDiscount() {
		
		CategoryKeyword ck = getCategoryKeyword();
		
		int diff = getAmount();
		float discount = 1;
		switch (diff) {
		case 3:
			discount = ck.getDiscount3();
			break;
		case 6:
			discount = ck.getDiscount6();
			break;
		case 12:
			discount = ck.getDiscount12();
			break;

		default:
			discount = 1.0F;
			break;
		}
		
		return discount;
		
	}
	
	/**
	 * 计算总价格
	 * @return
	 */
	public float getTotalPrice() {
		
		int diff = getAmount();
		
		float discount = getDiscount();
		if(diff!=1) {
			return price * diff * discount * 0.1F;
		}
		
		return price;
		
	}

}
