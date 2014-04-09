package org.j2eeframework.startoon.web.actions.supply;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.SupplyService;

import com.opensymphony.xwork2.ActionSupport;

public class SupplyContrastAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3647446103990847449L;

	private static final Log log = LogFactory.getLog(SupplyContrastAction.class);

	@Resource
	private SupplyService supplyService;

	private Supply supply1;
	private Supply supply2;

	private List<Long> supplyId;

	@Override
	public String execute() {

		Long supplyId1 = null;
		Long supplyId2 = null;

		if(supplyId != null && !supplyId.isEmpty() && supplyId.size() > 1) {
			supplyId1 = supplyId.get(0);
			supplyId2 = supplyId.get(1);
		} else {
			return SUCCESS;
		}
		supply1 = supplyService.getEntityById(supplyId1);
		supply2 = supplyService.getEntityById(supplyId2);

		StringBuffer sb = new StringBuffer();
		sb.append("产品对比：");
		sb.append("\n");
		sb.append("supply1[" + supply1.getId() + ", " + supply1.getName() + "]");
		sb.append("\n");
		sb.append("supply2[" + supply2.getId() + ", " + supply2.getName() + "]");

		log.debug(sb.toString());

		return SUCCESS;
	}

	public Supply getSupply1() {
		return supply1;
	}

	public Supply getSupply2() {
		return supply2;
	}

	public void setSupplyId(List<Long> supplyId) {
		this.supplyId = supplyId;
	}

}
