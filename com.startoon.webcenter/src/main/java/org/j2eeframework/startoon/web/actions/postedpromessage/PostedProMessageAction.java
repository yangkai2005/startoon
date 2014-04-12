package org.j2eeframework.startoon.web.actions.postedpromessage;

import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PostedProMessage;

import com.opensymphony.xwork2.ActionSupport;

public class PostedProMessageAction extends ActionSupport {

	private static final long serialVersionUID = 623288054029254395L;
	
	private PostedProMessage postedProMessage;

	private Enterprise enterprise;

	private Long enterpriseId;

	public String input() {
		return SUCCESS;
	}

	public PostedProMessage getPostedProMessage() {
		return postedProMessage;
	}

	public void setPostedProMessage(PostedProMessage postedProMessage) {
		this.postedProMessage = postedProMessage;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

}
