package org.j2eeframework.startoon.web.actions.enterprise.supply;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.EnterpriseKeywordService;

import com.opensymphony.xwork2.ActionSupport;

public class UnbindAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 147925821021532053L;

	private static final Log log = LogFactory.getLog(UnbindAction.class);

	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;
	
	private Long supplyId;
	
	@Override
	public String execute() {
		log.debug("==>释放产品的关键字绑定[supplyId:" + supplyId + "]");
		enterpriseKeywordService.unbindFromSupply(supplyId);
		return "tips";
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}
}