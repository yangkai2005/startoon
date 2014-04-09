package org.j2eeframework.startoon.web.actions.enterprise.supply;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.EnterpriseKeywordService;

import com.opensymphony.xwork2.ActionSupport;

public class BindAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 147925821021532053L;

	private static final Log log = LogFactory.getLog(BindAction.class);

	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;
	
	private Long supplyId;
	
	private Long keywordId;
	
	private String errorMsg = "";
	
	@Override
	public String execute() {
		boolean canBind = enterpriseKeywordService.canBind(keywordId);
		if(canBind) {
			enterpriseKeywordService.bindToSupply(supplyId, keywordId);
			log.info("==>绑定关键字到产品[supplyId:" + supplyId + "|keywordId:" + keywordId + "]");
		} else {
			errorMsg = "关键字已经绑定到企业或者产品，不能再绑定到其他产品了！";
			log.warn("==>绑定关键字失败[supplyId:" + supplyId + "|keywordId:" + keywordId + "]，该关键字已经绑定到其他产品或者企业");
		}
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