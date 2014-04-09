package org.j2eeframework.startoon.web.actions.enterprise.supply;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.SupplyService;

import com.opensymphony.xwork2.ActionSupport;

public class SupplyManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4360614649129999852L;

	@Resource
	private SupplyService supplyService;

	private Long supplyId;

	private Supply supply;

	private List<Supply> recommends;

	public String detail() {
		supply = supplyService.getEntityById(supplyId);

		Enterprise ent = supply.getCreator();
		Long enterpriseId = ent.getId();
		recommends = supplyService.getRecommendSupplies(enterpriseId, 5);

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
	public List<Supply> getRecommends() {
		return recommends;
	}

}
