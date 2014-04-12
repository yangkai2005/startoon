package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IAdvertisementDAO;
import org.j2eeframework.information.entity.Advertisement;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService extends AbstractService<Advertisement, Long, IAdvertisementDAO> {
	@Resource
	private IAdvertisementDAO advertisementDAO;

	@Override
	public IAdvertisementDAO getGenericDAO() {
		return advertisementDAO;
	}
	
	public Advertisement getAdByInfoType(Long infoTypeId, int index) {
		Pager<Advertisement> pager = new Pager<Advertisement>();
		pager.getParamCondition().addParameter("infoTypeId", infoTypeId + "");
		pager.getParamCondition().addParameter("positionIndex", index + "");
		
		getEntitiesOfPagerByParamCondition(pager);
		
		List<Advertisement> ads = pager.getItems();
		
		if(ads!=null && !ads.isEmpty()) {
			return ads.get(0);
		}
		
		return null;
		
	}

}
