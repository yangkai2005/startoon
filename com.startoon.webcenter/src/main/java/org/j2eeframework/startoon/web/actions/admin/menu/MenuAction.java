package org.j2eeframework.startoon.web.actions.admin.menu;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Menu;
import org.j2eeframework.startoon.service.MenuService;

public class MenuAction extends ServiceBaseManageAction<Menu, Long> {
	private static final long serialVersionUID = -8998867043089081279L;
	@Resource
	private MenuService menuService;
	private Menu menu;

	private List<Menu> menus;
	private Long fatherId;

	@Override
	public IGenericService<Menu, Long> getGenericService() {
		return menuService;
	}

	public Menu getModel() {
		return menu;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			menu = new Menu();
		} else {
			menu = menuService.getEntityById(getRequestId());
		}

		menus = menuService.getAllEntity();

		if (fatherId != null && fatherId != 0) {
			Menu father = new Menu();

		}
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

}
