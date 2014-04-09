package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.startoon.entity.Payment;

public interface IPaymentDAO extends IGenericDAO<Payment, Long> {

	Payment getOrderById(String orderid);
	
	
	public List<Payment> getPaymentByParamCondition(ParamCondition condition, int firstResult, int pageSize);
	

	public int getCountOfPayment(ParamCondition condition);

}