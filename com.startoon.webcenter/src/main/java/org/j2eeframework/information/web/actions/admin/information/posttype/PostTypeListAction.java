package org.j2eeframework.information.web.actions.admin.information.posttype;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.PostType;
import org.j2eeframework.information.service.PostTypeService;


public class PostTypeListAction extends ServiceBasePaginationAction<PostType, Long> {

	private static final long serialVersionUID = 1524893984571916540L;

	@Resource
	private PostTypeService postTypeService;
	
	@Override
	public IGenericService<PostType, Long> getGenericService()	{
		return postTypeService;
	}

	@Override
	public void preExecute() {
		
	}

}
