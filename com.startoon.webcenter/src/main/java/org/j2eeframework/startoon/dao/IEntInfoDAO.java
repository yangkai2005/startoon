package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.EntInfo;

public interface IEntInfoDAO extends IGenericDAO<EntInfo, Long> {

	EntInfo getEntInfoByEnterpriseId(Long enterpriseId);

}