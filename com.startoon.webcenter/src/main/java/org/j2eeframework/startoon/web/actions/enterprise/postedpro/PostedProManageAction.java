package org.j2eeframework.startoon.web.actions.enterprise.postedpro;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.service.PostedProService;

import com.opensymphony.xwork2.ActionSupport;

public class PostedProManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4360614649129999852L;

	private Long postedProId;

	private PostedPro postedPro;

	@Resource
	private PostedProService postedProService;

	public String detail() {
		postedPro = postedProService.getEntityById(postedProId);
		return "detail";
	}

	public Long getPostedProId() {
		return postedProId;
	}

	public void setPostedProId(Long postedProId) {
		this.postedProId = postedProId;
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}

}
