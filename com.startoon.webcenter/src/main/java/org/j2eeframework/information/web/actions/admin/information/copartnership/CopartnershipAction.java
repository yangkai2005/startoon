package org.j2eeframework.information.web.actions.admin.information.copartnership;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Copartnership;
import org.j2eeframework.information.service.CopartnershipService;
import org.j2eeframework.startoon.util.ImageUtil;

public class CopartnershipAction extends ServiceBaseManageAction<Copartnership, Long> {

	private static final long serialVersionUID = -2505358634691956317L;

	private static final Log log = LogFactory.getLog(CopartnershipAction.class);

	@Resource
	private CopartnershipService copartnershipService;

	private Copartnership copartnership;

	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
	private List<String> uploadFileName;

	@Override
	public IGenericService<Copartnership, Long> getGenericService() {
		return copartnershipService;
	}

	public Copartnership getModel() {
		return copartnership;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			copartnership = new Copartnership();
		} else {
			copartnership = copartnershipService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {
		return super.input();
	}

	@Override
	public String edit() {
		return super.edit();
	}

	@Override
	public String insert() {

		// begin 处理图片
		if (upload != null && !upload.isEmpty()) {
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				String normalLogo = ImageUtil.storeNormalImg(upl, uplName);
				String smallLogo = ImageUtil.storeSmallImg(upl, uplName);

				copartnership.setSmallLogoUrl(smallLogo);
				copartnership.setNormalLogoUrl(normalLogo);

			}
		}

		// end 处理图片

		return super.insert();

	}

	@Override
	public String update() {

		// begin 处理图片
		if (upload != null && !upload.isEmpty()) {
			int size = upload.size();
			for (int i = 0; i < size; i++) {
				File upl = upload.get(i);
				String uplName = uploadFileName.get(i);

				String normalLogo = ImageUtil.storeNormalImg(upl, uplName);
				String smallLogo = ImageUtil.storeSmallImg(upl, uplName);

				copartnership.setSmallLogoUrl(smallLogo);
				copartnership.setNormalLogoUrl(normalLogo);

			}
		}

		// end 处理图片
		return super.update();
	}

	public Copartnership getCopartnership() {
		return copartnership;
	}

	public void setCopartnership(Copartnership copartnership) {
		this.copartnership = copartnership;
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
