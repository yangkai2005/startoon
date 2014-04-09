package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ICategoryAttrDAO;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.entity.SupplyParam;
import org.springframework.stereotype.Service;

@Service
public class CategoryAttrService extends AbstractService<CategoryAttr, Long, ICategoryAttrDAO> {
	@Resource
	private ICategoryAttrDAO categoryAttrDAO;
	@Resource
	private SupplyParamService supplyParamService;

	@Override
	public ICategoryAttrDAO getGenericDAO() {
		return categoryAttrDAO;
	}

	public List<CategoryAttr> getCategoryAttrsByCategoryId(long categoryId) {
		return categoryAttrDAO.getCategoryAttrByCategoryId(categoryId);
	}
	
	
	public List<CategoryAttr> getCategoryAttrByCategory(long categoryId) {
		List<CategoryAttr> attrs = categoryAttrDAO.getCategoryAttrByCategoryId(categoryId);
		
		if(attrs!=null) {
			
			for(CategoryAttr attr: attrs) {
				
				Long categoryAttrId = attr.getId();
//				List<SupplyParam> params =  supplyParamService.getParamValuesByCategoryAttrId(categoryAttrId);
				List<SupplyParam> params =  supplyParamService.getDistinctSupplyParamValueByByCategoryAttrId(categoryAttrId);
				attr.setSupplyParams(params);
				
			}
		}
		
		return attrs;
	}
	
	/***
	 * 判断自定义的分类属性是否已被引用
	 * 返回true表示已被引用，false 表示未被引用
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isExistsSupply(Long id){
		boolean flag = false;
		
		List list = categoryAttrDAO.executeQuery("select count(*) as total from supply_param where category_attr_id = " + id);
		if(list != null && !list.isEmpty()){
			
			if(Integer.parseInt(list.get(0).toString())>0){
				flag = true;
			}
		}
		
		return flag;
	}
}
