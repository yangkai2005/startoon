package org.j2eeframework.information.web.actions.information.link;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Link;
import org.j2eeframework.startoon.service.LinkService;

public class LinkListAction extends ServiceBasePaginationAction<Link, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5492748870341721814L;

	private static final Log log = LogFactory.getLog(LinkListAction.class);

	@Resource
	private LinkService linkService;
	
	@Override
	public IGenericService<Link, Long> getGenericService()	{
		return linkService;
	}

	@Override
	public void preExecute() {
		Pager<Link> pager = getPager();
		
		pager.setPageSize(25);
		
		ParamCondition condition = pager.getParamCondition();
		condition.addParameter("linkTypeId", "3");
		
		log.debug("%%% 资讯平台友情链接 %%%");
	}
	
}
