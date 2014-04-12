package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IEntCategoryDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntCategory;
import org.springframework.stereotype.Service;

@Service
public class EntCategoryService extends AbstractService<EntCategory, Long, IEntCategoryDAO>
{
	@Resource
	private IEntCategoryDAO entCategoryDAO;
	
	@Resource
	private CategoryService categoryService;

	@Override
	public IEntCategoryDAO getGenericDAO()
	{
		return entCategoryDAO;
	}
	
	public List<Category> getOrderedCategory(Long enterpriseId) {
		Map<Long, Category> map = new HashMap<Long, Category>();
		int firstResult =0, pageSize = 1000;
		ParamCondition paramCondition = new ParamCondition();
		paramCondition.addParameter("enterpriseId", enterpriseId + "");
		List<EntCategory> ecs = entCategoryDAO.getEntitiesByParamCondition(paramCondition, firstResult, pageSize);
		for(EntCategory ec : ecs) {
			Category c = ec.getCategory();
			
			Category fatherCategory = categoryService.getTopCategory(c.getId());
			if(map.get(fatherCategory.getId())!=null) {
				fatherCategory = map.get(fatherCategory.getId());
				if(c.getId()!=0L && c.getId()!=fatherCategory.getId()) {
					fatherCategory.getCategories().add(c);
				}
				map.put(fatherCategory.getId(), fatherCategory);
			} else {
				if(c.getId()!=0L && c.getId()!=fatherCategory.getId()) {
					fatherCategory.getCategories().add(c);
				}
				map.put(fatherCategory.getId(), fatherCategory);
			}
		}
		List<Category> categories = new ArrayList<Category>();
		for(Long key : map.keySet()) {
			Category category = map.get(key);
			categories.add(category);
		}
		
		return categories;
	}
}
