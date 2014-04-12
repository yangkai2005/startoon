package org.j2eeframework.information.web.actions.information.jobtype;

import javax.annotation.Resource;

import org.j2eeframework.information.service.JobTypeService;
import org.j2eeframework.startoon.util.Struts2Utils;

import com.opensymphony.xwork2.ActionSupport;

public class JobTypeTreeAction extends ActionSupport {

	private static final long serialVersionUID = -6960696324889148410L;
	@Resource
	private JobTypeService jobTypeService;

	private String data;

	@Override
	public String execute() {

		data = jobTypeService.getAllJSONString();
		Struts2Utils.renderJson(data);
		LOG.debug(data);

		return null;
	}

	public String getData() {
		return data;
	}

}
