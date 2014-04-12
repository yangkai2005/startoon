package org.j2eeframework.information.web.actions.information.bar;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Reply;
import org.j2eeframework.information.service.ReplyService;

public class ReplyAction extends ServiceBaseManageAction<Reply, Long> {
	private static final long serialVersionUID = -7393255469865675711L;
	@Resource
	private ReplyService replyService;
	private Reply reply;

	private Long pid;

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

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
