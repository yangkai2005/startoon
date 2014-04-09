package org.j2eeframework.startoon.web.actions;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.SupplyService;

public class SupplyListAction extends ServiceBasePaginationAction<Supply, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -692249263230606009L;

	private static final Log log = LogFactory.getLog(SupplyListAction.class);

	@Resource
	private SupplyService supplyService;

	@Override
	public IGenericService<Supply, Long> getGenericService() {
		return supplyService;
	}

	@Override
	public void preExecute() {
		log.debug("按产品字母分类查询产品");
		getPager().setPageSize(80);

		if (getPager().getParamCondition().isParameterNull("pinyin"))
			getPager().getParamCondition().addParameter("pinyin", "A");
	}

}
