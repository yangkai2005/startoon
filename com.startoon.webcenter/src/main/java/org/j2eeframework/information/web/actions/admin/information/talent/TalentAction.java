package org.j2eeframework.information.web.actions.admin.information.talent;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.TalentService;

public class TalentAction extends ServiceBaseManageAction<Talent, Long> {
	private static final long serialVersionUID = -6416121234452399449L;
	@Resource
	private TalentService talentService;
	private Talent talent;

	private List<Long> ids;
	private String desc;
	private Integer state;

	@Override
	public IGenericService<Talent, Long> getGenericService() {
		return talentService;
	}

	public Talent getModel() {
		return talent;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			talent = new Talent();
		} else {
			talent = talentService.getEntityById(getRequestId());
		}
	}

	public String freeze() {
		String freezeDesc = state == 1 ? desc : "";
		for (Long id : ids) {
			Talent t = getGenericService().getEntityById(id);
			t.setState(state);
			t.setFreezeDesc(freezeDesc);
			getGenericService().update(t);
		}

		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
