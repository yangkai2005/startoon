package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class PostedPro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3939391811522226632L;

	public static enum Status {
		unaudit, unpass, pass, deleted
	}

	public static void main(String[] args) {
		System.out.println(Status.unaudit.ordinal());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String proName;//采购产品名称

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;//产品类别

	private int amount;//采购数量

	private int proPrice;//采购期望价格

	private Date startTime;//开始时间

	private Date endTime;//结束时间

	private String detailParameter;//详细参数

	private String tradeAddress;//交易地点

	private String description;//说明

	private Date createTime = new Date(); //创建时间

	private String categoryNameStr;

	private String categoryIdStr;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise creator;

	/**
	 * 审核状态
	 * 0-未审核
	 * 1-不通过
	 * 2-通过
	 * 3-删除
	 */
	private Integer status = 0;

	/**
	 * 采购图片
	 */
	private String imgUrl;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "postedPro")
	private List<PostedProParam> postedProParams;

	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDetailParameter() {
		return detailParameter;
	}

	public void setDetailParameter(String detailParameter) {
		this.detailParameter = detailParameter;
	}

	public String getTradeAddress() {
		return tradeAddress;
	}

	public void setTradeAddress(String tradeAddress) {
		this.tradeAddress = tradeAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Transient
	public String getSubDescription() {
		if (description != null && description.length() > 20) {
			return description.substring(0, 20) + "...";
		}
		return description;
	}

	public Enterprise getCreator() {
		return creator;
	}

	public void setCreator(Enterprise creator) {
		this.creator = creator;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<PostedProParam> getPostedProParams() {
		return postedProParams;
	}

	public void setPostedProParams(List<PostedProParam> postedProParams) {
		this.postedProParams = postedProParams;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatusZh() {
		String zh = null;
		switch (getStatus()) {
		case 0:
			zh = "未审核";
			break;
		case 1:
			zh = "不通过";
			break;
		case 2:
			zh = "已审核";
			break;

		}

		return zh;
	}

	public String getImageUrl() {
		if (getImgUrl() != null) {
			return "FileView?id=" + getImgUrl();
		} else {
			return "images/none.jpg";
		}
	}

	public String getCategoryNameStr() {
		return categoryNameStr;
	}

	public void setCategoryNameStr(String categoryNameStr) {
		this.categoryNameStr = categoryNameStr;
	}

	public String getCategoryIdStr() {
		return categoryIdStr;
	}

	public void setCategoryIdStr(String categoryIdStr) {
		this.categoryIdStr = categoryIdStr;
	}

	/**
	 * 获取详细信息简短描述
	 * @return
	 */
	public String getShortDesc() {
		String desc = getDescription();
		if (desc != null && desc.length() > 85) {
			return desc.substring(0, 85);
		}
		return getDescription();
	}

	/**
	 * 期望的采购价格
	 * @return
	 */
	public String getPrice() {
		int price = getProPrice();
		if (price == 0) {
			return "价格面议";
		} else {
			return price + "";
		}
	}
}
