package org.j2eeframework.startoon.web.actions.enterprise.payment;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Payment;
import org.j2eeframework.startoon.service.PaymentService;


public class PaymentListAction extends ServiceBasePaginationAction<Payment, Long> {

	private static final long serialVersionUID = 5295926957139617306L;

	@Resource
	private PaymentService paymentService;
	
	@Override
	public IGenericService<Payment, Long> getGenericService()	{
		return paymentService;
	}

	@Override
	public void preExecute() {
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		getPager().getParamCondition().addParameter("creatorId", enterprise.getId() + "");
	}

}
