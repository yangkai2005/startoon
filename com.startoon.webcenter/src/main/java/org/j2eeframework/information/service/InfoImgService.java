package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IInfoImgDAO;
import org.j2eeframework.information.entity.InfoImg;
import org.springframework.stereotype.Service;

@Service
public class InfoImgService extends AbstractService<InfoImg, Long, IInfoImgDAO> {
	@Resource
	private IInfoImgDAO infoImgDAO;

	@Override
	public IInfoImgDAO getGenericDAO() {
		return infoImgDAO;
	}
	
	/**
	 * 获取主图
	 * @param infoId
	 * @return
	 */
	public InfoImg getInfoMainImg(Long infoId) {
		return infoImgDAO.getInfoMainImg(infoId);
	}
	
	/**
	 * 获取InfoId下面所有的图片
	 * @param infoId
	 * @return
	 */
	public List<InfoImg> getInfoImgByInfoId(Long infoId) {
		Pager<InfoImg> pager = new Pager<InfoImg>();
		pager.getParamCondition().addParameter("infoId", infoId + "");
		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}

	/**
	 * 获取动漫视频
	 * @param infoId
	 * @return
	 */
	public InfoImg getVideoByInfoId(Long infoId) {
		List<InfoImg> videos = getInfoImgByInfoId(infoId);
		if(videos != null && !videos.isEmpty()) {
			return videos.get(0);
		}
		
		return null;
	}
}
