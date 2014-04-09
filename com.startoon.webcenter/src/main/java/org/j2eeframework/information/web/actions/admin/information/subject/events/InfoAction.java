package org.j2eeframework.information.web.actions.admin.information.subject.events;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.Subject;
import org.j2eeframework.information.service.InfoImgService;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.SubjectService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.util.ImageUtil;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	private static final long serialVersionUID = 6331539449706714936L;

	@Resource
	private InfoService infoService;

	@Resource
	private InfoImgService infoImgService;

	@Resource
	private SubjectService subjectService;

	private Info info;

	private List<Subject> subjects;

	private Long subjectId;

	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> description;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	public Info getModel() {
		return info;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			info = new Info();
		} else {
			info = infoService.getEntityById(getRequestId());
		}

		if (subjectId != null && subjectId != 0) {
			Subject sub = new Subject();
			sub.setId(subjectId);
			info.setSubject(sub);
		}
		subjects = subjectService.getAllEntity();

	}

	@Override
	public String insert() {

		AdminUser user = SysContext.getCurrentAdminUser();

		info.setCreator(user.getId());
		info.setCreatorName(user.getName());
		info.setCreatorType(Info.CREATOR_TYPE_ADMIN);

		info.setStatus(Info.STATUS_AUDIT_PASS);

		super.insert();

		// begin 处理图片
		if (upload != null && !upload.isEmpty()) {
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				String normalImg = ImageUtil.storeNormalImg(upl, uplName);
				String smallImg = ImageUtil.storeSmallImg(upl, uplName);

				InfoImg infoImg = new InfoImg();
				infoImg.setInfo(info);
				infoImg.setImgUrl(normalImg);
				infoImg.setSmallImgUrl(smallImg);
				infoImg.setName(uplName);
				infoImg.setDescription(description.get(i));
				infoImg.setIsMainImg(i == 0);

				infoImgService.insert(infoImg);

			}
		}

		// end 处理图片

		return ResultConstants.LIST;
	}

	@Override
	public String update() {

		super.update();

		// begin 处理图片
		if (upload != null && !upload.isEmpty()) {

			// 在有新图的上传时，更新主图
			InfoImg img = infoImgService.getInfoMainImg(getRequestId());
			if (img != null) {
				img.setIsMainImg(false);
				infoImgService.update(img);
			}

			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				String normalImg = ImageUtil.storeNormalImg(upl, uplName);
				String smallImg = ImageUtil.storeSmallImg(upl, uplName);

				InfoImg infoImg = new InfoImg();
				infoImg.setInfo(info);
				infoImg.setImgUrl(normalImg);
				infoImg.setSmallImgUrl(smallImg);
				infoImg.setName(uplName);
				infoImg.setDescription(description.get(i));
				infoImg.setIsMainImg(i == 0);

				infoImgService.insert(infoImg);

			}
		}

		// end 处理图片

		return ResultConstants.LIST;
	}

	@Override
	public String edit() {

		Long id = info.getId();

		List<InfoImg> imgs = infoImgService.getInfoImgByInfoId(id);
		info.setInfoImgs(imgs);

		subjectId = info.getSubject() != null ? info.getSubject().getId() : 0L;

		return super.edit();
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

}
