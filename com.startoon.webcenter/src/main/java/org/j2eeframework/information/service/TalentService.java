package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.ITalentDAO;
import org.j2eeframework.information.entity.Talent;
import org.springframework.stereotype.Service;

@Service
public class TalentService extends AbstractService<Talent, Long, ITalentDAO> {
	@Resource
	private ITalentDAO talentDAO;

	@Override
	public ITalentDAO getGenericDAO() {
		return talentDAO;
	}

	public List<Talent> getLatestTalent(int size) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("state", "0");

		List<Talent> talents = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		return talents;

	}

	public Talent getTalentByCreatorId(Long creatorId) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("creatorId", creatorId + "");
		List<Talent> list = getGenericDAO().getEntitiesByParamCondition(cond, 0, 1);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;

	}

	/**
	 * 冻结简历
	 * 
	 * @param id
	 * @param desc
	 * @return
	 */
	public Talent freeze(Long id, String desc) {
		Talent talent = getGenericDAO().getEntityById(id);
		talent.setState(1); // 冻结
		talent.setFreezeDesc(desc);
		getGenericDAO().update(talent);
		return talent;
	}

	public void freeze(List<Long> ids, String desc) {
		for (Long id : ids) {
			freeze(id, desc);
		}
	}
}
