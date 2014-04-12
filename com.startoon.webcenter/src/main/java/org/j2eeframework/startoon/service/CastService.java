package org.j2eeframework.startoon.service;

import java.util.Date;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.dao.ICastDAO;
import org.j2eeframework.startoon.entity.Cast;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.CalendarUtil;
import org.springframework.stereotype.Service;

@Service
public class CastService extends AbstractService<Cast, Long, ICastDAO>
{
	@Resource
	private ICastDAO castDAO;

	@Override
	public ICastDAO getGenericDAO()
	{
		return castDAO;
	}
	
	public Double getCurrentUserTodayCast() {
		
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		Long enterpriseId = enterprise.getId();

		Date stime = CalendarUtil.getDayBegin();
		Date etime = CalendarUtil.getDateEnd();
		
		Double amount = getGenericDAO().cuputeCast(enterpriseId, stime, etime);
		amount = amount==null?0.0:amount;
		return amount;
		
	}
	
	public Double computeCast(Long enterpriseId, Date stime, Date etime) {
		return getGenericDAO().cuputeCast(enterpriseId, stime, etime);
	}
	
	@Override
	public void getEntitiesOfPagerByParamCondition(Pager<Cast> pager) {
		ParamCondition paramCondition = pager.getParamCondition();
		pager.setItems(getGenericDAO().getCastByParamCondition(paramCondition, pager.getFirstResult(), pager.getPageSize()));
		pager.setCountOfTotalItem(getGenericDAO().getCountOfCast(paramCondition));
		
	}
	
}
