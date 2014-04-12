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
@Table(name = "t_category_keyword")
public class CategoryKeyword implements Serializable {

	private static final long serialVersionUID = 5712248559467612016L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	/**
	 * 到期日期
	 */
	private Date etime;

	private Integer limitTimes = 0;

	private Float minPrice = 0F;

	private Float maxPrice = 0F;

	private Float stepPrice = 0F;

	private float currentMaxPrice = 0F;

	private float discount3 = 0F;
	
	private float discount6 = 0F;
	
	private float discount12 = 0F;
	
	private Integer rank;
	
	/**
	 * 关键词状态
	 * 0-初始化
	 * 1-发布状态
	 * 2-已购买
	 */
	private Integer status;
	
	/**
	 * 类别关键词名称
	 */
	private String categoryName;
	
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

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public Integer getLimitTimes() {
		return limitTimes;
	}

	public void setLimitTimes(Integer limitTimes) {
		this.limitTimes = limitTimes;
	}

	public Float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}

	public Float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Float getStepPrice() {
		return stepPrice;
	}

	public void setStepPrice(Float stepPrice) {
		this.stepPrice = stepPrice;
	}

	public float getCurrentMaxPrice() {
		return currentMaxPrice;
	}

	public void setCurrentMaxPrice(float currentMaxPrice) {
		this.currentMaxPrice = currentMaxPrice;
	}

	public float getDiscount3() {
		return discount3;
	}

	public void setDiscount3(float discount3) {
		this.discount3 = discount3;
	}

	public float getDiscount6() {
		return discount6;
	}

	public void setDiscount6(float discount6) {
		this.discount6 = discount6;
	}

	public float getDiscount12() {
		return discount12;
	}

	public void setDiscount12(float discount12) {
		this.discount12 = discount12;
	}

	/**
	 * 判断关键字是否有效
	 * @return
	 */
	public boolean isValid() {
		Date dtime = getEtime();
		long millis = dtime.getTime();
		long currentMillis = System.currentTimeMillis();
		return currentMillis<millis;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
