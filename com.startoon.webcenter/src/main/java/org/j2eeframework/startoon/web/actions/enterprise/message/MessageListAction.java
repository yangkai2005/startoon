package org.j2eeframework.startoon.web.actions.enterprise.message;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.service.MessageService;


public class MessageListAction extends ServiceBasePaginationAction<Message, Long> {

	private static final long serialVersionUID = -149770284670231472L;
	
	private static final Log log = LogFactory.getLog(MessageListAction.class);
	
	@Resource
	private MessageService messageService;
	
	@Override
	public IGenericService<Message, Long> getGenericService()	{
		return messageService;
	}

	@Override
	public void preExecute() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		ParamCondition param = getPager().getParamCondition();
		param.addParameter("messageType", "2");
		param.addParameter("receiverId", user.getId() + "");
		log.debug(param);
		
	}

}
