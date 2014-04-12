package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IEmployeeInfoDAO;
import org.j2eeframework.information.entity.EmployeeInfo;

@Service
public class EmployeeInfoService extends AbstractService<EmployeeInfo, Long, IEmployeeInfoDAO>
{
	@Resource
	private IEmployeeInfoDAO employeeInfoDAO;

	@Override
	public IEmployeeInfoDAO getGenericDAO()
	{
		return employeeInfoDAO;
	}
}
