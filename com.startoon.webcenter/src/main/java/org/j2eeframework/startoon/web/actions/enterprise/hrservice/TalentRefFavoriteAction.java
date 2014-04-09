package org.j2eeframework.startoon.web.actions.enterprise.hrservice;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.TalentRefFavorite;
import org.j2eeframework.startoon.service.TalentRefFavoriteService;
import org.j2eeframework.startoon.util.Struts2Utils;

public class TalentRefFavoriteAction extends ServiceBaseManageAction<TalentRefFavorite, Long> {
	private static final long serialVersionUID = -8673240770532195930L;
	@Resource
	private TalentRefFavoriteService talentRefFavoriteService;
	private TalentRefFavorite talentRefFavorite;

	private Long tid;

	@Override
	public IGenericService<TalentRefFavorite, Long> getGenericService() {
		return talentRefFavoriteService;
	}

	public TalentRefFavorite getModel() {
		return talentRefFavorite;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			talentRefFavorite = new TalentRefFavorite();
		} else {
			talentRefFavorite = talentRefFavoriteService.getEntityById(getRequestId());
		}
	}

	public String add() {

		Enterprise ent = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);

		Talent talent = new Talent();
		talent.setId(tid);

		JSONObject json = new JSONObject();
		boolean exist = talentRefFavoriteService.exist(ent.getId(), tid);
		if (exist) {
			json.put("result", 1);
			json.put("message", "");
			Struts2Utils.renderJson(json);
			return null;
		}

		getModel().setCreator(ent);
		getModel().setTalent(talent);

		getGenericService().insert(talentRefFavorite);

		json.put("result", 0);
		json.put("message", "");

		Struts2Utils.renderJson(json);

		return null;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

}
