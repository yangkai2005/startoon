package org.j2eeframework.startoon.web.actions.enterprise.entinfo;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.Cert;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CertService;

public class EntInfoCertAction extends ServiceBaseManageAction<Cert, Long> {
	private static final long serialVersionUID = -1907579144416831014L;
	@Resource
	private CertService certService;
	private Cert cert;
	private File upload;
	private String uploadFileName;
	private boolean success;

	@Override
	public IGenericService<Cert, Long> getGenericService() {
		return certService;
	}

	public Cert getModel() {
		return cert;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			cert = new Cert();
		} else {
			cert = certService.getEntityById(getRequestId());
		}
	}

	//-- user method
	
	@Override
	public String insert() {
		
		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		
		IFileSystem fileSystem = new LocalFileSystem();
		String extension = FilenameUtils.getExtension(uploadFileName);
		FileItemInfo fileItemInfo = fileSystem.saveFile(upload, extension, SystemConfig.UPLOAD_FILE_DIR);
		
		cert.setEnterprise(ent);
		cert.setCertImg(fileItemInfo.getFileId());
		
		super.insert();
		
		success = true;
		
		return "success" ;
		
	}

	/**
	 * 修改认证
	 * 
	 * 
	 * @return
	 */
	@Override
	public String update() {
		
		certService.update(cert);
		
		return "success";
	}
	/**删除数据
	 * @return
	 */
	 public String delete()
	 {
		 getGenericService().delete(getModel());
		 return  "detele"; 
	 }
	//--- sgetter and setter
	public Cert getCert() {
		return cert;
	}

	public void setCert(Cert cert) {
		this.cert = cert;
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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
