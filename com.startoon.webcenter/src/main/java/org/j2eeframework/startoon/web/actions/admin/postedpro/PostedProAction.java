package org.j2eeframework.startoon.web.actions.admin.postedpro;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.service.PostedProService;

public class PostedProAction extends ServiceBaseManageAction<PostedPro, Long> {
	private static final long serialVersionUID = -4344949024712150009L;
	@Resource
	private PostedProService postedProService;
	private PostedPro postedPro;

	private List<Long> ids;

	private Integer status;

	@Override
	public IGenericService<PostedPro, Long> getGenericService() {
		return postedProService;
	}

	public PostedPro getModel() {
		return postedPro;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			postedPro = new PostedPro();
		} else {
			postedPro = postedProService.getEntityById(getRequestId());
		}
	}

	public String audit() {

		if (ids != null && !ids.isEmpty()) {
			for (Long id : ids) {
				PostedPro pro = getGenericService().getEntityById(id);
				pro.setStatus(status);
				getGenericService().update(pro);
			}
		}

		return ResultConstants.LIST;
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
