package org.j2eeframework.startoon.web.actions.enterprise.keyword;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.service.KeywordService;


public class KeywordListAction extends ServiceBasePaginationAction<Keyword, Long> {

	private static final long serialVersionUID = 2501431664138659966L;

	private static final Log log = LogFactory.getLog(KeywordListAction.class);

	@Resource
	private KeywordService keywordService;
	
	@Override
	public IGenericService<Keyword, Long> getGenericService()	{
		return keywordService;
	}

	@Override
	public void preExecute() {
		String ec = getPager().getParamCondition().getParameter("ec");
		log.debug("出错信息代码：" + ec);
	}

}
