package org.j2eeframework.information.web.actions.information.post;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.Post;
import org.j2eeframework.information.service.PostService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class PostAction extends ServiceBaseManageAction<Post,Long>
{
	private static final long serialVersionUID = -2031707963385606368L;
	@Resource
	private PostService postService;
	private Post post;
	@Override
	public IGenericService<Post, Long> getGenericService()
	{
		return postService;
	}

	public Post getModel()
	{
		return post;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			post = new Post();
		} else
		{
			post = postService.getEntityById(getRequestId());
		}
	}

}
