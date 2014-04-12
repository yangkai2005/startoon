package org.j2eeframework.startoon.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IMessageDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.entity.MsgRecord;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends AbstractService<Message, Long, IMessageDAO> {
	@Resource
	private IMessageDAO messageDAO;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private MsgRecordService msgRecordService;

	@Override
	public IMessageDAO getGenericDAO() {
		return messageDAO;
	}

	public void send(Message msg) {
		getGenericDAO().insert(msg);
	}

	/**
	 *  发送信信息
	 * @param message
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void sendSystemMessage(Message message) throws IllegalAccessException, InvocationTargetException {
		List<Enterprise> enterprises = enterpriseService.getAllEntity();
		send(message, enterprises);
	}

	/***
	 * 发送短信息
	 * @param message
	 * @param ids
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void sendMessage(Message message, String ids) throws IllegalAccessException, InvocationTargetException {
		List<Enterprise> enterprises = enterpriseService.getEnterpriseByIds(ids);
		send(message, enterprises);
	}

	public void send(Message message, List<Enterprise> enterprises) throws IllegalAccessException, InvocationTargetException {

		StringBuilder receiverIds = new StringBuilder();
		StringBuilder receiverNames = new StringBuilder();

		// 向每一个接受者发送信息
		for (Enterprise e : enterprises) {

			Long eid = e.getId();
			String name = e.getAccount();

			receiverIds.append(eid);
			receiverNames.append(name);

			Message msg = new Message();
			BeanUtils.copyProperties(msg, message);
			msg.setReceiverId(eid);

			getGenericDAO().insert(msg);

		}

		// 记录信息发送历史
		MsgRecord msg = new MsgRecord();
		msg.setTitle(message.getTitle());
		msg.setContent(message.getContent());
		msg.setCtime(message.getCreateTime());
		msg.setSenderId(message.getSenderId());
		msg.setSenderName(message.getSenderName());
		msg.setReceiverIds(receiverIds.toString());
		msg.setReceiverNames(receiverNames.toString());

		msgRecordService.insert(msg);

	}

	public Message read(Long id) {
		Message msg = getEntityById(id);
		msg.setStatus(1);
		getGenericDAO().update(msg);
		return msg;
	}

	@Override
	public void getEntitiesOfPagerByParamCondition(Pager<Message> pager) {
		super.getEntitiesOfPagerByParamCondition(pager);
		List<Message> list = pager.getItems();
		for (Message m : list) {
			if (m.getMessageType() != 2) {
				Long rid = m.getReceiverId();
				Enterprise ent = enterpriseService.getEntityById(rid);
				String name = ent.getName() == null ? ent.getAccount() : ent.getName();
				m.setReceiverName(name);
			}
		}
	}

}
