package org.j2eeframework.startoon.web.actions.enterprise.payment;

import java.text.DecimalFormat;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CastService;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class MyAccountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6852864718206952552L;

	private static final Log log = LogFactory.getLog(MyAccountAction.class);
	
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private CastService castService;
	
	private Enterprise enterprise;
	
	private String cast;
	
	
	@Override
	public String execute() {
		
		Long id = SysContext.getCurrentEnterpriserUser().getId();
		enterprise = enterpriseService.getEntityById(id);

		DecimalFormat df = new DecimalFormat("0.00");//保留两位小数
		double currentUserTodayCast = castService.getCurrentUserTodayCast();
		cast = df.format(currentUserTodayCast);
		
		log.debug("当前账户余额：" + enterprise.getFormatAmount() + "， 今天消费为：" +  cast);
		
		return SUCCESS;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}
}
