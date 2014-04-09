package org.j2eeframework.information.web.actions.admin.information.advertisement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.j2eeframework.information.entity.Advertisement;
import org.j2eeframework.information.service.AdvertisementService;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.util.FileNameUtil;
import org.j2eeframework.startoon.util.ScaleImage;

public class AdvertisementAction extends ServiceBaseManageAction<Advertisement,Long>
{
	private static final long serialVersionUID = -8001294545439583908L;
	
	private static final Log log = LogFactory.getLog(AdvertisementAction.class);
	
	@Resource
	private AdvertisementService advertisementService;
	private Advertisement advertisement;
	
	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
    private List<String> uploadFileName;
	private List<String> description;
	
	@Override
	public IGenericService<Advertisement, Long> getGenericService()
	{
		return advertisementService;
	}

	public Advertisement getModel()
	{
		return advertisement;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			advertisement = new Advertisement();
		} else
		{
			advertisement = advertisementService.getEntityById(getRequestId());
		}
	}
	
	public String input1() {
		return super.input();
	}

	@Override
	public String edit() {
		if(getRequestId()==216) {
			setNextMethod("modify");
			return "input1";
		}
		return super.edit();
	}
	
	@Override
	public String update() {
		
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
				
				advertisement.setSmallAdImgUrl(uniqueFileName);
				advertisement.setNormalAdImgUrl(fileItemInfo.getFileId());
				
				
			}
		}
		
		advertisementService.update(advertisement);
		
		//end 处理图片
		
		return ResultConstants.LIST;
	}
	
	/**
	 * 更新B2B首页的flash广告
	 * @return
	 * @throws IOException 
	 */
	public String modify() throws IOException {
		
		if(upload!=null && !upload.isEmpty()) {
			String flashFile = SystemConfig.ROOT_PATH + File.separator + "ban.swf";
			InputStream in = new FileInputStream(upload.get(0));
			OutputStream out = new FileOutputStream(flashFile);
			org.apache.commons.io.IOUtils.copy(in, out);
		}
		
		advertisementService.update(advertisement);
		
		return ResultConstants.LIST;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
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

}
