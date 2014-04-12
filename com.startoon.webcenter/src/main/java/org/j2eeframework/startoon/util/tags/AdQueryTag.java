package org.j2eeframework.startoon.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.SystemContext;
import org.j2eeframework.information.entity.Advertisement;
import org.j2eeframework.information.service.AdvertisementService;
import org.j2eeframework.startoon.commons.SystemVariables;

public class AdQueryTag extends SimpleTagSupport {

	private static final Log log = LogFactory.getLog(AdQueryTag.class);

	private String id;

	private String adId;

	private String index;

	private String infoId;

	private String infoTypeId;

	@Override
	public void doTag() throws JspException, IOException {

		JspContext ctx = getJspContext();
		AdvertisementService adSrv = (AdvertisementService) SystemContext.getApplicationContext().getBean("advertisementService");;
		Advertisement ad = null;
		String link = null, img = null;

		if (!StringUtils.isBlank(adId)) {
			Long id = new Long(adId);
			ad = adSrv.getEntityById(id);
		}

		if (!StringUtils.isBlank(infoTypeId) && !StringUtils.isBlank(index)) {
			Long tid = new Long(infoTypeId);
			int i = new Integer(index);
			ad = adSrv.getAdByInfoType(tid, i);
		}

		if (ad != null) {
			link = ad.getLinkUrl();
			img = ad.getValidAdImg();
		} else {
			log.warn("广告不存在[ad.id: " + adId + ", infoTypeId: " + infoTypeId + "]");
			return;
		}

		log.debug(">>>广告查询标签[Advertisement.Id=" + ad.getId() + ", Advertisement.normalImgUrl=" + img + ", Advertisement.linkUrl: " + link + "]");

		ctx.setAttribute(SystemVariables.AD + id, ad);
		ctx.setAttribute(SystemVariables.AD_NAME + id, ad.getName());
		ctx.setAttribute(SystemVariables.AD_LINK + id, link);
		ctx.setAttribute(SystemVariables.AD_IMAGE + id, img);

	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(String infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}