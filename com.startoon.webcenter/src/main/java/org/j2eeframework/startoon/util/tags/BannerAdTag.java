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

public class BannerAdTag extends SimpleTagSupport {

	private static final Log log = LogFactory.getLog(BannerAdTag.class);

	private String infoTypeId;

	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();

		Long id = new Long(infoTypeId);

		AdvertisementService adSrv = (AdvertisementService) SystemContext.getApplicationContext().getBean("advertisementService");
		Advertisement ad = adSrv.getAdByInfoType(id, 1);

		String html = "<a href='${url}'><img src='${src}' width='972' height='82'/></a>";

		if (ad != null) {
			String linkUrl = ad.getLinkUrl();
			String adUrl = ad.getValidAdImg();

			html = html.replace("${url}", linkUrl).replace("${src}", adUrl);

		} else {
			log.warn("广告不存在[infoTypeId: " + infoTypeId + "]");
			return;
		}

		log.debug(">>>Banner广告图片标签[infoTypeId: " + infoTypeId + " |html: " + html + "]");

		out.write(html);

	}

	public String getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(String infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

}