package org.j2eeframework.startoon.web.actions.enterprise.entinfo;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.web.actions.enterprises.EntIndexAction;

public class EntInfoAction extends ServiceBaseManageAction<EntInfo, Long> {

	private static final long serialVersionUID = 5623517830485023222L;

	private static final Logger log = Logger.getLogger(EntIndexAction.class);

	@Resource
	private EntInfoService entInfoService;

	private EntInfo entInfo;

	private boolean success;
	private String indexContent;
	private String infoContent;
	private String produce;
	private String developContent;
	private File logo;
	private String logoFileName;
	private File indexpic;
	private String indexpicFileName;

	@Override
	public IGenericService<EntInfo, Long> getGenericService() {
		return entInfoService;
	}

	public EntInfo getModel() {
		return entInfo;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			entInfo = new EntInfo();
		} else {
			entInfo = entInfoService.getEntityById(getRequestId());
		}
	}

	public String forwardIndex() {
		entInfo = entInfoService.getEntInfoByEnterpriseId(SysContext.getCurrentEnterpriserUser().getId());
		if (entInfo != null) {
			indexContent = entInfo.getIndexContent();
		}

		log.debug(indexContent);

		return "index";
	}

	@Action(results = { @Result(name = "forwardIndex", location = "/enterprise/entinfo/ent-info!forwardIndex.action?success=${success}", type = "redirect") })
	public String modifyIndex() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		EntInfo info = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		boolean isNew = false;
		if (info == null) {
			info = new EntInfo();
			isNew = true;
		}
		info.setEnterprise(SysContext.getCurrentEnterpriserUser());
		info.setIndexContent(indexContent);

		IFileSystem fileSystem = new LocalFileSystem();
		String extension = "";

		if (logo != null) {
			extension = FilenameUtils.getExtension(logoFileName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(logo, extension, SystemConfig.UPLOAD_FILE_DIR);
			info.setInfoImgUrl(fileItemInfo.getFileId());
		}
		if (indexpic != null) {
			extension = FilenameUtils.getExtension(indexpicFileName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(indexpic, extension, SystemConfig.UPLOAD_FILE_DIR);
			info.setIndexImgUrl(fileItemInfo.getFileId());
		}

		if (isNew) {
			entInfoService.insert(info);
		} else {
			entInfoService.update(info);
		}

		success = true;

		return "forwardIndex";
	}

	public String forwardInfo() {
		entInfo = entInfoService.getEntInfoByEnterpriseId(SysContext.getCurrentEnterpriserUser().getId());
		if (entInfo != null) {
			infoContent = entInfo.getInfo();
		}
		return "info";
	}

	public String modifyInfo() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		EntInfo info = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		boolean isNew = false;
		if (info == null) {
			info = new EntInfo();
			isNew = true;
		}

		info.setEnterprise(SysContext.getCurrentEnterpriserUser());
		info.setInfo(infoContent);

		if (isNew) {
			entInfoService.insert(info);
		} else {
			entInfoService.update(info);
		}
		success = true;

		return "info";
	}

	public String forwardProduce() {
		entInfo = entInfoService.getEntInfoByEnterpriseId(SysContext.getCurrentEnterpriserUser().getId());
		if (entInfo != null) {
			produce = entInfo.getProduct();
		}
		return "produce";
	}

	public String modifyProduce() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		EntInfo info = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		boolean isNew = false;
		if (info == null) {
			info = new EntInfo();
			isNew = true;
		}

		info.setEnterprise(SysContext.getCurrentEnterpriserUser());
		info.setProduct(produce);

		if (isNew) {
			entInfoService.insert(info);
		} else {
			entInfoService.update(info);
		}
		success = true;

		return "produce";
	}

	public String forwardDev() {
		entInfo = entInfoService.getEntInfoByEnterpriseId(SysContext.getCurrentEnterpriserUser().getId());
		if (entInfo != null) {
			developContent = entInfo.getDevelop();
		}
		return "dev";
	}

	public String modifyDev() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		EntInfo info = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		boolean isNew = false;
		if (info == null) {
			info = new EntInfo();
			isNew = true;
		}

		info.setEnterprise(SysContext.getCurrentEnterpriserUser());
		info.setDevelop(developContent);

		if (isNew) {
			entInfoService.insert(info);
		} else {
			entInfoService.update(info);
		}
		success = true;

		return "dev";
	}

	public String forwardPro() {
		return SUCCESS;
	}

	public String modifyPro() {
		return SUCCESS;
	}

	public EntInfoService getEntInfoService() {
		return entInfoService;
	}

	public void setEntInfoService(EntInfoService entInfoService) {
		this.entInfoService = entInfoService;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getIndexContent() {
		return indexContent;
	}

	public void setIndexContent(String indexContent) {
		this.indexContent = indexContent;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getProduce() {
		return produce;
	}

	public void setProduce(String produce) {
		this.produce = produce;
	}

	public String getDevelopContent() {
		return developContent;
	}

	public void setDevelopContent(String developContent) {
		this.developContent = developContent;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public File getIndexpic() {
		return indexpic;
	}

	public void setIndexpic(File indexpic) {
		this.indexpic = indexpic;
	}

	public String getIndexpicFileName() {
		return indexpicFileName;
	}

	public void setIndexpicFileName(String indexpicFileName) {
		this.indexpicFileName = indexpicFileName;
	}

}
