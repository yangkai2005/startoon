package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ISupplyImgDAO;
import org.j2eeframework.startoon.entity.SupplyImg;
import org.springframework.stereotype.Service;

@Service
public class SupplyImgService extends AbstractService<SupplyImg, Long, ISupplyImgDAO>
{
	@Resource
	private ISupplyImgDAO supplyImgDAO;

	@Override
	public ISupplyImgDAO getGenericDAO()
	{
		return supplyImgDAO;
	}
	
	public List<SupplyImg> getSupplyImgBySupplyId(Long supplyId) {
		return supplyImgDAO.getSupplyImgBySupplyId(supplyId);
	}
}
