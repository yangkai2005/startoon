package org.j2eeframework.information.web.actions.information.inc;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.Copartnership;
import org.j2eeframework.information.service.CopartnershipService;

import com.opensymphony.xwork2.ActionSupport;

public class CopartnershipAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8380423568949522896L;
	@Resource
	private CopartnershipService copartnershipService;

	private Long infoTypeId;

	private List<Copartnership> copartnerships;

	@Override
	public String execute() {
		copartnerships = copartnershipService.getCopartnershipByInfoTypeId(infoTypeId, 18);
		return SUCCESS;
	}

	public CopartnershipService getCopartnershipService() {
		return copartnershipService;
	}

	public void setInfoTypeId(Long infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public List<Copartnership> getCopartnerships() {
		return copartnerships;
	}

	public void setCopartnerships(List<Copartnership> copartnerships) {
		this.copartnerships = copartnerships;
	}

}
