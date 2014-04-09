package org.j2eeframework.information.web.actions.admin.information.reply;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Reply;
import org.j2eeframework.information.service.ReplyService;

public class ReplyAction extends ServiceBaseManageAction<Reply, Long> {
	private static final long serialVersionUID = 1452127321536437929L;
	@Resource
	private ReplyService replyService;
	private Reply reply;
	
	private List<Long> ids;
	private Integer status;

	@Override
	public IGenericService<Reply, Long> getGenericService() {
		return replyService;
	}

	public Reply getModel() {
		return reply;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			reply = new Reply();
		} else {
			reply = replyService.getEntityById(getRequestId());
		}
	}

	
	public String auditAll() {
		for(Long id : ids) {
			Reply reply = replyService.getEntityById(id);
			reply.setStatus(status);
			replyService.update(reply);
		}
		return ResultConstants.LIST;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
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
