package org.j2eeframework.startoon.web.actions.admin.searchedkeyword;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.SearchedKeyword;
import org.j2eeframework.startoon.service.SearchedKeywordService;


public class SearchedKeywordListAction extends ServiceBasePaginationAction<SearchedKeyword, Long> {

	private static final long serialVersionUID = -4214903596463826061L;
	
	private static final Log log = LogFactory.getLog(SearchedKeywordListAction.class);

	@Resource
	private SearchedKeywordService searchedKeywordService;
	
	@Override
	public IGenericService<SearchedKeyword, Long> getGenericService()	{
		return searchedKeywordService;
	}

	@Override
	public void preExecute() {
		ParamCondition param = getPager().getParamCondition();
		getPager().setPageSize(20);
		log.debug("查询条件：" + param);
	}

}
