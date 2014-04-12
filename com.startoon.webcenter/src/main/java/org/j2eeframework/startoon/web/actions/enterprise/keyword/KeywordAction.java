package org.j2eeframework.startoon.web.actions.enterprise.keyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.service.KeywordService;

public class KeywordAction extends ServiceBaseManageAction<Keyword, Long> {
	private static final long serialVersionUID = 327819052163228634L;
	@Resource
	private KeywordService keywordService;
	private Keyword keyword;

	@Override
	public IGenericService<Keyword, Long> getGenericService() {
		return keywordService;
	}

	public Keyword getModel() {
		return keyword;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			keyword = new Keyword();
		} else {
			keyword = keywordService.getEntityById(getRequestId());
		}
	}


}
