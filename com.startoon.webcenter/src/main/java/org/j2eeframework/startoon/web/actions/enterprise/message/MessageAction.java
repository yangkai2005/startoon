package org.j2eeframework.startoon.web.actions.enterprise.message;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.MessageService;

public class MessageAction extends ServiceBaseManageAction<Message, Long> {
	private static final long serialVersionUID = 7202123440431140608L;
	@Resource
	private MessageService messageService;
	@Resource
	private EnterpriseService enterpriseService;
	
	private Message message;
	
	private List<Enterprise> enterprises;

	@Override
	public IGenericService<Message, Long> getGenericService() {
		return messageService;
	}

	public Message getModel() {
		return message;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			message = new Message();
		} else {
			message = messageService.getEntityById(getRequestId());
		}
		
		enterprises = enterpriseService.getAll();
		
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		Long senderId = user.getId();
		String senderName = user.getNickname();
		message.setSenderId(senderId);
		message.setSenderName(senderName);
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
