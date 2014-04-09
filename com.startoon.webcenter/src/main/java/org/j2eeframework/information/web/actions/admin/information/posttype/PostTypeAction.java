package org.j2eeframework.information.web.actions.admin.information.posttype;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.PostType;
import org.j2eeframework.information.service.PostTypeService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class PostTypeAction extends ServiceBaseManageAction<PostType,Long>
{
	private static final long serialVersionUID = 1642558831831460360L;
	@Resource
	private PostTypeService postTypeService;
	private PostType postType;
	@Override
	public IGenericService<PostType, Long> getGenericService()
	{
		return postTypeService;
	}

	public PostType getModel()
	{
		return postType;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			postType = new PostType();
		} else
		{
			postType = postTypeService.getEntityById(getRequestId());
		}
	}

}
