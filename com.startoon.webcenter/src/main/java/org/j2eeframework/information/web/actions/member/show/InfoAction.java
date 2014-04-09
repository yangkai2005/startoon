package org.j2eeframework.information.web.actions.member.show;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoImgService;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ScaleImage;

/**
 * 
 * 新闻发布处理类
 * @author yangkai
 *
 */
public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 889404922257666812L;

	private static final Log log = LogFactory.getLog(InfoAction.class);
	
	@Resource
	private InfoService infoService;
	
	@Resource
	private InfoImgService infoImgService;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	
	private Info info;
	
	private Long tid;

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
	public String insert() {
		
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		
		log.debug("发布创意show[id:" + + user.getId() + "|account:" + user.getAccount() + "]");
		
		info.setCreator(user.getId());
		info.setCreatorName(user.getNickname());
		info.setCreatorType(0);
		info.setStatus(Info.STATUS_UNAUDIT);
		
		
		super.insert();
		
		//begin 处理图片
		if(upload!=null && !upload.isEmpty()) {
			ScaleImage scaleImage = new ScaleImage();
			int size = upload.size();
			for(int i=0; i<size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);
				
				IFileSystem fileSystem = new LocalFileSystem();
				String extension = FilenameUtils.getExtension(uplName);
				FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);
				
				//生产缩略图
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
				infoImg.setIsMainImg(i==0);
				
				infoImgService.insert(infoImg);
				
			}
		}
		
		//end 处理图片
		
		return ResultConstants.LIST;
	}

	public String apply() {

		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			
			Enterprise user = SysContext.getCurrentEnterpriserUser();
			user = enterpriseService.getEntityById(user.getId());
			user.setIsShow(1);
			enterpriseService.update(user);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("success");
			out.flush();
			log.debug("==>申请成为创意show会员[" + user.getAccount() + "]");
		} catch (IOException e) {
			log.error(e);
		}
		
		return null;
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
	
	
}
