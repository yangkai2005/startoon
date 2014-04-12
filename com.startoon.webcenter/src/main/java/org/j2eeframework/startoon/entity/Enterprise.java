package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.startoon.util.PinyinUtil;
import org.j2eeframework.startoon.util.StringUtil;

@Entity
public class Enterprise implements Serializable {

	private static final long serialVersionUID = 9016258465576955046L;

	/*
	 * 企业审核状态
	 */
	public static final Integer STATUS_UNAUDIT = 0; // 待审核
	public static final Integer STATUS_UNPASS = 1; // 审核不通过
	public static final Integer STATUS_ONLINE = 2; // 审核通过
	public static final Integer STATUS_DELETEED = 3; // 删除
	public static final Integer STATUS_LOCK = 4; // 冻结

	/*
	 * 用户类型
	 */
	public static final Integer USER_TYPE_PERSON = 0; // 个人
	public static final Integer USER_TYPE_ENTERPRISE = 1; // 企业

	public static final Integer MEMBER_LEVEL_0 = 0;
	public static final Integer MEMBER_LEVEL_1 = 1;
	public static final Integer MEMBER_LEVEL_2 = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 用户类型 0-个人会员 1-企业会员
	 */
	private Integer userType = 0;

	/**
	 * 帐号
	 */
	private String account;

	/**
	 * 性别 true:男 false:女
	 */
	private boolean sex;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 公司名称
	 */
	private String name;

	/**
	 * 公司网站
	 */
	private String siteUrl;

	/**
	 * 公司地址
	 */
	private String address;

	/**
	 * 经营模式
	 */
	private int manageType;

	/**
	 * 主营业务
	 */
	private String business;

	/**
	 * 主营业务ID字符串
	 */
	private String businessIds;

	/**
	 * 主营方向
	 */
	private int manageDirection;

	/**
	 * 联系人
	 */
	private String linkman;

	/**
	 * 联系人类别 0：先生 1 ： 女生
	 */
	private int linkmanSex;

	/**
	 * 移动电话
	 */
	private String mobilePhone;

	/**
	 * 固定电话
	 */
	private String telephone;

	/**
	 * 传真
	 */
	private String fax;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * QQ
	 */
	private String qq;

	/**
	 * msn
	 */
	private String msn;

	/**
	 * 公司规模
	 */
	private String scale;

	/**
	 * 公司成立时间
	 */
	private Date ctime;

	/**
	 * 公司类型
	 */
	private String type;

	/**
	 * 注册资金
	 */
	private int registeredCapital;

	/**
	 * 厂房面积
	 */
	private int acreage;

	/**
	 * 年营业额
	 */
	private int turnover;

	/**
	 * 年出口额
	 */
	private int outs;

	/**
	 * 年进口额
	 */
	private int ins;

	/**
	 * 经营品牌
	 */
	private String brand;

	/**
	 * 主客户群
	 */
	private String clients;

	/**
	 * 开户银行
	 */
	private String bank;

	/**
	 * 银行帐号
	 */
	private String bankAccount;

	/**
	 * 类别关键字
	 */
	private String categoryKeys;

	/**
	 * 类别ID字符串
	 */
	private String categoryIds;

	/**
	 * 企业所属行业
	 */
	private String industry;

	/**
	 * 企业的状态 0-待审核 1-审核不通过 2-审核通过 3-删除
	 */
	private Integer status = 0;

	/**
	 * 注册时间
	 */
	private Date createTime = new Date();

	/**
	 * 产品名称每个汉字的拼音第一个字母
	 */
	private String namePinyin;

	/**
	 * 产品的名称的第一个字母
	 */
	private String nameFirstPinyin;

	/**
	 * 订阅邮箱
	 */
	private String bookingEmail;

	/**
	 * 绑定的关键字
	 */
	private String keyword;

	/**
	 * 绑定关键字的价格
	 */
	private Integer keywordPrice;

	/**
	 * 购买的关键字的ID
	 */
	private Long enterpriseKeywordId;

	/**
	 * 账户金额
	 */
	private Float amount = 0F;

	/**
	 * 是否为创意show会员 0-非会员 1-申请会员 2-会员
	 */
	private Integer isShow = 0;

	/**
	 * 是否为店长吧会员 0-非会员 1-申请会员 2-会员
	 */
	private Integer isBar = 0;

	/**
	 * 公司性质 0-非动漫类 1-动漫类
	 */

	private boolean isCartoon = true;

	/**
	 * 企业关键字
	 */
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "enterprise")
	private List<EnterpriseRefKeyword> enterpriseRefKeyword;

	/**
	 * 点击率
	 */
	private Integer hit = 0;

	@Transient
	private EntInfo entInfo;

	/**
	 * 招聘限制
	 */
	@OneToOne(mappedBy = "enterprise")
	private HrLimit limit;

	/**
	 * 是否为免费会员
	 */
	private Boolean isFree = true;

	/**
	 * 会员级别
	 * 0：普通会员
	 * 1：初级会员
	 * 2：高级会员
	 */
	private Integer memberLevel = 0;

	/**
	 * 认证企业
	 */
	private Boolean auth = false;

	// ---------------- helper ---------------- //

	@Transient
	public String getManageTypeZh() {
		String s = "";
		switch (this.manageType) {
		case 0:
			s = "生产型";
			break;
		case 1:
			s = "贸易型";
			break;
		case 2:
			s = "代理型";
			break;
		case 3:
			s = "经销商";
			break;

		default:
			s = "生产型";
			break;
		}
		return s;
	}

	public String getStdSiteUrl() {
		String url = getSiteUrl();
		if (url != null && url.startsWith("http://")) {
			return url;
		}

		return "http://" + url;
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

	public String getNameByLen(int len) {
		return name != null && name.length() > len ? name.substring(0, len) : name;
	}

	public String getShortName() {
		return getNameByLen(15);
	}

	/**
	 * 判断在类别ID字符串当中是否包含指定类别ID
	 * 
	 * @param categoryId
	 * @return
	 */
	public boolean containsId(String categoryId) {

		categoryId = "#" + categoryId + "#";
		String ids = getCategoryIds();
		if (ids != null) {
			return ids.indexOf(categoryId) > 0;
		}

		return false;
	}

	/**
	 * 判断在类别关键字字符串当中是否包含指定类别关键字
	 * 
	 * @param categoryName
	 * @return
	 */
	public boolean containsKey(String categoryName) {

		categoryName = "#" + categoryName + "#";
		String keys = getCategoryKeys();
		if (keys != null) {
			return keys.indexOf(categoryName) > 0;
		}

		return false;
	}

	/**
	 * 添加类别ID，并自动判断
	 * 
	 * @param categoryId
	 */
	public void appendCategoryId(String categoryId) {
		if (!containsId(categoryId)) {
			String cid = "#" + categoryId + "#";
			String cids = getCategoryIds() + cid;
			setCategoryIds(cids);
		}
	}

	/**
	 * 添加类别关键字，并自动判断
	 * 
	 * @param categoryKey
	 */
	public void appendCategoryKey(String categoryKey) {
		if (!containsKey(categoryKey)) {
			String key = "#" + categoryKey + "#";
			String keys = getCategoryKeys() + key;
			setCategoryKeys(keys);
		}
	}

	/**
	 * 自动验证企业是否为空，并获取企业名称
	 * 
	 * @return
	 */
	public String getEnterpriseName() {
		String name = getName();
		if (name != null && name.trim().length() > 0) {

		} else {
			name = getAccount() + " ";
		}

		return name;
	}

	/**
	 * 获取#.##格式的账户余额
	 * 
	 * @return
	 */
	public String getFormatAmount() {
		Float am = getAmount();
		am = am == null ? 0F : am;
		DecimalFormat df = new DecimalFormat("0.00");// 保留两位小数
		String amount = df.format(am);
		return amount;
	}

	/**
	 * 获取联系人 自动根据性别进行判断
	 * 
	 * @return
	 */
	public String getContactor() {

		boolean sex = getSex();
		String linkman = getLinkman();
		String cw = linkman;
		String sir = "先生", miss = "小姐", miss1 = "女士";

		if (StringUtil.containString(linkman, sir) || StringUtil.containString(linkman, miss) || StringUtil.containString(linkman, miss1)) {
			cw = linkman;
		} else {
			if (sex) {
				cw += sir;
			} else {
				cw += miss;
			}
		}

		return cw;
	}

	// ---------------- getter and setter ---------------- //

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSex() {
		return sex;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getManageType() {
		return manageType;
	}

	public void setManageType(int manageType) {
		this.manageType = manageType;
	}

	public int getManageDirection() {
		return manageDirection;
	}

	public void setManageDirection(int manageDirection) {
		this.manageDirection = manageDirection;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(int registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	public int getOuts() {
		return outs;
	}

	public void setOuts(int outs) {
		this.outs = outs;
	}

	public int getIns() {
		return ins;
	}

	public void setIns(int ins) {
		this.ins = ins;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getClients() {
		return clients;
	}

	public void setClients(String clients) {
		this.clients = clients;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public int getLinkmanSex() {
		return linkmanSex;
	}

	public void setLinkmanSex(int linkmanSex) {
		this.linkmanSex = linkmanSex;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public String getCategoryKeys() {
		return categoryKeys;
	}

	public void setCategoryKeys(String categoryKeys) {
		this.categoryKeys = categoryKeys;
	}

	public String getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBookingEmail() {
		return bookingEmail;
	}

	public void setBookingEmail(String bookingEmail) {
		this.bookingEmail = bookingEmail;
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

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getBusinessIds() {
		return businessIds;
	}

	public void setBusinessIds(String businessIds) {
		this.businessIds = businessIds;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getIsBar() {
		return isBar;
	}

	public void setIsBar(Integer isBar) {
		this.isBar = isBar;
	}

	public boolean isCartoon() {
		return isCartoon;
	}

	public void setCartoon(boolean isCartoon) {
		this.isCartoon = isCartoon;
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

	public List<EnterpriseRefKeyword> getEnterpriseRefKeyword() {
		return enterpriseRefKeyword;
	}

	public void setEnterpriseRefKeyword(List<EnterpriseRefKeyword> enterpriseRefKeyword) {
		this.enterpriseRefKeyword = enterpriseRefKeyword;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public HrLimit getLimit() {
		return limit;
	}

	public void setLimit(HrLimit limit) {
		this.limit = limit;
	}

	public Boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}

	public Integer getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(Integer memberLevel) {
		this.memberLevel = memberLevel;
	}

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

}
