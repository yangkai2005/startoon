package org.j2eeframework.startoon.web.actions.enterprise.categorykeyword;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.service.CategoryKeywordService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class CategoryKeywordAction extends ServiceBaseManageAction<CategoryKeyword,Long>
{
	private static final long serialVersionUID = 4200315423509160325L;
	@Resource
	private CategoryKeywordService categoryKeywordService;
	private CategoryKeyword categoryKeyword;
	@Override
	public IGenericService<CategoryKeyword, Long> getGenericService()
	{
		return categoryKeywordService;
	}

	public CategoryKeyword getModel()
	{
		return categoryKeyword;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			categoryKeyword = new CategoryKeyword();
		} else
		{
			categoryKeyword = categoryKeywordService.getEntityById(getRequestId());
		}
	}

}
