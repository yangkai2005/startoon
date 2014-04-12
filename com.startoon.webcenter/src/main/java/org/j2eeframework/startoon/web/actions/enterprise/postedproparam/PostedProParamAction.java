package org.j2eeframework.startoon.web.actions.enterprise.postedproparam;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.PostedProParam;
import org.j2eeframework.startoon.service.PostedProParamService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class PostedProParamAction extends ServiceBaseManageAction<PostedProParam,Long>
{
	private static final long serialVersionUID = -6860039864646396802L;
	@Resource
	private PostedProParamService postedProParamService;
	private PostedProParam postedProParam;
	@Override
	public IGenericService<PostedProParam, Long> getGenericService()
	{
		return postedProParamService;
	}

	public PostedProParam getModel()
	{
		return postedProParam;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			postedProParam = new PostedProParam();
		} else
		{
			postedProParam = postedProParamService.getEntityById(getRequestId());
		}
	}

}
