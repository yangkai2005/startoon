package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Keyword implements Serializable {

	private static final long serialVersionUID = 2560136548498342508L;
	
	public static final Boolean IS_DELETED_UNDELETED = false;

	public static final Boolean IS_DELETED_DELETED = true;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * 关键字
	 */
	private String keyword;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 创建人
	 */
	@ManyToOne
	@JoinColumn(name="creator_id")
	private AdminUser creator;
	
	/**
	 * 修改人
	 */
	@ManyToOne
	@JoinColumn(name="modifier_id")
	private AdminUser modifier;
	
	/**
	 * 创建时间
	 */
	private Date createTime = new Date();
	
	/**
	 * 最后修改时间
	 */
	private Date modifyTime;
	
	/**
	 * 最低价
	 */
	private Float minPrice = 0F;
	
	/**
	 * 最高价
	 */
	private Float maxPrice = 0F;
	
	/**
	 * 递增价格
	 */
	private Float stepPrice = 0F;
	
	/**
	 * 当前价格
	 */
	private Float currentPrice = 0F;
	
	/**
	 * 到期日期
	 */
	private Date deadTime;
	
	/**
	 * 搜索次数
	 */
	private Integer searchTimes = 0;
	
	/**
	 * 是否删除
	 * 0-未删除
	 * 1-删除
	 */
	private Boolean isDeleted = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AdminUser getCreator() {
		return creator;
	}

	public void setCreator(AdminUser creator) {
		this.creator = creator;
	}

	public AdminUser getModifier() {
		return modifier;
	}

	public void setModifier(AdminUser modifier) {
		this.modifier = modifier;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Date getDeadTime() {
		return deadTime;
	}

	public void setDeadTime(Date deadTime) {
		this.deadTime = deadTime;
	}

	public Float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getSearchTimes() {
		return searchTimes;
	}

	public void setSearchTimes(Integer searchTimes) {
		this.searchTimes = searchTimes;
	}
	
	/**
	 * 判断关键字是否有效
	 * @return
	 */
	public boolean isValid() {
		Date dtime = getDeadTime();
		long millis = dtime.getTime();
		long currentMillis = System.currentTimeMillis();
		return currentMillis<millis;
	}
	
	public String getRemainTime() {

		String str = "<span class='red'>${day}</span> 天 <span class='red'>${hour}</span> 小时 <span class='red'>${min}</span> 分 <span class='red'>${second}</span> 秒";

		final long sMillis = 1000;
		final long mMillis = sMillis * 60;
		final long hMillis = mMillis * 60;
		final long dMillis = hMillis * 24;
		
		long millis = System.currentTimeMillis();
		
		long endMillis = getDeadTime().getTime();
		
		if(millis > endMillis) {
			str = "该关键字已经过期";
		}
		
		long remain = endMillis - millis;
		
		int d = (int) (remain/dMillis);
		int h = (int) ((remain - d * dMillis)/hMillis);
		int m = (int) ((remain - d * dMillis - h * hMillis) / mMillis);
		int s = (int) ((remain - d * dMillis - h * hMillis - m * mMillis ) / sMillis);
		
		str = str.replace("${day}", d + "")
				.replace("${hour}", h + "")
				.replace("${min}", m + "")
				.replace("${second}", s + "");
		
		
		return str;
		
	} 
	

}
