package org.j2eeframework.startoon.web.actions.admin.message;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.MessageService;

public class MessageListAction extends ServiceBasePaginationAction<Message, Long> {

	private static final long serialVersionUID = 7947183137345673215L;

	@Resource
	private MessageService messageService;
	@Resource
	private EnterpriseService enterpriseService;

	@Override
	public IGenericService<Message, Long> getGenericService() {
		return messageService;
	}

	@Override
	public void preExecute() {

	}

	@Override
	public String execute() {
		getPager().setPageSize(20);
		super.execute();
		List<Message> list = this.getPager().getItems();

		for (Message message : list) {
			Long eid = message.getReceiverId();
			Enterprise rcv = enterpriseService.getEntityById(eid);
			String name = null;
			if (rcv.getUserType() == 0) {
				name = rcv.getNickname() == null ? rcv.getAccount() : rcv.getNickname();
			} else {
				name = rcv.getName() == null ? rcv.getEmail() : rcv.getName();
			}
			message.setReceiverName(name);
			message.setReceiver(rcv);
		}

		return super.execute();
	}
}
