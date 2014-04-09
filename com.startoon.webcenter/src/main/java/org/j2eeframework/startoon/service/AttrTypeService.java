package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IAttrTypeDAO;
import org.j2eeframework.startoon.dao.ICategoryAttrDAO;
import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.springframework.stereotype.Service;

@Service
public class AttrTypeService extends AbstractService<AttrType, Long, IAttrTypeDAO>
{
	@Resource
	private IAttrTypeDAO attrTypeDAO;
	@Resource
	private ICategoryAttrDAO categoryAttrDAO;

	@Override
	public IAttrTypeDAO getGenericDAO()
	{
		return attrTypeDAO;
	}
	
	public List<AttrType> getAttrType() {
		
		List<AttrType> attrs = getGenericDAO().getAllEntity();
		for(AttrType attr : attrs) {
			Long attrTypeId = attr.getId();
			ParamCondition condition = new ParamCondition();
			condition.addParameter("attrTypeId", attrTypeId + "");
			List<CategoryAttr> cas = categoryAttrDAO.getEntitiesByParamCondition(condition, 0, 5);
			attr.setCategoryAttrs(cas);			
		}
		
		return attrs;
	}
}
