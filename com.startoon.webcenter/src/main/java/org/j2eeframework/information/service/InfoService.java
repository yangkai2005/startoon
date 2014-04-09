package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IInfoDAO;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Vote;
import org.springframework.stereotype.Service;

@Service
public class InfoService extends AbstractService<Info, Long, IInfoDAO> {
	@Resource
	private IInfoDAO infoDAO;
	@Resource
	private InfoImgService infoImgService;
	@Resource
	private InfoTypeService infoTypeService;
	@Resource
	private VoteService voteService;
	@Resource
	private CommentsService commentsService;

	@Override
	public IInfoDAO getGenericDAO() {
		return infoDAO;
	}

	@Override
	public void getEntitiesOfPagerByParamCondition(Pager<Info> pager) {
		super.getEntitiesOfPagerByParamCondition(pager);
		List<Info> infos = pager.getItems();
		for (Info info : infos) {
			InfoImg img = infoImgService.getInfoMainImg(info.getId());
			info.setMainImg(img);
		}

	}

	/**
	 * 查询相应类别下的数据
	 * 
	 * @param infoTypeId
	 * @param size
	 * @return
	 */
	public List<Info> getInfoByInfoType(Long infoTypeId, int size) {
		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("infoTypeId", infoTypeId + "");
		pager.getParamCondition().addParameter("orderBy", "id");
		pager.getParamCondition().addParameter("orderType", "desc");
		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}

	/**
	 * 查询相应类别下的数据
	 * 
	 * @param infoTypeIds
	 * @param size
	 * @return
	 */
	public List<Info> getInfoByInfoTypes(List<Long> infoTypeIds, int size) {

		if (infoTypeIds == null || infoTypeIds.isEmpty()) {
			return null;
		}

		String[] ids = new String[infoTypeIds.size()];
		int i = 0;
		for (Long id : infoTypeIds) {
			ids[i++] = id + "";
		}

		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameterValues("infoTypeIds", ids);
		pager.getParamCondition().addParameter("orderBy", "id");
		pager.getParamCondition().addParameter("orderType", "desc");
		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}

	/**
	 * 热点推荐
	 * 
	 * @param size
	 * @return
	 */
	public List<Info> getHotInfo(int size) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("hot", "true");
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, size);
	}

	/**
	 * 阅读推荐
	 * 
	 * @param size
	 * @return
	 */
	public List<Info> getRecommendInfo(int size) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("recommend", "true");
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, size);
	}

	/**
	 * 获取最新资讯
	 * 
	 * @param size
	 * @return
	 */
	public List<Info> getLatestInfo(int size) {
		ParamCondition condition = new ParamCondition();
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, size);
	}

	/**
	 * 获取置顶资讯
	 * 
	 * @param size
	 * @return
	 */
	public List<Info> getTopInfo(int size) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("top", "true");
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, size);
	}

	/**
	 * 阅读排行
	 * 
	 * @param size
	 * @return
	 */
	public List<Info> getHitInfo(int size) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("orderBy", "hits");
		cond.addParameter("orderType", "desc");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, size);
	}

	/**
	 * 获取相同类型的上一条
	 * 
	 * @param info
	 * @return
	 */
	public Info getPreInfo(Info info) {
		return infoDAO.getPreInfo(info);
	}

	/**
	 * 获取相同类型的下一条
	 * 
	 * @param info
	 * @return
	 */
	public Info getNextInfo(Info info) {
		return infoDAO.getNextInfo(info);
	}

	/**
	 * 获取资讯和所有的图片
	 * 
	 * @param id
	 * @return
	 */
	public Info getInfoWithImages(Long id) {

		Info info = infoDAO.getEntityById(id);

		List<InfoImg> imgs = infoImgService.getInfoImgByInfoId(info.getId());
		info.setInfoImgs(imgs);

		// 提取主图
		for (InfoImg img : imgs) {
			if (img.getIsMainImg())
				info.setMainImg(img);
		}

		return info;
	}

	/**
	 * 根据创建人ID进行校验删除 如果创建人和登录者不一致，则不允许删除
	 * 
	 * @param id
	 * @param creatorId
	 * @return
	 */
	public boolean deleteById(Long id, Long creatorId) {

		Info info = getEntityById(id);
		if (info != null && creatorId != null && info.getCreator().longValue() == creatorId.longValue()) {
			delete(info);
			return true;
		}

		return false;
	}

	/**
	 * 最新调查
	 * 
	 * @return
	 */
	public Info getLatestSurveyInfo() {

		String typeNo = "000204";
		List<InfoType> infoTypes = infoTypeService.getInfoTypeByNo(typeNo);

		String[] infoTypeIds = new String[infoTypes.size()];
		int i = 0;
		for (InfoType t : infoTypes) {
			infoTypeIds[i++] = t.getId() + "";
		}

		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(1);
		pager.getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
		getEntitiesOfPagerByParamCondition(pager);

		List<Info> infos = pager.getItems();
		if (infos != null && !infos.isEmpty()) {

			Info info = infos.get(0);

			Long id = info.getId();

			List<Vote> votes = voteService.getVoteByInfoId(id);

			info.setVotes(votes);

			return info;

		}

		return null;
	}

	/**
	 * 获取展会调查
	 * 
	 * @param infoTypeId
	 * @return
	 */
	public Info getLatestSurveyInfo(Long infoTypeId) {

		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(1);
		pager.getParamCondition().addParameter("infoTypeId", infoTypeId + "");
		getEntitiesOfPagerByParamCondition(pager);

		List<Info> infos = pager.getItems();
		if (infos != null && !infos.isEmpty()) {

			Info info = infos.get(0);

			Long id = info.getId();

			List<Vote> votes = voteService.getVoteByInfoId(id);

			info.setVotes(votes);

			return info;

		}

		return null;
	}

	/**
	 * 根据ID获取调查
	 * 
	 * @param id
	 * @return
	 */
	public Info getSurveyInfoById(Long id) {

		Info surveyInfo = getEntityById(id);

		if (surveyInfo != null) {
			List<Vote> votes = voteService.getVoteByInfoId(id);
			surveyInfo.setVotes(votes);
			return surveyInfo;
		}

		return null;

	}

	/**
	 * 获取相应类别ID下图片资讯
	 * 
	 * @param infoTypeId
	 * @param size
	 * @return
	 */
	public List<Info> getImgInfoByInfoTypeId(Long infoTypeId, int size) {

		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("isImgInfo", "true");
		pager.getParamCondition().addParameter("infoTypeId", infoTypeId + "");
		pager.getParamCondition().addParameter("orderBy", "id");
		pager.getParamCondition().addParameter("orderType", "desc");

		getEntitiesOfPagerByParamCondition(pager);

		return pager.getItems();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.j2eeframework.commons.service.impl.AbstractService#delete(java.lang
	 * .Object)
	 */
	@Override
	public void delete(Info info) {
		Long infoId = info.getId();
		commentsService.deleteByInfoId(infoId);
		getGenericDAO().delete(info);
	}

	/**
	 * 人才服务专用获取指定条数数据
	 * 
	 * @param infoTypeId
	 * @param count
	 * @return
	 */
	public List<Info> getHrServiceInfo(Long infoTypeId, int count) {

		ParamCondition condition = new ParamCondition();
		condition.addParameter("status", "6");
		condition.addParameter("infoTypeId", infoTypeId + "");

		List<Info> infos = infoDAO.getEntitiesByParamCondition(condition, 0, count);

		return infos;
	}

	/**
	 * 专题的焦点图
	 * 
	 * @param subjectId
	 * @param size
	 * @return
	 */
	public List<Info> getImgInfoBySubjectId(Long subjectId, int size) {
		final Long subjectNewsInfoTypeId = 49L;
		ParamCondition cond = new ParamCondition();
		cond.addParameter("subjectId", subjectId + "");
		cond.addParameter("infoTypeId", subjectNewsInfoTypeId + "");
		cond.addParameter("isImgInfo", "true");
		cond.addParameter("hot", "true");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		// 处理焦点图片
		for (Info info : infos) {
			List<InfoImg> imgs = infoImgService.getInfoImgByInfoId(info.getId());
			info.setInfoImgs(imgs);

			// 提取主图
			for (InfoImg img : imgs) {
				if (img.getIsMainImg()) {
					info.setMainImg(img);
					break;
				}
			}

		}

		return infos;
	}

	/**
	 * 专题的焦点新闻
	 * 
	 * @param subjectId
	 * @param size
	 * @return
	 */
	public List<Info> getFocusInfoBySubjectId(Long subjectId, int size) {
		final Long subjectNewsInfoTypeId = 49L;
		ParamCondition cond = new ParamCondition();
		cond.addParameter("subjectId", subjectId + "");
		cond.addParameter("infoTypeId", subjectNewsInfoTypeId + "");
		cond.addParameter("isImgInfo", "false");
		cond.addParameter("hot", "true");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);
		return infos;
	}

	/**
	 * 专题的最新消息
	 * 
	 * @param subjectId
	 * @param size
	 * @return
	 */
	public List<Info> getLatestInfoBySubjectId(Long subjectId, int size) {
		final Long subjectNewsInfoTypeId = 49L;
		ParamCondition cond = new ParamCondition();
		cond.addParameter("subjectId", subjectId + "");
		cond.addParameter("infoTypeId", subjectNewsInfoTypeId + "");
		cond.addParameter("isImgInfo", "false");
		cond.addParameter("hot", "false");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);
		return infos;
	}

	/**
	 * 专题的人气排行
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<Info> getHitInfoBySubjectId(Long subjectId, int size) {
		final Long infoTypeId = 49L;
		ParamCondition cond = new ParamCondition();
		cond.addParameter("subjectId", subjectId + "");
		cond.addParameter("infoTypeId", infoTypeId + "");
		cond.addParameter("OrderByHits", "DESC");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);
		return infos;
	}

	/**
	 * 专题活动
	 * 
	 * @param subjectId
	 * @return
	 */
	public Info getEventBySubjectId(Long subjectId) {
		final Long infoTypeId = 50L;
		int size = 1;

		ParamCondition cond = new ParamCondition();
		cond.addParameter("subjectId", subjectId + "");
		cond.addParameter("infoTypeId", infoTypeId + "");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		if (infos != null && !infos.isEmpty()) {
			Info info = infos.get(0);

			List<InfoImg> imgs = infoImgService.getInfoImgByInfoId(info.getId());
			info.setInfoImgs(imgs);

			// 提取主图
			for (InfoImg img : imgs) {
				if (img.getIsMainImg()) {
					info.setMainImg(img);
					break;
				}
			}

			return info;
		}

		return null;
	}

	/**
	 * 专题视频
	 * 
	 * @param subjectId
	 * @return
	 */
	public List<Info> getVideoBySubjectId(Long subjectId, int size) {
		final Long infoTypeId = 51L;

		ParamCondition cond = new ParamCondition();
		cond.addParameter("subjectId", subjectId + "");
		cond.addParameter("infoTypeId", infoTypeId + "");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		for (Info info : infos) {
			List<InfoImg> imgs = infoImgService.getInfoImgByInfoId(info.getId());
			info.setInfoImgs(imgs);

			// 提取主图
			for (InfoImg img : imgs) {
				if (img.getIsMainImg()) {
					info.setMainImg(img);
					break;
				}
			}
		}

		return infos;
	}

	/**
	 * 相关资讯信息
	 * 
	 * @param subjectId
	 * @param size
	 * @return
	 */
	public List<Info> getRelationInfos(Long subjectId, int size) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("notSubjectId", subjectId + "");
		cond.addParameter("isImgInfo", "true");
		List<Info> infos = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		for (Info info : infos) {
			List<InfoImg> imgs = infoImgService.getInfoImgByInfoId(info.getId());
			info.setInfoImgs(imgs);

			// 提取主图
			for (InfoImg img : imgs) {
				if (img.getIsMainImg()) {
					info.setMainImg(img);
					break;
				}
			}
		}

		return infos;
	}
}
