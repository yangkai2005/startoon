package org.j2eeframework.information.web.actions.admin.information.attachment;

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
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Attachment;
import org.j2eeframework.information.entity.AttachmentType;
import org.j2eeframework.information.service.AttachmentService;
import org.j2eeframework.information.service.AttachmentTypeService;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ScaleImage;

public class AttachmentAction extends ServiceBaseManageAction<Attachment, Long> {

	private static final long serialVersionUID = 2968603600377767462L;
	private static final Log log = LogFactory.getLog(AttachmentAction.class);
	@Resource
	private AttachmentService attachmentService;
	@Resource
	private AttachmentTypeService attachmentTypeService;

	private Attachment attachment;
	private List<AttachmentType> attachmentTypes;
	private Long typeId;

	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
	private List<String> uploadFileName;

	private File img;
	private String imgFileName;

	@Override
	public IGenericService<Attachment, Long> getGenericService() {
		return attachmentService;
	}

	public Attachment getModel() {
		return attachment;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			attachment = new Attachment();
		} else {
			attachment = attachmentService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {
		attachmentTypes = attachmentTypeService.getAllEntity();
		return super.input();
	}

	@Override
	public String edit() {
		attachmentTypes = attachmentTypeService.getAllEntity();
		typeId = getModel().getAttachmentType().getId();
		return super.edit();
	}

	@Override
	public String insert() {

		// begin 处理文件
		if (upload != null && !upload.isEmpty()) {
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				IFileSystem fileSystem = new LocalFileSystem();
				String extension = FilenameUtils.getExtension(uplName);
				FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

				attachment.setDataPath(fileItemInfo.getFileId());
				attachment.setDataName(uplName);
				attachment.setFormat(extension);
				attachment.setFilesize(upl.length());
			}
		}
		// end 处理文件

		// begin 图片
		if (img != null) {
			File upl = img;
			String uplName = imgFileName;

			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

			// 生产缩略图
			String uniqueFileName = FileNameUtil.getUniqueFileName(extension);
			String fullPath = SystemConfig.UPLOAD_FILE_DIR + "/" + uniqueFileName;
			File targetFile = new File(fullPath);
			try {
				ScaleImage scaleImage = new ScaleImage();
				scaleImage.saveImageAsJpg(upl, targetFile, SystemConfig.IMAGE_ABBREVIATIVE_WIDTH, SystemConfig.IMAGE_ABBREVIATIVE_HEIGHT);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("生成缩略图失败：", e);
			}

			log.debug("原图：" + fileItemInfo.getFileId() + "\n缩略图：" + fullPath);

			attachment.setImgUrl(uniqueFileName);
		}
		// end 图片

		AttachmentType type = new AttachmentType();
		type.setId(typeId);
		attachment.setAttachmentType(type);

		return super.insert();

	}

	@Override
	public String update() {

		// begin 处理文件
		if (upload != null && !upload.isEmpty()) {
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				IFileSystem fileSystem = new LocalFileSystem();
				String extension = FilenameUtils.getExtension(uplName);
				FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

				attachment.setDataPath(fileItemInfo.getFileId());
				attachment.setDataName(uplName);
				attachment.setFormat(extension);
				attachment.setFilesize(upl.length());
			}
		}

		// begin 图片
		if (img != null) {
			File upl = img;
			String uplName = imgFileName;

			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

			// 生产缩略图
			String uniqueFileName = FileNameUtil.getUniqueFileName(extension);
			String fullPath = SystemConfig.UPLOAD_FILE_DIR + "/" + uniqueFileName;
			File targetFile = new File(fullPath);
			try {
				ScaleImage scaleImage = new ScaleImage();
				scaleImage.saveImageAsJpg(upl, targetFile, SystemConfig.IMAGE_ABBREVIATIVE_WIDTH, SystemConfig.IMAGE_ABBREVIATIVE_HEIGHT);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("生成缩略图失败：", e);
			}

			log.debug("原图：" + fileItemInfo.getFileId() + "\n缩略图：" + fullPath);

			attachment.setImgUrl(fullPath);
		}
		// end 图片

		AttachmentType type = new AttachmentType();
		type.setId(typeId);
		attachment.setAttachmentType(type);

		return super.update();
	}

	@Override
	public String delete() {
		return super.delete();
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public List<AttachmentType> getAttachmentTypes() {
		return attachmentTypes;
	}

	public void setAttachmentTypes(List<AttachmentType> attachmentTypes) {
		this.attachmentTypes = attachmentTypes;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
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

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

}
