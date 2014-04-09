package org.j2eeframework.startoon.web.actions.admin.payment;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Payment;
import org.j2eeframework.startoon.service.PaymentService;


public class PaymentListAction extends ServiceBasePaginationAction<Payment, Long> {

	private static final long serialVersionUID = -1283357121534597352L;

	@Resource
	private PaymentService paymentService;
	
	@Override
	public IGenericService<Payment, Long> getGenericService()	{
		return paymentService;
	}

	@Override
	public void preExecute() {
		
	}

}
