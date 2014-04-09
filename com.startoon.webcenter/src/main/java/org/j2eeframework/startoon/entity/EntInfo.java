package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.StringUtils;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.util.HtmlUtil;

@Entity
public class EntInfo implements Serializable {

	private static final long serialVersionUID = 3284220361984419655L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise enterprise;

	/**
	 * 公司首页
	 */
	private String indexContent;

	/**
	 * 首页图片
	 */
	private String indexImgUrl;

	/**
	 * 公司信息
	 */
	private String info;

	/**
	 * 公司信息图片
	 */
	private String infoImgUrl;

	/**
	 * 生产能力
	 */
	private String product;

	/**
	 * 研发能力
	 */
	private String develop;

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

	public String getIndexImgUrl() {
		return indexImgUrl;
	}

	public void setIndexImgUrl(String indexImgUrl) {
		this.indexImgUrl = indexImgUrl;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfoImgUrl() {
		return infoImgUrl;
	}

	public void setInfoImgUrl(String infoImgUrl) {
		this.infoImgUrl = infoImgUrl;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDevelop() {
		return develop;
	}

	public void setDevelop(String develop) {
		this.develop = develop;
	}

	public String getIndexContent() {
		return indexContent;
	}

	public void setIndexContent(String indexContent) {
		this.indexContent = indexContent;
	}

	/*-------------------
	 * 实体辅助方法
	 ********************/
	public String getShortInfo() {
		return getInfoTextByLen(105);
	}

	public String getShortIndexContent() {
		return getIndexContentTextByLen(105);
	}

	public String getBanner() {
		return getIndexImgUrl();
	}

	public String getInfoText() {
		String html = getInfo();
		if (StringUtils.isBlank(html)) {
			return "";
		}
		String text = HtmlUtil.Html2Text(html);
		return text;
	}

	public String getIndexContentText() {
		String html = getIndexContent();
		if (StringUtils.isBlank(html)) {
			return "";
		}
		String text = HtmlUtil.Html2Text(html);
		return text;
	}

	public String getInfoTextByLen(int length) {
		String info = getInfo();
		if (StringUtils.isBlank(info)) {
			return "";
		}
		return info.length() > length ? info.substring(0, length) : info;
	}

	public String getIndexContentTextByLen(int length) {
		String content = getIndexContentText();
		if (StringUtils.isBlank(content)) {
			return "";
		}
		return content.length() > length ? content.substring(0, length) : content;
	}

	public String getDefaultLogo() {
		return SystemConfig.CONTEXT_PATH + "/images/default_logo.jpg";
	}

	public String getLogo() {
		String logo = getInfoImgUrl();
		if (logo == null) {
			logo = getDefaultLogo();
		} else {
			logo = SystemConfig.CONTEXT_PATH + "/FileView?id=" + logo;
		}

		return logo;
	}

	@Override
	public String toString() {
		return "EntInfo [develop=" + develop + ", id=" + id + ", indexContent=" + indexContent + ", indexImgUrl=" + indexImgUrl + ", info=" + info + ", infoImgUrl=" + infoImgUrl + ", product=" + product + "]";
	}

}
