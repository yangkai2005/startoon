package org.j2eeframework.information.web.actions.admin.information.subject.video;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ImageUtil;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {

	private static final long serialVersionUID = 4627299948500059879L;

	private static final Log log = LogFactory.getLog(InfoAction.class);

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

		if (subjectId != null && subjectId != 0) {
			Subject sub = new Subject();
			sub.setId(subjectId);
			info.setSubject(sub);
		}

		subjects = subjectService.getAllEntity();

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

		subjectId = info.getSubject() != null ? info.getSubject().getId() : 0L;

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

		InfoImg infoImg = new InfoImg();

		// begin 处理图片
		String normalImg = null;
		String smallImg = null;
		if (imgUpload != null) {
			normalImg = ImageUtil.storeNormalImg(imgUpload, imgUploadFileName);
			smallImg = ImageUtil.storeSmallImg(imgUpload, imgUploadFileName);

			infoImg.setImgUrl(normalImg);
			infoImg.setSmallImgUrl(smallImg);

			infoImg.setInfo(info);
			infoImg.setImgUrl(normalImg);
			infoImg.setSmallImgUrl(smallImg);
			infoImg.setName(imgUploadFileName);
			infoImg.setIsMainImg(true);
			infoImg.setIsVideo(true);
		}

		// 处理视频文件
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
		infoImg = infoImg == null ? new InfoImg() : infoImg;
		infoImg.setInfo(getModel());
		// 处理图片
		String normalImg = null;
		String smallImg = null;
		if (imgUpload != null) {
			normalImg = ImageUtil.storeNormalImg(imgUpload, imgUploadFileName);
			smallImg = ImageUtil.storeSmallImg(imgUpload, imgUploadFileName);

			infoImg.setImgUrl(normalImg);
			infoImg.setSmallImgUrl(smallImg);
			infoImg.setName(imgUploadFileName);

			log.debug("原图：" + normalImg + "\n缩略图：" + smallImg);
		}

		// 处理视频文件

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

		infoImgService.saveOrUpdate(infoImg);

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

}
