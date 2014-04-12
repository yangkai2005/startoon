package org.j2eeframework.information.web.actions.member.bar;

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
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	private static final long serialVersionUID = 4103237001508710446L;

	private static final Log log = LogFactory.getLog(InfoAction.class);

	@Resource
	private InfoService infoService;
	@Resource
	private InfoTypeService infoTypeService;
	@Resource
	private EnterpriseService enterpriseService;
	
	private Info info;

	private List<InfoType> infoTypes;
	
	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	public Info getModel() {
		return info;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			info = new Info();
		} else {
			info = infoService.getEntityById(getRequestId());
		}
		
		infoTypes = infoTypeService.getInfoTypeByFatherId(5L);
	}

	@Override
	public String insert() {

		Enterprise user = SysContext.getCurrentEnterpriserUser();

		log.debug("店长吧内容发布[id:" + + user.getId() + "|account:" + user.getAccount() + "]");
		
		info.setCreator(user.getId());
		info.setCreatorName(user.getNickname());
		info.setCreatorType(Info.CREATOR_TYPE_PERSON);
		
		return super.insert();
	}
	
	public String apply() {

		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			
			Enterprise user = SysContext.getCurrentEnterpriserUser();
			user = enterpriseService.getEntityById(user.getId());
			user.setIsBar(1);
			enterpriseService.update(user);
			
			SysContext.setEnterpriseUser(user);
			request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER, user);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("success");
			out.flush();
			log.debug("==>申请成为店长吧会员[" + user.getAccount() + "]");
		} catch (IOException e) {
			log.error(e);
		}
		
		return null;
	}

	public List<InfoType> getInfoTypes() {
		return infoTypes;
	}

	public void setInfoTypes(List<InfoType> infoTypes) {
		this.infoTypes = infoTypes;
	}

}
