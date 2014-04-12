package org.j2eeframework.startoon.web.actions.enterprise.enterprisecategorykeyword;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.EnterpriseCategoryKeywordService;

import com.opensymphony.xwork2.ActionSupport;

public class BindAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1665703129948812607L;

	private static final Log log = LogFactory.getLog(BindAction.class);
	
	@Resource
	private EnterpriseCategoryKeywordService enterpriseCategoryKeywordService;
	
	private Long supplyId;
	private Long keywordId;
	
	private String errorMsg = null;
	
	@Override
	public String execute() {
		boolean canBind = enterpriseCategoryKeywordService.canBind(keywordId);
		if(canBind) {
			enterpriseCategoryKeywordService.bindToSupply(supplyId, keywordId);
			log.info("==>绑定类别关键字到产品上[Supply.id: " + supplyId + ", EnterpriseCategoryKeyword.id: " + keywordId + "]");
		} else {
			errorMsg = "该关键字已经绑定到企业或产品上，不能再绑定到该产品上！";
			log.warn("==>" + errorMsg);
		}
		log.debug("绑定类别关键字完成。");
		return "tips";
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}

	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
}