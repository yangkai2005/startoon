package org.j2eeframework.startoon.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IPostedProDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.PostedPro;
import org.springframework.stereotype.Service;

@Service
public class PostedProService extends AbstractService<PostedPro, Long, IPostedProDAO> {
	private static final Log log = LogFactory.getLog(PostedProService.class);

	@Resource
	private IPostedProDAO postedProDAO;
	@Resource
	private CategoryService categoryService;

	@Override
	public IPostedProDAO getGenericDAO() {
		return postedProDAO;
	}

	/**
	 * 删除多条记录
	 * 
	 * @author zhousp
	 * @param ids : ID集体(如：1,2)
	 */
	public void deleteMuti(String ids) {

		if (ids != null && StringUtils.isNotBlank(ids)) {
			String[] arr = ids.split(",");
			for (String id : arr) {
				PostedPro p = getGenericDAO().getEntityById(new Long(id));
				p.setStatus(PostedPro.Status.deleted.ordinal());
				getGenericDAO().update(p);
			}
		} else {
			log.error("ids为空，不能删除！");
		}
	}

	/**
	 * 最新采购
	 * @param size
	 * @return
	 */
	public List<PostedPro> getLatestPostedPro(int size) {

		ParamCondition condition = new ParamCondition();
		condition.addParameter("orderBy", "id");
		condition.addParameter("orderType", "desc");

		int offset = 0;
		List<PostedPro> postedPros = postedProDAO.getEntitiesByParamCondition(condition, offset, size);

		return postedPros;

	}

	/**
	 * 获取相关采购
	 * @param postedPro
	 * @param size
	 * @return
	 */
	public List<PostedPro> getRelationPostedPros(PostedPro postedPro, int size) {

		Long categoryId = null;

		Pager<PostedPro> pager = new Pager<PostedPro>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("orderBy", "id");
		pager.getParamCondition().addParameter("orderType", "desc");
		if (postedPro != null && postedPro.getCategory() != null) {
			categoryId = postedPro.getCategory().getId();
			pager.getParamCondition().addParameter("categoryId", categoryId + ""); //同类别
		}

		getEntitiesOfPagerByParamCondition(pager);

		return pager.getItems();
	}

	public List<PostedPro> getPostedProByTime(Long cid, Date start, Date end, int size) {

		int offset = 0;

		ParamCondition condition = new ParamCondition();

		// 出来类别和所有的子类别
		List<Category> categories = categoryService.getAllSubCategory(cid);
		String idStr = null;
		if (categories != null && categories.size() > 0) {
			String[] ids = new String[categories.size()];
			int i = 0;
			for (Category c : categories) {
				ids[i] = c.getId() + "";
				idStr += ids[i] + ",";
				i++;
			}
			log.debug(">>>类别和所有的字类别ID：" + idStr);
			condition.addParameterValues("categoryIds", ids);
		}

		condition.addParameter("startCreateTime", start.getTime() + "");
		condition.addParameter("endCreateTime", end.getTime() + "");

		List<PostedPro> postedPros = postedProDAO.getEntitiesByParamCondition(condition, offset, size);

		return postedPros;
	}

}
