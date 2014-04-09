package org.j2eeframework.startoon.web.actions.enterprises.entmsg;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntMsgService;

public class EntMsgAction extends ServiceBaseManageAction<EntMsg, Long> {

	private static final long serialVersionUID = 2317717452310710013L;

	private static final Log log = LogFactory.getLog(EntMsgAction.class);

	@Resource
	private EntMsgService entMsgService;
	private EntMsg entMsg;
	private Long enterpriseId;
	private String creatorName;
	private String email;
	private String contact;
	private String content;
	private Integer flag;
	@Override
	public IGenericService<EntMsg, Long> getGenericService() {
		return entMsgService;
	}

	public EntMsg getModel() {
		return entMsg;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			entMsg = new EntMsg();
		} else {
			entMsg = entMsgService.getEntityById(getRequestId());
		}
	}

	public String doInsert()throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置字符集
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int result = -1;
		try {
			Enterprise ent = new Enterprise();
			ent.setId(enterpriseId);
			getModel().setContact(contact);
			getModel().setEmail(email);
			getModel().setCreatorName(creatorName);
			getModel().setContent(content);
			getModel().setEnterprise(ent);
			super.insert();
			flag = 0;
		} catch (Exception e) {
			e.printStackTrace();
			flag = 1;
		}
		out.println(flag);
		return null;
	}
	
	

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
