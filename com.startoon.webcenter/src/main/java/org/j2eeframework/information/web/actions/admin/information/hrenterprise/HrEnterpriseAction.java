package org.j2eeframework.information.web.actions.admin.information.hrenterprise;

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
import org.j2eeframework.information.entity.HrEnterprise;
import org.j2eeframework.information.service.HrEnterpriseService;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ScaleImage;

public class HrEnterpriseAction extends ServiceBaseManageAction<HrEnterprise, Long> {
	
	private static final long serialVersionUID = -5993994979355581614L;
	
	private static final Log log = LogFactory.getLog(HrEnterpriseAction.class);
	
	@Resource
	private HrEnterpriseService hrEnterpriseService;
	
	private HrEnterprise hrEnterprise;
	
	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
    private List<String> uploadFileName;
	
	@Override
	public IGenericService<HrEnterprise, Long> getGenericService() {
		return hrEnterpriseService;
	}

	public HrEnterprise getModel() {
		return hrEnterprise;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			hrEnterprise = new HrEnterprise();
		} else {
			hrEnterprise = hrEnterpriseService.getEntityById(getRequestId());
		}
	}

	@Override
	public String insert() {
		
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
				
				hrEnterprise.setSlogo(uniqueFileName);
				hrEnterprise.setLogo(fileItemInfo.getFileId());
				
			}
		}
		
		super.insert();
		
		//end 处理图片
		
		return ResultConstants.LIST;
	}

	public HrEnterprise getHrEnterprise() {
		return hrEnterprise;
	}

	public void setHrEnterprise(HrEnterprise hrEnterprise) {
		this.hrEnterprise = hrEnterprise;
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
	
}
