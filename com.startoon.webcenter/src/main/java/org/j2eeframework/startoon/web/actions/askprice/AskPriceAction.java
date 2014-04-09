package org.j2eeframework.startoon.web.actions.askprice;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.AskPrice;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.AskPriceService;
import org.j2eeframework.startoon.service.EnterpriseService;

/**
 * 询价处理类
 * 
 * @author kai
 */
public class AskPriceAction extends ServiceBaseManageAction<AskPrice, Long> {
	private static final long serialVersionUID = 3178658553102924643L;
	@Resource
	private AskPriceService askPriceService;
	@Resource
	private EnterpriseService enterpriseService;

	private AskPrice askPrice;

	private Enterprise supplier;

	private Long enterpriseId;

	@Override
	public IGenericService<AskPrice, Long> getGenericService() {
		return askPriceService;
	}

	public AskPrice getModel() {
		return askPrice;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			askPrice = new AskPrice();
		} else {
			askPrice = askPriceService.getEntityById(getRequestId());
		}

		supplier = enterpriseService.getEntityById(enterpriseId);

		askPrice.setEnterprise(supplier);
	}

	@Override
	public String insert() {
		super.insert();
		return SUCCESS;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public AskPrice getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(AskPrice askPrice) {
		this.askPrice = askPrice;
	}

	public Enterprise getSupplier() {
		return supplier;
	}

	public void setSupplier(Enterprise supplier) {
		this.supplier = supplier;
	}

}
