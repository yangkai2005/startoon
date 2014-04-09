package org.j2eeframework.information.web.actions.admin.information.comments;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Comments;
import org.j2eeframework.information.service.CommentsService;

public class CommentsAction extends ServiceBaseManageAction<Comments, Long> {
	private static final long serialVersionUID = 3002326422678281779L;
	@Resource
	private CommentsService commentsService;
	
	private Comments comments;
	
	private List<Long> ids;
	private Integer status;

	@Override
	public IGenericService<Comments, Long> getGenericService() {
		return commentsService;
	}

	public Comments getModel() {
		return comments;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			comments = new Comments();
		} else {
			comments = commentsService.getEntityById(getRequestId());
		}
	}
	
	public String audit() {
		
		for(Long id : ids) {
			Comments c = commentsService.getEntityById(id);
			c.setStatus(status);
			commentsService.update(c);
		}
		
		return ResultConstants.LIST;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
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
