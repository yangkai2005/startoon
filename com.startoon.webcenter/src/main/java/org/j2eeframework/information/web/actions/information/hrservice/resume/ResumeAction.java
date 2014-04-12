package org.j2eeframework.information.web.actions.information.hrservice.resume;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.entity.Resume;
import org.j2eeframework.information.service.JobRefEmployeeService;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.information.service.ResumeService;
import org.j2eeframework.startoon.commons.SystemConfig;

public class ResumeAction extends ServiceBaseManageAction<Resume, Long> {
	private static final long serialVersionUID = -8385420670418894355L;

	private static final Log log = LogFactory.getLog(ResumeAction.class);

	@Resource
	private ResumeService resumeService;
	@Resource
	private JobsService jobsService;
	@Resource
	private JobRefEmployeeService jobRefEmployeeService;

	private Resume resume;

	private Jobs currentJob;

	private Long jid;

	private File upload;
	private String uploadFileName;

	@Override
	public IGenericService<Resume, Long> getGenericService() {
		return resumeService;
	}

	public Resume getModel() {
		return resume;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			resume = new Resume();
		} else {
			resume = resumeService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {

		currentJob = jobsService.getEntityById(jid);

		return ResultConstants.INPUT;
	}

	@Override
	public String insert() {

		//begin 处理图片
		log.debug("上传简历处理...");
		if (upload != null) {

			File upl = upload;
			String uplName = uploadFileName;

			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

			resume.setResumeUrl(fileItemInfo.getFileId());

		}
		//end 处理图片

		getGenericService().insert(resume);

		jobRefEmployeeService.addResumeRef(resume.getJobs().getId(), resume.getId());

		return SUCCESS;

	}

	public Long getJid() {
		return jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Jobs getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(Jobs currentJob) {
		this.currentJob = currentJob;
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
