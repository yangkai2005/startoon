package org.j2eeframework.information.web.actions.information.hrservice;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.HrLimitService;
import org.j2eeframework.information.service.JobRefEmployeeService;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.information.service.TalentService;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.ImageUtil;
import org.j2eeframework.startoon.util.Struts2Utils;

public class TalentAction extends ServiceBaseManageAction<Talent, Long> {

	private static final Log log = LogFactory.getLog(TalentAction.class);

	private static final long serialVersionUID = -8122245584799468987L;
	@Resource
	private TalentService talentService;
	@Resource
	private JobRefEmployeeService jobRefEmployeeService;
	@Resource
	private JobsService jobsService;
	@Resource
	private HrLimitService hrLimitService;

	private Talent talent;
	private Long jobId;
	private Enterprise enterprise;
	private Long enterpriseId;
	private InfoType infoType = new InfoType();
	private Integer flag;

	/*
	 * 头像
	 */
	private File upload;
	private String uploadFileName;

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

		infoType.setId(48L);

		enterprise = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
		enterpriseId = enterprise != null ? enterprise.getId() : null;
	}

	@Override
	public String edit() {
		talent = talentService.getTalentByCreatorId(enterpriseId);
		return super.edit();
	}

	@Override
	public String insert() {

		String path = null;
		if (upload != null) {
			path = ImageUtil.storeSmallImg(upload, uploadFileName, 150, 150);
			getModel().setAvatar(path);
		}

		getModel().setCreator(enterprise);
		getGenericService().saveOrUpdate(getModel());
		flag = 0;
		return edit();
	}

	@Override
	public String update() {
		String path = null;
		if (upload != null) {
			path = ImageUtil.storeSmallImg(upload, uploadFileName, 150, 150);
			getModel().setAvatar(path);
		}

		getModel().setCreator(enterprise);
		getGenericService().saveOrUpdate(getModel());
		flag = 0;
		return edit();
	}

	@Override
	public String show() {

		if (Struts2Utils.getSession().getAttribute(SystemVariables.ADMIN_USER) != null) {
			return super.show();
		}

		if (enterprise == null) { // 没有登录
			flag = 1;
			return ResultConstants.ERROR;
		}

		if (enterprise.getUserType().intValue() != Enterprise.USER_TYPE_ENTERPRISE.intValue()) { // 不是企业会员
			flag = 2;
			return ResultConstants.ERROR;
		}

		boolean canView = hrLimitService.canViewResume(enterpriseId);

		if (!canView) { // 超过最大限制
			flag = 3;
			return ResultConstants.ERROR;
		}

		hrLimitService.increaseViewResumeCount(enterpriseId);

		return super.show();
	}

	public String adminView() {
		AdminUser admin = (AdminUser) Struts2Utils.getSession().getAttribute(SystemVariables.ADMIN_USER);
		if (admin != null) {
			return ResultConstants.SHOW;
		}

		return "global_forbidden";
	}

	public Talent getTalent() {
		return talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
