package org.j2eeframework.startoon.web.actions.admin.link;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Link;
import org.j2eeframework.startoon.entity.LinkType;
import org.j2eeframework.startoon.service.LinkService;
import org.j2eeframework.startoon.service.LinkTypeService;
import org.j2eeframework.startoon.util.ImageUtil;

public class LinkAction extends ServiceBaseManageAction<Link, Long> {
	private static final long serialVersionUID = 3866657394313453904L;
	@Resource
	private LinkService linkService;
	@Resource
	private LinkTypeService linkTypeService;

	private Link link;
	private List<LinkType> linkTypes;
	private Long linkTypeId;

	/*
	 * 上传图片和相关内容
	 */
	private List<File> upload;
	private List<String> uploadFileName;

	@Override
	public IGenericService<Link, Long> getGenericService() {
		return linkService;
	}

	public Link getModel() {
		return link;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			link = new Link();
		} else {
			link = linkService.getEntityById(getRequestId());
		}

		linkTypes = linkTypeService.getSortedLinkType();

		if (linkTypeId != null && linkTypeId != 0) {
			LinkType type = new LinkType();
			type.setId(linkTypeId);
			link.setLinkType(type);
		}

	}

	@Override
	public String edit() {
		LinkType type = link.getLinkType();
		if (type != null) {
			linkTypeId = type.getId();
		}
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

				getModel().setSmallLogoUrl(smallLogo);
				getModel().setNormalLogoUrl(normalLogo);

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

				getModel().setSmallLogoUrl(smallLogo);
				getModel().setNormalLogoUrl(normalLogo);

			}
		}

		// end 处理图片
		return super.update();
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public List<LinkType> getLinkTypes() {
		return linkTypes;
	}

	public void setLinkTypes(List<LinkType> linkTypes) {
		this.linkTypes = linkTypes;
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

	public Long getLinkTypeId() {
		return linkTypeId;
	}

	public void setLinkTypeId(Long linkTypeId) {
		this.linkTypeId = linkTypeId;
	}

}
