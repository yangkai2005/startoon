package org.j2eeframework.startoon.web.actions.enterprise.enterprisecategorykeyword;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseCategoryKeyword;
import org.j2eeframework.startoon.entity.News;
import org.j2eeframework.startoon.service.CategoryKeywordService;
import org.j2eeframework.startoon.service.EnterpriseCategoryKeywordService;
import org.j2eeframework.startoon.service.NewsService;

public class EnterpriseCategoryKeywordAction extends ServiceBaseManageAction<EnterpriseCategoryKeyword,Long>
{
	private static final long serialVersionUID = -7387011036815172200L;
	
	private static final Log log = LogFactory.getLog(EnterpriseCategoryKeywordAction.class);
	
	@Resource
	private EnterpriseCategoryKeywordService enterpriseCategoryKeywordService;
	@Resource
	private CategoryKeywordService categoryKeywordService;
	@Resource
	private NewsService newsService;
	
	private EnterpriseCategoryKeyword enterpriseCategoryKeyword;

	private CategoryKeyword keyword;
	
	private Long ckid;
	
	private int count;
	
	private String errorCode;
	
	private News news;
	
	@Override
	public IGenericService<EnterpriseCategoryKeyword, Long> getGenericService()
	{
		return enterpriseCategoryKeywordService;
	}

	public EnterpriseCategoryKeyword getModel()
	{
		return enterpriseCategoryKeyword;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			enterpriseCategoryKeyword = new EnterpriseCategoryKeyword();
		} else
		{
			enterpriseCategoryKeyword = enterpriseCategoryKeywordService.getEntityById(getRequestId());
		}
	}
	
	@Override
	public String input() {
		
		boolean exist = enterpriseCategoryKeywordService.exist(ckid);
		
		if(exist) {
			return "error";
		}
		
		keyword = categoryKeywordService.getEntityById(ckid);
		news = newsService.getEntityById(11L);
		
		return super.input();
	}
	
	@Override
	public String insert() {
		
		log.info("购买类别关键词广告");
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		
		enterpriseCategoryKeyword.setEnterprise(enterprise);
		
		Long id = enterpriseCategoryKeyword.getCategoryKeyword().getId();
		keyword = categoryKeywordService.getEntityById(id);
		enterpriseCategoryKeyword.setCategoryKeyword(keyword);

		enterpriseCategoryKeyword.setAmount(count);
		
		enterpriseCategoryKeywordService.buy(enterpriseCategoryKeyword);
		
		return ResultConstants.LIST;
	}

	public EnterpriseCategoryKeyword getEnterpriseCategoryKeyword() {
		return enterpriseCategoryKeyword;
	}

	public void setEnterpriseCategoryKeyword(
			EnterpriseCategoryKeyword enterpriseCategoryKeyword) {
		this.enterpriseCategoryKeyword = enterpriseCategoryKeyword;
	}

	public Long getCkid() {
		return ckid;
	}

	public void setCkid(Long ckid) {
		this.ckid = ckid;
	}

	public CategoryKeyword getKeyword() {
		return keyword;
	}

	public void setKeyword(CategoryKeyword keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
