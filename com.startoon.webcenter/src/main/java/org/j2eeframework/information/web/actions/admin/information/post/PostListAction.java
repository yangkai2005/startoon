package org.j2eeframework.information.web.actions.admin.information.post;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Post;
import org.j2eeframework.information.service.PostService;


public class PostListAction extends ServiceBasePaginationAction<Post, Long> {

	private static final long serialVersionUID = 8746149853388169444L;

	@Resource
	private PostService postService;
	
	@Override
	public IGenericService<Post, Long> getGenericService()	{
		return postService;
	}

	@Override
	public void preExecute() {
		
	}

}
