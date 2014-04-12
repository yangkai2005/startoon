package org.j2eeframework.startoon.web.actions.enterprises.entmsg;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.service.EntMsgService;

import com.opensymphony.xwork2.ActionSupport;

public class EntMsgsAction extends ActionSupport {

	private static final long serialVersionUID = -2114751573162265630L;

	private static final Log log = LogFactory.getLog(EntMsgsAction.class);

	@Resource
	private EntMsgService entMsgService;

	private EntMsg msg;

	private Long enterpriseId;

	@Action(value = "save", results = { @Result(name = "index", location = "/enterprises/entmsg/index.action?flag=0&enterpriseId=${enterpriseId}", type = "redirect"), @Result(name = "fail", location = "/enterprises/entmsg/index.action?flag=1&enterpriseId=${enterpriseId}", type = "redirect") })
	public String save() {
		log.debug(msg);
		return "index";
	}

	public EntMsg getMsg() {
		return msg;
	}

	public void setMsg(EntMsg msg) {
		this.msg = msg;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

}
