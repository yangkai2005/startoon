package org.j2eeframework.startoon.web.actions.enterprise.cert;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.Cert;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CertService;

public class CertAction extends ServiceBaseManageAction<Cert, Long> {
	private static final long serialVersionUID = 724039018535394125L;
	@Resource
	private CertService certService;
	private Cert cert;
	private File upload;
	private String uploadFileName;
	private List<Long> ids;

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

	@Override
	public String insert() {

		Enterprise ent = SysContext.getCurrentEnterpriserUser();

		if (upload != null) {

			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uploadFileName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upload, extension,
					SystemConfig.UPLOAD_FILE_DIR);
			cert.setCertImg(fileItemInfo.getFileId());
		}

		cert.setEnterprise(ent);

		super.insert();

		return ResultConstants.LIST;

	}

	public String deleteAll() {

		for (Long id : ids) {
			getGenericService().deleteEntityById(id);
		}

		return ResultConstants.LIST;
	}

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

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
