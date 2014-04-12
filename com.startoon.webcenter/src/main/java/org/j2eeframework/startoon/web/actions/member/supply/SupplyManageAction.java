package org.j2eeframework.startoon.web.actions.member.supply;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.SupplyService;

import com.opensymphony.xwork2.ActionSupport;

public class SupplyManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4360614649129999852L;

	private Long supplyId;
		
	private Supply supply;
	
	@Resource
	private SupplyService supplyService;

	public String detail()
	{
		supply = supplyService.getEntityById(supplyId);	
		return "detail";
	}
	
	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}
	
	
	
}
