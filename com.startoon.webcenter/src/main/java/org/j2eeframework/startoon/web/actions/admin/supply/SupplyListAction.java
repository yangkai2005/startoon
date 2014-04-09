package org.j2eeframework.startoon.web.actions.admin.supply;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.PTags;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.PTagsService;
import org.j2eeframework.startoon.service.SupplyService;

public class SupplyListAction extends ServiceBasePaginationAction<Supply, Long> {

	private static final long serialVersionUID = 9158047681182051514L;

	@Resource
	private SupplyService supplyService;
	@Resource
	private PTagsService pTagsService;

	List<PTags> tags;

	@Override
	public IGenericService<Supply, Long> getGenericService() {
		return supplyService;
	}

	@Override
	public void preExecute() {
		ParamCondition cond = getPager().getParamCondition();
		getPager().setPageSize(15);
		String s = cond.getParameter("status");
		if (s == null) {
			cond.addParameter("status", "0");
		}

		cond.addParameter("admin", "true");

		tags = pTagsService.getAllEntity();

	}

	public List<PTags> getTags() {
		return tags;
	}

	public void setTags(List<PTags> tags) {
		this.tags = tags;
	}

}
