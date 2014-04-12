package org.j2eeframework.startoon.web.actions.inc;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.JobType;
import org.j2eeframework.information.service.JobTypeService;

import com.opensymphony.xwork2.ActionSupport;

public class JobTypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626323695742160663L;

	@Resource
	private JobTypeService jobTypeService;

	private List<JobType> items;

	@Override
	public String execute() {
		items = jobTypeService.getJobTypeByLevel(1);
		return SUCCESS;
	}

	public List<JobType> getItems() {
		return items;
	}

	public void setItems(List<JobType> items) {
		this.items = items;
	}

}
