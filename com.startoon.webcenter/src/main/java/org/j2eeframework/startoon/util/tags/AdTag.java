package org.j2eeframework.startoon.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.SystemContext;
import org.j2eeframework.information.entity.Advertisement;
import org.j2eeframework.information.service.AdvertisementService;

public class AdTag extends SimpleTagSupport {

	private static final Log log = LogFactory.getLog(AdTag.class);

	private String adId;

	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		AdvertisementService adSrv = (AdvertisementService) SystemContext.getApplicationContext().getBean("advertisementService");;
		Long id = new Long(adId);
		Advertisement ad = adSrv.getEntityById(id);
		String adUrl = null;
		if (ad != null) {
			adUrl = ad.getValidAdImg();
		} else {
			log.warn(">>>广告图片不存在[adId: " + adId + "]");
			return;
		}

		log.debug(">>>广告图片标签[Advertisement.Id=" + adId + ", Advertisement.normalImgUrl=" + adUrl + "]");

		out.write(adUrl);

	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

}