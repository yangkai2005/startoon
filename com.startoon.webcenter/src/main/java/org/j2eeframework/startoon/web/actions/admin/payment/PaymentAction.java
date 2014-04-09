package org.j2eeframework.startoon.web.actions.admin.payment;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Payment;
import org.j2eeframework.startoon.service.PaymentService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class PaymentAction extends ServiceBaseManageAction<Payment,Long>
{
	private static final long serialVersionUID = 3292649360737817750L;
	@Resource
	private PaymentService paymentService;
	private Payment payment;
	@Override
	public IGenericService<Payment, Long> getGenericService()
	{
		return paymentService;
	}

	public Payment getModel()
	{
		return payment;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			payment = new Payment();
		} else
		{
			payment = paymentService.getEntityById(getRequestId());
		}
	}

}
