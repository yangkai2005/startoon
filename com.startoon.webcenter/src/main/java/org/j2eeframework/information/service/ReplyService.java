package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IReplyDAO;
import org.j2eeframework.information.entity.Reply;

@Service
public class ReplyService extends AbstractService<Reply, Long, IReplyDAO>
{
	@Resource
	private IReplyDAO replyDAO;

	@Override
	public IReplyDAO getGenericDAO()
	{
		return replyDAO;
	}
}
