package org.j2eeframework.startoon.web.actions.admin.clickedkeyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.j2eeframework.startoon.service.ClickedKeywordService;


public class ClickedKeywordListAction extends ServiceBasePaginationAction<ClickedKeyword, Long> {

	private static final long serialVersionUID = 4194051538459957368L;

	@Resource
	private ClickedKeywordService clickedKeywordService;
	
	@Override
	public IGenericService<ClickedKeyword, Long> getGenericService()	{
		return clickedKeywordService;
	}

	@Override
	public void preExecute() {
		
	}

}
