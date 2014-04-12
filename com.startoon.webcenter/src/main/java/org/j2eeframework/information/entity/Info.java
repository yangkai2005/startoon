package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.j2eeframework.startoon.util.StringUtil;

@Entity
@Table(name = "t_info")
public class Info implements Serializable {

	private static final long serialVersionUID = -5778787871270460987L;

	public static final int STATUS_UNAUDIT = 0;
	public static final int STATUS_AUDIT_UNPASS = 1;
	public static final int STATUS_AUDIT_PASS = 2;

	public static final int CREATOR_TYPE_OTHER = 0;
	public static final int CREATOR_TYPE_PERSON = 1;
	public static final int CREATOR_TYPE_ENTERPRISE = 2;
	public static final int CREATOR_TYPE_ADMIN = 3;

	public static final Integer CATEGORY_TEXT = 0;
	public static final Integer CATEGORY_IMAGE = 1;
	public static final Integer CATEGORY_VIDEO = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 是否为图片新闻
	 */
	private Boolean isImgInfo = false;

	/**
	 * 资讯类别 0-文字 1-图片 2-视频
	 */
	private Integer category = 0;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 创建时间
	 */
	private Date createTime = new Date();

	/**
	 * 新闻时间
	 */
	private Date infoTime = new Date();

	/**
	 * 创建人ID
	 */
	private Long creator;

	/**
	 * 创建人
	 */
	private String creatorName;

	/**
	 * 创建人类型 0-其他 1-个人 2-企业 3-网站管理员
	 */
	private Integer creatorType;

	/**
	 * 点击数
	 */
	private Integer hits = 0;

	/**
	 * 来源
	 */
	private String source;

	/**
	 * 源网址
	 */
	private String sourceUrl;

	/**
	 * 评论数
	 */
	private Integer comments = 0;

	/**
	 * 是否热点
	 */
	private Boolean hot = false;

	/**
	 * 是否推荐
	 */
	private Boolean recommend = false;

	/**
	 * 是否置顶
	 */
	@Column(name = "top")
	private Boolean isTop = false;

	/**
	 * 类别
	 */
	@ManyToOne
	@JoinColumn(name = "info_type_id")
	private InfoType infoType;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 纯文本
	 */
	private String contentTxt;

	/**
	 * 审核状态 0-未审核 1-审核不通过 2-审核通过 6-人才服务新闻
	 * 
	 */
	private Integer status = 0;

	/**
	 * 所属类型 0-个人 1-团体
	 */
	private Integer ownerType = 0;

	@Transient
	private InfoImg mainImg;

	@Transient
	private List<InfoImg> infoImgs;

	@Transient
	private List<Vote> votes;

	/**
	 * 展会时间
	 */
	private Date eventTime;

	/**
	 * 展会城市
	 */
	private String eventCity;

	/**
	 * 专题
	 */
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	/**
	 * 关键词
	 */
	private String metaKeywords;
	/**
	 * 描述
	 */
	private String metaDescription;
	/**
	 * 标题
	 */
	private String metaTitle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public Boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentTxt() {
		return contentTxt;
	}

	public void setContentTxt(String contentTxt) {
		this.contentTxt = contentTxt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(Date infoTime) {
		this.infoTime = infoTime;
	}

	public Boolean getIsImgInfo() {
		return isImgInfo;
	}

	public void setIsImgInfo(Boolean isImgInfo) {
		this.isImgInfo = isImgInfo;
	}

	public InfoImg getMainImg() {
		return mainImg;
	}

	public void setMainImg(InfoImg mainImg) {
		this.mainImg = mainImg;
	}

	public List<InfoImg> getInfoImgs() {
		return infoImgs;
	}

	public void setInfoImgs(List<InfoImg> infoImgs) {
		this.infoImgs = infoImgs;
	}

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}

	public Integer getCreatorType() {
		return creatorType;
	}

	public void setCreatorType(Integer creatorType) {
		this.creatorType = creatorType;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	// ------------------ 实体的辅助方法 --------------------//

	public String getTitleByLength(int len) {
		if (title == null || len < 0) {
			return null;
		}

		return title.length() > len ? StringUtil.getStringByByteSize(title, len) + "..." : title;
	}

	public String getShortTitle() {
		return getTitleByLength(15);
	}

	public String getShortTitle10() {
		return getTitleByLength(10);
	}

	public String getShortTitle15() {
		return getTitleByLength(15);
	}

	public String getTitle100() {
		return getTitleByLength(100);
	}

	/**
	 * 获取指定长度的纯文本内容
	 * 
	 * @param len
	 * @return
	 */
	public String getContentTxtByLength(int len) {
		if (contentTxt == null || len < 0) {
			return null;
		}
		return contentTxt.length() > len ? contentTxt.substring(0, len) + "..." : contentTxt;
	}

	public String getContentTxt90() {
		return getContentTxtByLength(90);
	}

	public String getContentTxt175() {
		return getContentTxtByLength(175);
	}

	public String getContentTxt125() {
		return getContentTxtByLength(125);
	}

	// //////////////////////////
	// / 判断为是制定的类别，方便页面控制导航栏
	// /////////////////////////

	public int getTopInfoTypeId() {

		if (getInfoType().getId() > 12 && getInfoType().getId() < 19) {
			return 2;
		}

		return 0;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
}
