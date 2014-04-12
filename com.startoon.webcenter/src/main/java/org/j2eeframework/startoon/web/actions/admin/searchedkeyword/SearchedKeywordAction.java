package org.j2eeframework.startoon.web.actions.admin.searchedkeyword;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.SearchedKeyword;
import org.j2eeframework.startoon.service.SearchedKeywordService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class SearchedKeywordAction extends ServiceBaseManageAction<SearchedKeyword,Long>
{
	private static final long serialVersionUID = 3129016364553281612L;
	@Resource
	private SearchedKeywordService searchedKeywordService;
	private SearchedKeyword searchedKeyword;
	@Override
	public IGenericService<SearchedKeyword, Long> getGenericService()
	{
		return searchedKeywordService;
	}

	public SearchedKeyword getModel()
	{
		return searchedKeyword;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			searchedKeyword = new SearchedKeyword();
		} else
		{
			searchedKeyword = searchedKeywordService.getEntityById(getRequestId());
		}
	}

}
