package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IEmailTemplateDAO;
import org.j2eeframework.startoon.entity.EmailTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService extends AbstractService<EmailTemplate, Long, IEmailTemplateDAO>
{
	@Resource
	private IEmailTemplateDAO emailTemplateDAO;

	@Override
	public IEmailTemplateDAO getGenericDAO()
	{
		return emailTemplateDAO;
	}
	
}
