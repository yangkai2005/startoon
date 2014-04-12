package org.j2eeframework.information.web.actions.admin.information.subject.news;

import java.io.File;
import java.util.List;

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
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Subject;
import org.j2eeframework.information.service.InfoImgService;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;
import org.j2eeframework.information.service.SubjectService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ScaleImage;

/**
 * 
 * 新闻发布处理类
 * 
 * @author yangkai
 * 
 */
public class InfoAction extends ServiceBaseManageAction<Info, Long> {

	private static final long serialVersionUID = -2515333655624697057L;

	private static final Log log = LogFactory.getLog(InfoAction.class);

	@Resource
	private InfoService infoService;

	@Resource
	private InfoTypeService infoTypeService;

	@Resource
	private InfoImgService infoImgService;
	@Resource
	private SubjectService subjectService;

	private Info info;

	private Long tid;

	private Integer focus;

	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> description;

	/*
	 * 类别ID
	 */
	private Long typeId;

	private List<InfoType> infoTypes;
	private List<Subject> subjects;
	private Long subjectId;

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

		infoTypes = infoTypeService.getInfoTypeByFatherId(2L);
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
			ScaleImage scaleImage = new ScaleImage();
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				IFileSystem fileSystem = new LocalFileSystem();
				String extension = FilenameUtils.getExtension(uplName);
				FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

				// 生产缩略图
				String uniqueFileName = FileNameUtil.getUniqueFileName(extension);
				String fullPath = SystemConfig.UPLOAD_FILE_DIR + "/" + uniqueFileName;
				File targetFile = new File(fullPath);
				try {
					scaleImage.saveImageAsJpg(upl, targetFile, SystemConfig.IMAGE_ABBREVIATIVE_WIDTH, SystemConfig.IMAGE_ABBREVIATIVE_HEIGHT);
				} catch (Exception e) {
					e.printStackTrace();
					log.error("生成缩略图失败：", e);
				}

				log.debug("原图：" + fileItemInfo.getFileId() + "\n缩略图：" + fullPath);

				InfoImg infoImg = new InfoImg();
				infoImg.setInfo(info);
				infoImg.setImgUrl(fileItemInfo.getFileId());
				infoImg.setSmallImgUrl(uniqueFileName);
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

			ScaleImage scaleImage = new ScaleImage();
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				IFileSystem fileSystem = new LocalFileSystem();
				String extension = FilenameUtils.getExtension(uplName);
				FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

				// 生产缩略图
				String uniqueFileName = FileNameUtil.getUniqueFileName(extension);
				String fullPath = SystemConfig.UPLOAD_FILE_DIR + "/" + uniqueFileName;
				File targetFile = new File(fullPath);
				try {
					scaleImage.saveImageAsJpg(upl, targetFile, SystemConfig.IMAGE_ABBREVIATIVE_WIDTH, SystemConfig.IMAGE_ABBREVIATIVE_HEIGHT);
				} catch (Exception e) {
					e.printStackTrace();
					log.error("生成缩略图失败：", e);
				}

				log.debug("原图：" + fileItemInfo.getFileId() + "\n缩略图：" + fullPath);

				InfoImg infoImg = new InfoImg();
				infoImg.setInfo(info);
				infoImg.setImgUrl(fileItemInfo.getFileId());
				infoImg.setSmallImgUrl(uniqueFileName);
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

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public List<InfoType> getInfoTypes() {
		return infoTypes;
	}

	public void setInfoTypes(List<InfoType> infoTypes) {
		this.infoTypes = infoTypes;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getFocus() {
		return focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

}
