package org.j2eeframework.information.web.actions.information.advertisement;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.information.entity.Advertisement;
import org.j2eeframework.information.service.AdvertisementService;

import com.opensymphony.xwork2.ActionSupport;

public class ClickAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2649974043235949467L;

	private static final Log log = LogFactory.getLog(ClickAction.class);

	@Resource
	private AdvertisementService advertisementService;

	private Long id;

	public String execute() {
		Advertisement ad = advertisementService.getEntityById(id);
		if (ad != null) {
			int hits = ad.getHits();
			hits += 1;
			ad.setHits(hits);
			advertisementService.update(ad);

			log.debug("广告点击量增加[id:" + id + ", hits: " + (hits - 1) + " --> " + hits + "]");
		} else {
			log.info("广告不存在:" + id);
		}
		
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
