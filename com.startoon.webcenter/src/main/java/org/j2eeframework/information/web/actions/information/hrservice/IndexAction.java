package org.j2eeframework.information.web.actions.information.hrservice;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.information.entity.HrEnterprise;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.HrEnterpriseService;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.information.service.TalentService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8988240220551388808L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService infoService;
	@Resource
	private TalentService talentService;
	@Resource
	private JobsService jobsService;
	@Resource
	private HrEnterpriseService hrEnterpriseService;

	private List<Info> info45; //人才工作站
	private List<Info> info46; //教育培训

	private List<Talent> talents;
	private List<Jobs> jobs;

	private InfoType infoType;

	private List<HrEnterprise> hrents; // 名企招聘

	@Override
	public String execute() {

		log.debug("人才服务首页...");

		infoType = new InfoType();
		infoType.setId(11L);

		talents = talentService.getLatestTalent(16);
		info45 = getHrServiceInfo(45L, 10);
		info46 = getHrServiceInfo(46L, 10);

		jobs = jobsService.getLatestJobsBySize(21);

		hrents = hrEnterpriseService.getHrEnterpriseBySize(35);

		return SUCCESS;

	}

	private List<Info> getHrServiceInfo(Long infoTypeId, int count) {

		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(count);
		pager.getParamCondition().addParameter("status", "6");
		pager.getParamCondition().addParameter("infoTypeId", infoTypeId + "");
		infoService.getEntitiesOfPagerByParamCondition(pager);

		return pager.getItems();

	}

	public List<Info> getInfo45() {
		return info45;
	}

	public void setInfo45(List<Info> info45) {
		this.info45 = info45;
	}

	public List<Info> getInfo46() {
		return info46;
	}

	public void setInfo46(List<Info> info46) {
		this.info46 = info46;
	}

	public List<Talent> getTalents() {
		return talents;
	}

	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}

	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public List<HrEnterprise> getHrents() {
		return hrents;
	}

	public void setHrents(List<HrEnterprise> hrents) {
		this.hrents = hrents;
	}

}
