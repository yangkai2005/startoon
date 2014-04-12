package org.j2eeframework.information.web.actions.admin.information.video;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
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
import org.j2eeframework.information.service.InfoImgService;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ImageUtil;
import org.j2eeframework.startoon.util.ScaleImage;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {

	private static final long serialVersionUID = 4627299948500059879L;

	private static final Log log = LogFactory.getLog(InfoAction.class);

	@Resource
	private InfoService infoService;
	@Resource
	private InfoImgService infoImgService;

	private Info info;

	/*
	 * 上传图片和相关内容
	 */
	private File imgUpload;
	private String imgUploadFileName;

	/*
	 * 上传视频和相关内容
	 */
	private File videoUpload;
	private String videoUploadFileName;
	private String videoPath; // 视频链接地址
	private Integer videoType; // 视频类型 0：视频链接；1：视频文件

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

	}

	@Override
	public String input() {
		videoType = 0;
		return super.input();
	}

	@Override
	public String edit() {
		Long infoId = info.getId();
		InfoImg video = infoImgService.getVideoByInfoId(infoId);
		if (video != null) {
			videoPath = video.getVideoPath();
			videoType = video.getVideoType();
			info.setMainImg(video);
		}

		return super.edit();
	}

	@Override
	public String insert() {

		AdminUser user = SysContext.getCurrentAdminUser();

		info.setCreator(user.getId());
		info.setCreatorName(user.getName());
		info.setCreatorType(Info.CREATOR_TYPE_ADMIN);
		info.setStatus(Info.STATUS_AUDIT_PASS);
		info.setCategory(Info.CATEGORY_VIDEO);

		getGenericService().insert(info);

		// begin 处理图片
		ScaleImage scaleImage = new ScaleImage();
		File upl = imgUpload;
		String uplName = imgUploadFileName;

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

		// 处理视频文件
		InfoImg infoImg = new InfoImg();
		infoImg.setInfo(info);
		infoImg.setImgUrl(fileItemInfo.getFileId());
		infoImg.setSmallImgUrl(uniqueFileName);
		infoImg.setName(uplName);
		infoImg.setIsMainImg(true);
		infoImg.setIsVideo(true);

		if (videoUpload != null) {
			String videoExt = FilenameUtils.getExtension(videoUploadFileName);
			String videFileName = FileNameUtil.getUniqueFileName(videoExt);
			String videoFullPath = SystemConfig.UPLOAD_VIDEO_DIR + "/" + videFileName;
			File destFile = new File(videoFullPath);
			try {
				FileUtils.copyFile(videoUpload, destFile);
			} catch (IOException e) {
				log.error("处理上传视频出错", e);
			}

			log.debug("视频存放路径：" + videoFullPath);

			infoImg.setVideoType(1); // 视频文件
			infoImg.setVideoPath(videFileName);

		} else {
			infoImg.setVideoType(0); // 视频链接
			infoImg.setVideoPath(videoPath);
		}

		infoImgService.insert(infoImg);

		// end 处理图片

		return ResultConstants.LIST;
	}

	@Override
	public String update() {

		getGenericService().update(getModel());

		InfoImg infoImg = infoImgService.getVideoByInfoId(info.getId());

		// 处理图片
		String normalImg = null;
		String smallImg = null;
		if (imgUpload != null) {
			normalImg = ImageUtil.storeNormalImg(imgUpload, imgUploadFileName);
			smallImg = ImageUtil.storeSmallImg(imgUpload, imgUploadFileName);

			infoImg.setImgUrl(normalImg);
			infoImg.setSmallImgUrl(smallImg);

			log.debug("原图：" + normalImg + "\n缩略图：" + smallImg);
		}

		// 处理视频文件
		infoImg.setName(imgUploadFileName);

		if (videoUpload != null) {
			String videoExt = FilenameUtils.getExtension(videoUploadFileName);
			String videFileName = FileNameUtil.getUniqueFileName(videoExt);
			String videoFullPath = SystemConfig.UPLOAD_VIDEO_DIR + "/" + videFileName;
			File destFile = new File(videoFullPath);
			try {
				FileUtils.copyFile(videoUpload, destFile);
			} catch (IOException e) {
				log.error("处理上传视频出错", e);
			}

			log.debug("视频存放路径：" + videoFullPath);

			infoImg.setVideoType(1); // 视频文件
			infoImg.setVideoPath(videFileName);

		} else {
			infoImg.setVideoType(0); // 视频链接
			infoImg.setVideoPath(videoPath);
		}

		infoImgService.update(infoImg);

		// end 处理图片

		return ResultConstants.LIST;

	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public File getImgUpload() {
		return imgUpload;
	}

	public void setImgUpload(File imgUpload) {
		this.imgUpload = imgUpload;
	}

	public String getImgUploadFileName() {
		return imgUploadFileName;
	}

	public void setImgUploadFileName(String imgUploadFileName) {
		this.imgUploadFileName = imgUploadFileName;
	}

	public File getVideoUpload() {
		return videoUpload;
	}

	public void setVideoUpload(File videoUpload) {
		this.videoUpload = videoUpload;
	}

	public String getVideoUploadFileName() {
		return videoUploadFileName;
	}

	public void setVideoUploadFileName(String videoUploadFileName) {
		this.videoUploadFileName = videoUploadFileName;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public Integer getVideoType() {
		return videoType;
	}

	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}

}
