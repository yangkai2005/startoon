package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IEmployeeFileDAO;
import org.j2eeframework.information.entity.EmployeeFile;

@Service
public class EmployeeFileService extends AbstractService<EmployeeFile, Long, IEmployeeFileDAO>
{
	@Resource
	private IEmployeeFileDAO employeeFileDAO;

	@Override
	public IEmployeeFileDAO getGenericDAO()
	{
		return employeeFileDAO;
	}
}
