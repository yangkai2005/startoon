package org.j2eeframework.startoon.web.actions.enterprise.enterprisecategorykeyword;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.EnterpriseCategoryKeywordService;

import com.opensymphony.xwork2.ActionSupport;

public class UnbindAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1665703129948812607L;

	private static final Log log = LogFactory.getLog(UnbindAction.class);
	
	@Resource
	private EnterpriseCategoryKeywordService enterpriseCategoryKeywordService;
	
	private Long supplyId;
	
	@Override
	public String execute() {
		log.debug("从产品上面释放绑定的类别关键字...");
		enterpriseCategoryKeywordService.unbindFromSupply(supplyId);
		log.debug("从产品上面释放绑定的类别关键字完成.");
		return "tips";
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}

	
}