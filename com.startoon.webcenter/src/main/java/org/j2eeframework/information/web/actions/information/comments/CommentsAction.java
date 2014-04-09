package org.j2eeframework.information.web.actions.information.comments;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Comments;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.CommentsService;
import org.j2eeframework.information.service.InfoService;

public class CommentsAction extends ServiceBaseManageAction<Comments, Long> {
	private static final long serialVersionUID = 5643064726406728050L;
	@Resource
	private CommentsService commentsService;
	@Resource
	private InfoService infoService;
	private Comments comments;
	private Long infoId;

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
	
	@Action(results = { @Result(name = "success", location = "/information/info/info!show.action?requestId=${infoId}&flag=true", type="redirect")})
	public String insert() {
		
		infoId = comments.getInfo().getId();
		
		super.insert();
		
		//评论数加1
		Info info = infoService.getEntityById(infoId);
		int c = info.getComments();
		c += 1;
		info.setComments(c);
		infoService.update(info);
		
		return SUCCESS;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

}
