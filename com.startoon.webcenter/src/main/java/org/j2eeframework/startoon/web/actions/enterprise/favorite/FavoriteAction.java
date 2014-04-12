package org.j2eeframework.startoon.web.actions.enterprise.favorite;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Favorite;
import org.j2eeframework.startoon.service.FavoriteService;

public class FavoriteAction extends ServiceBaseManageAction<Favorite, Long> {
	private static final long serialVersionUID = 6598430689294898483L;
	@Resource
	private FavoriteService favoriteService;
	private Favorite favorite;
	private Long fid;
	private Integer type;
	
	private List<Long> ids;

	@Override
	public IGenericService<Favorite, Long> getGenericService() {
		return favoriteService;
	}

	public Favorite getModel() {
		return favorite;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			favorite = new Favorite();
		} else {
			favorite = favoriteService.getEntityById(getRequestId());
		}
	}
	
	public String add() throws IOException {
		
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		
		Favorite favorite = new Favorite();
		favorite.setEnterprise(enterprise);
		
		favorite.setEntityId(fid);
		favorite.setType(type);
		
		getGenericService().insert(favorite);
		
		HttpServletResponse rsp = ServletActionContext.getResponse();
		
		rsp.setContentType("text/html;charset=utf-8");
		PrintWriter out = rsp.getWriter();
		out.write("success");
		out.flush();
		
		return null;
	}
	
	public String deleteAll() {
		for(Long id : ids) {
			getGenericService().deleteEntityById(id);
		}
		
		return ResultConstants.LIST;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
