package org.j2eeframework.information.web.actions.information.video;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

/**
 * 动画详细
 * 
 * @author kai
 */
public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	private static final long serialVersionUID = 1234879264660122900L;
	@Resource
	private InfoService infoService;
	private Info info;
	private List<Info> info1;
	private List<Info> info2;

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
	public String show() {

		List<Info> items = infoService.getInfoByInfoType(25L, 25);

		if (items != null) {
			int size = items.size();
			if (size > 5) {
				info1 = items.subList(0, 5);
				info2 = items.subList(5, size);
			} else {
				info1 = items.subList(0, size);
			}
		}

		info = infoService.getInfoWithImages(getRequestId());
		return super.show();
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Info> getInfo1() {
		return info1;
	}

	public List<Info> getInfo2() {
		return info2;
	}

}
