package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IEntProduceDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntProduce;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Service;

@Service
public class EntProduceService extends AbstractService<EntProduce, Long, IEntProduceDAO>
{
	@Resource
	private IEntProduceDAO entProduceDAO;

	@Override
	public IEntProduceDAO getGenericDAO()
	{
		return entProduceDAO;
	}
	
	public EntProduce add(Long enterpriseId, Long categoryId) {
		
		EntProduce ep = entProduceDAO.getEntProduceByLogicKey(enterpriseId, categoryId);
		if(ep==null) {
			
			Category category = new Category();
			category.setId(categoryId);
			
			Enterprise enterprise = new Enterprise();
			enterprise.setId(enterpriseId);
			
			ep = new EntProduce();
			ep.setCategory(category);
			ep.setEnterprise(enterprise);
			entProduceDAO.insert(ep);
		}
		
		return ep;
	}
}
