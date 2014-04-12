package org.j2eeframework.startoon.web.actions.admin.message;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.service.MessageService;
import org.j2eeframework.startoon.util.StringUtil;

public class MessageAction extends ServiceBaseManageAction<Message, Long> {

	private static final long serialVersionUID = 3881047989587818036L;
	@Resource
	private MessageService messageService;
	private Message message;
	private String ids;

	private List<Long> msgId;

	@Override
	public IGenericService<Message, Long> getGenericService() {
		return messageService;
	}

	public Message getModel() {
		return message;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			message = new Message();
		} else {
			message = messageService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {
		setNextMethod("sendSysMsg");
		return ResultConstants.INPUT;
	}

	public String sendSysMsg() throws IllegalAccessException, InvocationTargetException {

		AdminUser adminUser = SysContext.getCurrentAdminUser();

		message.setMessageType(2);
		message.setSenderId(adminUser.getId());
		message.setSenderName(adminUser.getAccount());

		// messageService.sendSystemMessage(message);
		if (StringUtil.notNull(ids)) {
			messageService.sendMessage(message, ids);
		}
		return ResultConstants.LIST;

	}

	public String deleteAll() {
		if (msgId != null && !msgId.isEmpty()) {
			for (Long id : msgId) {
				getGenericService().deleteEntityById(id);
			}
		}
		return ResultConstants.LIST;
	}
	public List<Long> getMsgId() {
		return msgId;
	}

	public void setMsgId(List<Long> msgId) {
		this.msgId = msgId;
	}

}
