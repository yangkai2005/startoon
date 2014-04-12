package org.j2eeframework.startoon.web.actions.link;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Link;
import org.j2eeframework.startoon.service.LinkService;

public class LinkListAction extends ServiceBasePaginationAction<Link, Long> {

	private static final long serialVersionUID = 1359677591220903848L;
	
	private static final Log log = LogFactory.getLog(LinkListAction.class);

	@Resource
	private LinkService linkService;
	
	@Override
	public IGenericService<Link, Long> getGenericService()	{
		return linkService;
	}

	@Override
	public void preExecute() {
		getPager().setPageNo(1);
		getPager().setPageSize(100);
		log.debug("%%% 友情链接 %%%");
	}
	
}
