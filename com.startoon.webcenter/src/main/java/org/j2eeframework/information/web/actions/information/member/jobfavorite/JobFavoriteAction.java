package org.j2eeframework.information.web.actions.information.member.jobfavorite;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.JobFavorite;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobFavoriteService;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.Struts2Utils;

public class JobFavoriteAction extends ServiceBaseManageAction<JobFavorite, Long> {

	private static final long serialVersionUID = -1661993693045156702L;

	private static final Log log = LogFactory.getLog(JobFavoriteAction.class);

	@Resource
	private JobFavoriteService jobFavoriteService;
	private JobFavorite jobFavorite;

	private Long jid;

	@Override
	public IGenericService<JobFavorite, Long> getGenericService() {
		return jobFavoriteService;
	}

	public JobFavorite getModel() {
		return jobFavorite;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			jobFavorite = new JobFavorite();
		} else {
			jobFavorite = jobFavoriteService.getEntityById(getRequestId());
		}
	}

	public String add() {
		JSONObject json = new JSONObject();

		Jobs jobs = new Jobs();
		jobs.setId(jid);

		Enterprise owner = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);

		if (owner == null) {
			json.put("result", 2);
			json.put("message", "unlogin");
		}

		Long uid = owner.getId();
		int count = jobFavoriteService.getCountByLogicId(jid, uid);

		if (count > 0) {
			json.put("result", 1);
			json.put("message", "existd");
		} else {
			JobFavorite jf = new JobFavorite();
			jf.setCtime(new Date());
			jf.setJob(jobs);
			jf.setOwner(owner);

			getGenericService().insert(jf);

			json.put("result", 0);
			json.put("message", "");

		}

		Struts2Utils.renderJson(json);

		log.debug(json);

		return null;
	}

	@Override
	public String delete() {

		Enterprise owner = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);

		if (owner.getId() == getModel().getOwner().getId()) {
			super.delete();
		}

		return ResultConstants.LIST;
	}

	public Long getJid() {
		return jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}

}
