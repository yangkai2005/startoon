package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IBusinessDAO;
import org.j2eeframework.startoon.entity.Business;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Service;

@Service
public class BusinessService extends AbstractService<Business, Long, IBusinessDAO>
{
	@Resource
	private IBusinessDAO businessDAO;
	
	@Resource
	private CategoryService categoryService;
	
	@Override
	public IBusinessDAO getGenericDAO()
	{
		return businessDAO;
	}
	
	public boolean exist(Long enterpriseId, Long categoryId) {
		
		List<Business> list = businessDAO.findByLogicId(enterpriseId, categoryId);
		if(list!=null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public List<Business> addBusiness(Long enterpriseId, Long categoryId) {
		
		Category category = categoryService.getEntityById(categoryId);
		Category fatherCategory = category.getCategory();
		
		Enterprise enterprise = new Enterprise();
		enterprise.setId(enterpriseId);
		
		Business business = new Business();
		business.setEnterprise(enterprise);
		business.setCategory(fatherCategory);
		business.setType(0);
		
		if(!exist(enterpriseId, fatherCategory.getId())) {
			insert(business);
		}
		
		Business currentBusiness = new Business();
		currentBusiness.setCategory(category);
		currentBusiness.setEnterprise(enterprise);
		business.setType(1);
		
		if(!exist(enterpriseId, categoryId)) {
			insert(currentBusiness);
		}
		
		List<Business> list = new ArrayList<Business>();
		list.add(business);
		list.add(currentBusiness);
		
		return list;
		
	}
	
	public void removeBusiness(Long enterpriseId, Long categoryId) {
		Category currentCategory = categoryService.getEntityById(categoryId);
		Category fatherCategory = currentCategory.getCategory();
		
		businessDAO.removeByLogicId(enterpriseId, fatherCategory.getId());
		businessDAO.removeByLogicId(enterpriseId, currentCategory.getId());
		
	}
	
	public List<Business> getPrimaryBusiness(Long enterpriseId) {
		
		ParamCondition param = new ParamCondition();
		param.addParameter("enterpriseId", enterpriseId + "");
		param.addParameter("type", "0");
		List<Business> list = businessDAO.getEntitiesByParamCondition(param, 0, 1000);
		
		return list;		
	}
}
