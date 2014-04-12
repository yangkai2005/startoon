package org.j2eeframework.startoon.web.actions.admin.keyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.service.KeywordService;

public class KeywordAction extends ServiceBaseManageAction<Keyword, Long> {
	private static final long serialVersionUID = 6812158705896228475L;
	@Resource
	private KeywordService keywordService;
	private Keyword keyword;
	
	private String message;

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
	
	@Override
	public String insert() {
		keyword.setCreator(SysContext.getCurrentAdminUser());
		keyword.setCurrentPrice(keyword.getMinPrice());
		
		boolean exist = keywordService.exist(keyword.getKeyword());
		if(exist) {
			message = "<script>alert('该关键字已经存在，不能添加！');</script>";
			return "input";
		}
		
		return super.insert();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
