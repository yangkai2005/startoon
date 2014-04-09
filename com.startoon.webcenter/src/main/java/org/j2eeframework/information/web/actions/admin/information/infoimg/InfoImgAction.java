package org.j2eeframework.information.web.actions.admin.information.infoimg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.service.InfoImgService;
import org.j2eeframework.startoon.web.actions.enterprise.supply.SupplyAction;

public class InfoImgAction extends ServiceBaseManageAction<InfoImg,Long>
{
	private static final long serialVersionUID = -5027669163694054935L;
	
	private static final Log log = LogFactory.getLog(SupplyAction.class);	
	
	@Resource
	private InfoImgService infoImgService;
	private InfoImg infoImg;
	@Override
	public IGenericService<InfoImg, Long> getGenericService()
	{
		return infoImgService;
	}

	public InfoImg getModel()
	{
		return infoImg;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			infoImg = new InfoImg();
		} else
		{
			infoImg = infoImgService.getEntityById(getRequestId());
		}
	}
	
	public String ajaxDelete() {
		
		try {
			super.delete();
			HttpServletResponse response = ServletActionContext.getResponse();
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("success");
			out.flush();
			log.debug("删除图片ID：" + getRequestId());
			
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
			return null;
		}
		
	}

}
