package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ISupplyParamDAO;
import org.j2eeframework.startoon.entity.SupplyParam;
import org.springframework.stereotype.Service;

@Service
public class SupplyParamService extends AbstractService<SupplyParam, Long, ISupplyParamDAO>
{
	@Resource
	private ISupplyParamDAO supplyParamDAO;

	@Override
	public ISupplyParamDAO getGenericDAO()
	{
		return supplyParamDAO;
	}

	public List<SupplyParam> getSupplyParamBySupplyId(Long supplyId) {
		return supplyParamDAO.getSupplyParamBySupplyId(supplyId);
	}

	public void deleteBySupplyId(Long supplyId) {
		supplyParamDAO.deleteBySupplyId(supplyId);
	}

	public List<SupplyParam> getParamValuesByCategoryAttrId(Long categoryAttrId) {
		return supplyParamDAO.getSupplyParamByCategoryAttrId(categoryAttrId);
	}

	public List<SupplyParam> getSupplyParamByCategoryId(Long categoryId) {
		return supplyParamDAO.getSupplyParamByCategoryId(categoryId);
	}
	
	
	/**
	 * 根据自定义属性ID获取所有对应属性下的属性值
	 * @param categoryAttrId
	 * @return
	 */
	public List<SupplyParam> getDistinctSupplyParamValueByByCategoryAttrId(Long categoryAttrId) {
		List<SupplyParam> params = supplyParamDAO.getSupplyParamByCategoryAttrId(categoryAttrId);
		Set<String> set = new HashSet<String>();
		for(SupplyParam sp : params) {
			String pv = sp.getPvalue();
			set.add(pv);
		}
		
		List<SupplyParam> sps = new ArrayList<SupplyParam>();
		for(String pv : set) {
			SupplyParam sp = new SupplyParam();
			sp.setPvalue(pv);
			sps.add(sp);
		}
		
		return sps;
		
	}
/*	
	public List<SupplyParam> getDistinctSupplyParamByByCategoryAttrId(Long categoryAttrId) {
		List<SupplyParam> params = supplyParamDAO.getSupplyParamByCategoryAttrId(categoryAttrId);
		Map<String, List<SupplyParam>> filter = new HashMap<String, List<SupplyParam>>();
		for(SupplyParam sp : params) {
			String pv = sp.getPvalue();
			List<SupplyParam> list = filter.get(pv);
			if(list==null) {
				list =  new ArrayList<SupplyParam>();
				list.add(sp);
				filter.put(pv, list);
			} else {
				list.add(sp);
				filter.put(pv, list);
			}
		}
		
		
	}
*/	


/*	public List<SupplyParam> getDistinctSupplyParamByCategoryId(Long categoryId) {
		List<SupplyParam> params = supplyParamDAO.getSupplyParamByCategoryId(categoryId);
		Map<String, SupplyParam> filter = new HashMap<String, SupplyParam>();
		for(SupplyParam param : params) {
			pv = param.get
		}
		
	}*/
}
