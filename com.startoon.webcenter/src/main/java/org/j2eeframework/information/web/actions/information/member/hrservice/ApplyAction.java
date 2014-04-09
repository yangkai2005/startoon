package org.j2eeframework.information.web.actions.information.member.hrservice;

import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.entity.ResumeRecord;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.JobRefEmployeeService;
import org.j2eeframework.information.service.ResumeRecordService;
import org.j2eeframework.information.service.TalentService;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.Struts2Utils;

import com.opensymphony.xwork2.ActionSupport;

public class ApplyAction extends ActionSupport {

	private static final long serialVersionUID = -4282066824164686051L;
	private static final Log log = LogFactory.getLog(ApplyAction.class);

	@Resource
	private JobRefEmployeeService jobRefEmployeeService;
	@Resource
	private TalentService talentService;
	@Resource
	private ResumeRecordService resumeRecordService;

	private Long jobId;

	@Override
	public String execute() {
		JSONObject json = new JSONObject();
		try {
			Enterprise employee = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
			Long creatorId = employee.getId();
			Talent talent = talentService.getTalentByCreatorId(creatorId);
			if (talent == null) { // 还未填写在线简历
				json.put("result", 2);
				Struts2Utils.renderJson(json);
				return null;
			}

			// 向企业发送应聘简历
			Long talentId = talent.getId();
			jobRefEmployeeService.addTalentRef(jobId, talentId);

			//添加应聘记录
			ResumeRecord record = new ResumeRecord();
			record.setCreator(employee);
			record.setCtime(new Date());
			Jobs job = new Jobs();
			job.setId(jobId);
			record.setJob(job);
			resumeRecordService.insert(record);

			json.put("result", 0);

		} catch (Exception e) {
			log.error(e);
			json.put("result", 1);
		} finally {
			Struts2Utils.renderJson(json);
		}

		log.debug(json);

		return null;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
}
