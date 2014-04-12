package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IDynamicDAO;
import org.j2eeframework.startoon.entity.Dynamic;
import org.springframework.stereotype.Service;

@Service
public class DynamicService extends AbstractService<Dynamic, Long, IDynamicDAO> {
	@Resource
	private IDynamicDAO dynamicDAO;

	@Override
	public IDynamicDAO getGenericDAO() {
		return dynamicDAO;
	}
}
