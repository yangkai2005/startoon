package org.j2eeframework.startoon.web.actions.admin.enterprise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseAction extends ServiceBaseManageAction<Enterprise, Long> {

	private static final long serialVersionUID = -2523738998791368006L;

	private static final Log log = LogFactory.getLog(EnterpriseAction.class);

	@Resource
	private EnterpriseService enterpriseService;
	private Enterprise enterprise;
	private Integer status;
	private List<Long> ids;

	private String password;

	private float _amount;

	private boolean isCartoon;

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	public Enterprise getModel() {
		return enterprise;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			enterprise = new Enterprise();
		} else {
			enterprise = enterpriseService.getEntityById(getRequestId());
		}
	}

	public String audit() {

		for (Long id : ids) {
			enterprise = enterpriseService.getEntityById(id);
			enterprise.setStatus(status);
			enterpriseService.update(enterprise);
		}

		return ResultConstants.LIST;

	}

	public String deleteAll() {

		for (Long id : ids) {
			enterprise = enterpriseService.getEntityById(id);
			enterprise.setStatus(Enterprise.STATUS_DELETEED);
			enterpriseService.update(enterprise);
		}

		return ResultConstants.LIST;
	}

	public String forwardPwd() {
		return "password";
	}

	public String modifyPwd() {

		String pwdStr = EncryptUtil.md5(password);

		enterprise.setPassword(pwdStr);

		enterpriseService.update(enterprise);

		return "pwdtips";
	}

	public String forwardType() {
		return "companytype";

	}

	/**
	 * 
	 * @return
	 * @author tangjianhong
	 */
	public String modifyComType() {
		boolean b = isCartoon;
		enterprise.setCartoon(b);
		enterpriseService.update(enterprise);
		return "modify-com-type-success";

	}

	/**
	 * 跳转的充值页面
	 * 
	 * @return
	 */
	public String forwardRecharge() {
		return "recharge";
	}

	/**
	 * 管理员充值
	 * 
	 * @return
	 */
	public String recharge() {
		enterpriseService.recharge(getRequestId(), _amount);
		return "rechargetips";
	}

	/**
	 * 更新状态
	 * 
	 * @return
	 */
	public String updateState() {

		enterprise.setStatus(status);
		enterpriseService.update(enterprise);

		return ResultConstants.LIST;
	}

	public String getUser() throws IOException {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		String flag = request.getParameter("flag");
		int f = Integer.valueOf(flag);

		String json = enterpriseService.getUserJsonByFlag(f);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
		log.debug("获取用户JSON字符串为：" + json);

		return null;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float get_amount() {
		return _amount;
	}

	public void set_amount(float amount) {
		_amount = amount;
	}

	public boolean isCartoon() {
		return isCartoon;
	}

	public void setCartoon(boolean isCartoon) {
		this.isCartoon = isCartoon;
	}

}
