package org.j2eeframework.startoon.service;

import java.util.Date;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IPaymentDAO;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends AbstractService<Payment, Long, IPaymentDAO> {
	@Resource
	private IPaymentDAO paymentDAO;
	
	@Resource
	private EnterpriseService enterpriseService;

	@Override
	public IPaymentDAO getGenericDAO() {
		return paymentDAO;
	}


	/***
	 * 更新订单状态
	 * @param status
	 * @param id
	 */
	public void updateOrderStatus(int status,String orderid) {
		Payment payment = paymentDAO.getOrderById(orderid);
		payment.setStatus(status);
		this.update(payment);
	}
	
	/***
	 * 保存在线充值订单信息
	 * @param status
	 * @param id
	 */
	public void saveOrder(Payment obj) {
		this.saveOrUpdate(obj);
	}
	
	/***
	 * 检测订单支付状态
	 * 返回 1: 表示未支付 
	 * 返回 2: 表示已支付 
	 * 返回 3: 表示已删除
	 * @param orderid
	 * @return
	 */
	public int checkOrderStatus(String orderid){
		Payment obj = paymentDAO.getOrderById(orderid);
		return obj.getStatus();
	}
	
	/***
	 * 充值成功后更新会员账户余额
	 * @param orderid : 订单号
	 */
	public void updateAmount(String orderid){
		Payment obj = paymentDAO.getOrderById(orderid);
		if(obj != null){
			Enterprise user = obj.getCreator();
			if(user !=  null){
				user.setAmount(user.getAmount()+obj.getAmount()); 
				enterpriseService.update(user);
			}
		}
	}
	
	public Payment rechargeByAdminUser(Long enterpriseId, float amount, Long adminUserId) {
		
		AdminUser adminUser = new AdminUser();
		adminUser.setId(adminUserId);
		
		Enterprise enterprise = new Enterprise();
		enterprise.setId(enterpriseId);
		
		Payment payment = new Payment();
		payment.setCreator(enterprise);
		payment.setAdminUser(adminUser);
		payment.setType(1);
		payment.setAmount(amount);
		payment.setOrdertime(new Date());
		payment.setStatus(2);
		payment.setOrderid("H" + System.currentTimeMillis());
		
		insert(payment);
		
		return payment;
	}
	
	@Override
	public void getEntitiesOfPagerByParamCondition(Pager<Payment> pager) {
		ParamCondition paramCondition = pager.getParamCondition();
		
		pager.setItems(getGenericDAO().getPaymentByParamCondition(paramCondition, pager.getFirstResult(), pager.getPageSize()));
		pager.setCountOfTotalItem(getGenericDAO().getCountOfPayment(paramCondition));
		
	}
	
}
