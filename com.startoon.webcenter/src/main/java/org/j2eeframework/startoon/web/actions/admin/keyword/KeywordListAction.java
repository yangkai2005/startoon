package org.j2eeframework.startoon.web.actions.admin.keyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.service.KeywordService;

public class KeywordListAction extends
		ServiceBasePaginationAction<Keyword, Long> {

	private static final long serialVersionUID = 3895234528939901584L;

	@Resource
	private KeywordService keywordService;

	@Override
	public IGenericService<Keyword, Long> getGenericService() {
		return keywordService;
	}

	@Override
	public void preExecute() {

	}

}
