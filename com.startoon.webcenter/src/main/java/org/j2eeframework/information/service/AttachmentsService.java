package org.j2eeframework.information.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IAttachmentsDAO;
import org.j2eeframework.information.entity.Attachments;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.springframework.stereotype.Service;

@Service
public class AttachmentsService extends AbstractService<Attachments, Long, IAttachmentsDAO> {
	@Resource
	private IAttachmentsDAO attachmentsDAO;

	@Override
	public IAttachmentsDAO getGenericDAO() {
		return attachmentsDAO;
	}

	public Attachments add(Long fid, File upload, String name, String description) {

		if (upload != null) {
			File upl = upload;
			String uplName = name;

			String ext = FilenameUtils.getExtension(uplName);
			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);

			Attachments attachments = new Attachments();
			attachments.setCreateTime(new Date());
			attachments.setDataName(upload != null ? upload.getName() : null);

			attachments.setDataPath(fileItemInfo.getFileId());
			attachments.setDescription(description);
			attachments.setFormat(ext);
			attachments.setName(uplName);

			getGenericDAO().insert(attachments);

			return attachments;
		}

		return null;

	}

	public void add(Long fid, List<File> attachments, List<String> names, List<String> descriptions) {
		if (attachments != null && !attachments.isEmpty()) {
			int size = attachments.size();
			for (int i = 0; i < size; i++) {
				File upload = attachments.get(i);
				String name = names.get(i);
				String description = descriptions.get(i);
				add(fid, upload, name, description);
			}
		}
	}

	public List<Attachments> getByFid(Long fid) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("fid", fid + "");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, 100);
	}

	public void deleteByFid(Long fid) {
		attachmentsDAO.deleteByFid(fid);
	}
}
