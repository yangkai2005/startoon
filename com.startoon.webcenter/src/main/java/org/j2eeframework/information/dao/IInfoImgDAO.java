package org.j2eeframework.information.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.information.entity.InfoImg;

public interface IInfoImgDAO extends IGenericDAO<InfoImg, Long> {
	
	public InfoImg getInfoMainImg(Long infoId);

}