package org.j2eeframework.startoon.web.actions.enterprise.enterprisekeyword;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.entity.News;
import org.j2eeframework.startoon.service.EnterpriseKeywordService;
import org.j2eeframework.startoon.service.KeywordService;
import org.j2eeframework.startoon.service.NewsService;

public class EnterpriseKeywordAction extends
		ServiceBaseManageAction<EnterpriseKeyword, Long> {
	private static final long serialVersionUID = -254544751786549931L;

	private static final Log log = LogFactory
			.getLog(EnterpriseKeywordAction.class);

	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;

	@Resource
	private KeywordService keywordService;
	
	@Resource
	private NewsService newsService;

	private EnterpriseKeyword enterpriseKeyword;

	private Keyword selectedKeyword;

	private String ccode;

	private Long kid;
	
	private String msg;
	
	private News news;

	@Override
	public IGenericService<EnterpriseKeyword, Long> getGenericService() {
		return enterpriseKeywordService;
	}

	public EnterpriseKeyword getModel() {
		return enterpriseKeyword;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			enterpriseKeyword = new EnterpriseKeyword();
		} else {
			enterpriseKeyword = enterpriseKeywordService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {
		Long keywordId = kid;
		selectedKeyword = keywordService.getEntityById(keywordId);
		
/*		boolean exist = enterpriseKeywordService.existKeyword(keywordId);
		if(exist) {
			return ResultConstants.ERROR;
		}*/
		
		news = newsService.getEntityById(12L);
		
		
		return ResultConstants.INPUT;
	}

	@Override
	public String insert() {

		Enterprise user = SysContext.getCurrentEnterpriserUser();
		enterpriseKeyword.setEnterprise(user);
		enterpriseKeyword.setUsedLimit(2);

		enterpriseKeywordService.buy(enterpriseKeyword);

		log.debug("关键字竞价[" + enterpriseKeyword + "]");

		return ResultConstants.LIST;

	}

	public String bindToEnt() {

		try {

			HttpServletResponse response = ServletActionContext.getResponse();

			Enterprise ent = SysContext.getCurrentEnterpriserUser();
			Long enterpriseKeywordId = kid;

//			enterpriseKeywordService.bindToEnt(ent.getId(), enterpriseKeywordId);
			enterpriseKeywordService.bindToEnterprise(ent.getId(), enterpriseKeywordId);

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write("success");
			out.flush();
			log.debug("绑定关键字到企业[" + ent.getId() + "|" + ent.getName() + "|"
					+ enterpriseKeywordId + "]");

		} catch (IOException e) {
			e.printStackTrace();
			log.error("绑定关键字到企业出错", e);
		}

		return null;

	}
	
	/**
	 * 解除关键字在企业上的绑定
	 * @return
	 * @author kai
	 */
	public String unbindFromEnt() {
		
		try {
			
			HttpServletResponse response = ServletActionContext.getResponse();
			
			Enterprise ent = SysContext.getCurrentEnterpriserUser();
			Long enterpriseKeywordId = kid;
			
//			enterpriseKeywordService.unbindFromEnt(ent.getId(), enterpriseKeywordId);
			enterpriseKeywordService.unbindFromEnterprise(ent.getId(), enterpriseKeywordId);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write("success");
			out.flush();
			log.debug("解除关键字企业绑定[" + ent.getId() + "|" + ent.getName() + "|" + enterpriseKeywordId + "]");
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error("解除企业的关键字绑定出错", e);
		}
		
		return null;
		
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public Long getKid() {
		return kid;
	}

	public void setKid(Long kid) {
		this.kid = kid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Keyword getSelectedKeyword() {
		return selectedKeyword;
	}

	public void setSelectedKeyword(Keyword selectedKeyword) {
		this.selectedKeyword = selectedKeyword;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
