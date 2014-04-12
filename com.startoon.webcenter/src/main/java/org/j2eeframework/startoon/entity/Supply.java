package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Calendar;
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

import org.j2eeframework.startoon.util.PinyinUtil;

@Entity
public class Supply implements Serializable {

	private static final long serialVersionUID = -8698536153466419006L;

	public static final Integer IS_DELETE_UNDELETED = 0;

	public static final Integer IS_DELETE_DELETED = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 产品类别
	 */
	private int type;

	/**
	 * 产品名称
	 */
	private String name;

	/**
	 * 价格
	 */
	private float proPrice = 0.0F;

	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 品牌
	 */
	private String brand;

	/**
	 * 产品原产地
	 */
	private String source;

	/**
	 * 产品类别
	 */
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	/**
	 * 有效期
	 */
	private int period;

	/**
	 * 详细说明
	 */
	private String description;

	/**
	 * 认证图片
	 */
	private String approveImgUrl;

	/**
	 * 生产企业
	 */
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise creator;

	/**
	 * 产品图片
	 */
	private String productImgUrl;
	private String imgUrl2;
	private String imgUrl3;

	/**
	 * 推荐产品 0 一般产品 1 推荐产品
	 */
	private Integer isRecommend = 0;

	/**
	 * 审核状态 0 - 未审核 1 - 不通过 2 - 通过
	 */
	private Integer status = 0;

	/**
	 * 删除标志
	 */
	private Integer isDelete = 0;

	/**
	 * 创建时间
	 */
	private Date createTime = new Date();

	/**
	 * 产品属性
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "supply")
	private List<SupplyParam> supplyParams;

	/**
	 * 属性字符串
	 */
	private String attrContent;

	/**
	 * 审核说明
	 */
	private String auditDesc;

	/**
	 * 产品名称每个汉字的拼音第一个字母
	 */
	private String namePinyin;

	/**
	 * 产品的名称的第一个字母
	 */
	private String nameFirstPinyin;

	/**
	 * 用户购买关键字的ID
	 */
	private Long enterpriseKeywordId;

	/**
	 * 绑定的关键字
	 */
	private String keyword;

	/**
	 * 关键字价格
	 */
	private Integer keywordPrice;

	/**
	 * 类别关键字ID
	 */
	private Long enterpriseCategoryKeywordId;

	/**
	 * 类别关键字标志 false - 不一致，类别关键字和类别ID不一致 true - 一 致，类别关键字和类别ID是一致
	 */
	private boolean isCategoryKeyword;

	/**
	 * 类别关键字的价格，用来排序的时候使用
	 */
	private Integer categoryKeywordPrice;

	/**
	 * 关键字状态 0-无效 1-有效
	 */
	private boolean keywordStatus;

	/**
	 * 类别关键字状态 0-无效 1-有效
	 */
	private boolean categoryKeywordStatus;

	/**
	 * 刷新时间
	 */
	private Date nuncetime;

	/**
	 * 商品点击率
	 */
	private Integer hit = 0;

	/**
	 * 审核标签
	 */
	@ManyToOne
	@JoinColumn(name = "ptag_id")
	private PTags ptags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApproveImgUrl() {
		return approveImgUrl;
	}

	public void setApproveImgUrl(String approveImgUrl) {
		this.approveImgUrl = approveImgUrl;
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

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

	public List<SupplyParam> getSupplyParams() {
		return supplyParams;
	}

	public void setSupplyParams(List<SupplyParam> supplyParams) {
		this.supplyParams = supplyParams;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getImgUrl2() {
		return imgUrl2;
	}

	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}

	public String getImgUrl3() {
		return imgUrl3;
	}

	public void setImgUrl3(String imgUrl3) {
		this.imgUrl3 = imgUrl3;
	}

	public String getSupplyImgUrl() {

		return null;

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取有效日期
	 * 
	 * @return
	 */
	public Date getDeadDate() {

		long millis = getCreateTime().getTime();

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);

		int p = getPeriod();

		if (p == 0) {
			calendar.add(Calendar.MONTH, 6);
		} else if (p == 1) {
			calendar.add(Calendar.YEAR, 1);
		} else if (p == 3) {
			calendar.add(Calendar.YEAR, 3);
		} else {
			return null;
		}

		return calendar.getTime();

	}

	/**
	 * 获取审核状态
	 * 
	 * @return
	 */
	public String getStatusZh() {
		int s = getStatus();
		String zh = null;
		if (s == 2) {
			zh = "在线";
		} else if (s == 1) {
			zh = "审核不通过";
		} else {
			zh = "待审核";
		}

		return zh;
	}

	public String getAttrContent() {
		return attrContent;
	}

	public void setAttrContent(String attrContent) {
		this.attrContent = attrContent;
	}

	/**
	 * 获取截断产品详细些信息
	 * 
	 * @return
	 */
	public String getShortDesc() {
		if (getDescription() != null && getDescription().length() > 85) {
			return getDescription().substring(0, 85);
		}
		return getDescription();
	}

	public String getPrice() {
		float price = getProPrice();
		if (price == 0) {
			return "价格面议";
		}
		return price + "";
	}

	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

	public String getNamePinyin() {
		return namePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getNameFirstPinyin() {
		return nameFirstPinyin;
	}

	public void setNameFirstPinyin(String nameFirstPinyin) {
		this.nameFirstPinyin = nameFirstPinyin;
	}

	/**
	 * 根据名称获取字母
	 * 
	 * @return
	 */
	public String getNamePinyinByName() {
		String name = getName();
		String pinyin = "";
		if (name != null && name.length() > 0) {
			pinyin = PinyinUtil.getChineseHeadPinyin(name);
		}

		return pinyin;
	}

	/**
	 * 根据名称获取第一个字母
	 * 
	 * @return
	 */
	public String getNameFirstPinyinByName() {
		String name = getName();
		return PinyinUtil.getChineseFirstHeadPinyin(name);
	}

	/**
	 * 获取指定长度的供应的名称
	 * 
	 * @param len
	 * @return
	 */
	public String getNameByLen(int len) {
		return name != null && name.length() > len ? name.substring(0, len) : name;
	}

	public String getShortName() {
		return getNameByLen(15);
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getEnterpriseKeywordId() {
		return enterpriseKeywordId;
	}

	public void setEnterpriseKeywordId(Long enterpriseKeywordId) {
		this.enterpriseKeywordId = enterpriseKeywordId;
	}

	public Integer getKeywordPrice() {
		return keywordPrice;
	}

	public void setKeywordPrice(Integer keywordPrice) {
		this.keywordPrice = keywordPrice;
	}

	public Long getEnterpriseCategoryKeywordId() {
		return enterpriseCategoryKeywordId;
	}

	public void setEnterpriseCategoryKeywordId(Long enterpriseCategoryKeywordId) {
		this.enterpriseCategoryKeywordId = enterpriseCategoryKeywordId;
	}

	public boolean isCategoryKeyword() {
		return isCategoryKeyword;
	}

	public void setCategoryKeyword(boolean isCategoryKeyword) {
		this.isCategoryKeyword = isCategoryKeyword;
	}

	public Integer getCategoryKeywordPrice() {
		return categoryKeywordPrice;
	}

	public void setCategoryKeywordPrice(Integer categoryKeywordPrice) {
		this.categoryKeywordPrice = categoryKeywordPrice;
	}

	public boolean isKeywordStatus() {
		return keywordStatus;
	}

	public void setKeywordStatus(boolean keywordStatus) {
		this.keywordStatus = keywordStatus;
	}

	public boolean isCategoryKeywordStatus() {
		return categoryKeywordStatus;
	}

	public void setCategoryKeywordStatus(boolean categoryKeywordStatus) {
		this.categoryKeywordStatus = categoryKeywordStatus;
	}

	public float getProPrice() {
		return proPrice;
	}

	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}

	public Date getNuncetime() {
		return nuncetime;
	}

	public void setNuncetime(Date nuncetime) {
		this.nuncetime = nuncetime;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public PTags getPtags() {
		return ptags;
	}

	public void setPtags(PTags ptags) {
		this.ptags = ptags;
	}

}
