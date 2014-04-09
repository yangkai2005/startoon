package org.j2eeframework.information.web.actions.information.inc;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Link;
import org.j2eeframework.startoon.service.LinkService;

public class LinkAction extends ServiceBasePaginationAction<Link, Long> {

	private static final long serialVersionUID = 1608577649939234365L;

	private static final Log log = LogFactory.getLog(LinkAction.class);

	@Resource
	private LinkService linkService;

	@Override
	public IGenericService<Link, Long> getGenericService() {
		return linkService;
	}

	@Override
	public void preExecute() {
	}

	@Override
	public String execute() {
		log.debug("资讯平台友情链接");
		getPager().setPageSize(18);
		super.execute();
		return SUCCESS;
	}

}
