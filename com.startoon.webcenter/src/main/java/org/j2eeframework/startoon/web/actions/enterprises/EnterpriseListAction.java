package org.j2eeframework.startoon.web.actions.enterprises;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Industry;
import org.j2eeframework.startoon.entity.SearchedKeyword;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.IndustryService;
import org.j2eeframework.startoon.service.KeywordService;
import org.j2eeframework.startoon.service.SearchedKeywordService;

public class EnterpriseListAction extends ServiceBasePaginationAction<Enterprise, Long> {

	private static final long serialVersionUID = -5197117148129092111L;

	private static final Log log = LogFactory.getLog(EnterpriseListAction.class);

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EntInfoService entInfoService;
	@Resource
	private IndustryService industryService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private SearchedKeywordService searchedKeywordService;
	@Resource
	private KeywordService keywordService;
	
	private List<Industry> industries;
	private List<Category> categories;
	private Category currentCategory;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	@Override
	public void preExecute() {
		
		getPager().setPageSize(15);
		
		String cid = getPager().getParamCondition().getParameter("categoryIds");
		industries = industryService.getAllEntity();
		if(cid !=null && !cid.equals("")){
			Long categoryId = new Long(cid);
			currentCategory = categoryService.getEntityById(categoryId);
			
			categories = categoryService.getCategory4Filter(categoryId);
		}
	}
	
	
	@Override
	public String execute() {
		
		preExecute();
		
		if(!getPager().getParamCondition().isBlank("searchKey")) { //关键词竞价搜索
			
			// 关键字搜索统计处理
			log.info("%%% 企业竞价排名预处理 %%%");
			searchExecute(getPager());
			log.info("%%% 企业竞价排名预处理结束 %%%");
			
			//关键词搜索
			enterpriseService.search(getPager());
			
		} else {
			getGenericService().getEntitiesOfPagerByParamCondition(getPager());
		}
		
		List<Enterprise> enterprises = getPager().getItems();
		
		for(Enterprise enterprise : enterprises) {
			long eid = enterprise.getId();
			EntInfo entInfo = entInfoService.getEntInfoByEnterpriseId(eid);
			enterprise.setEntInfo(entInfo);
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 关键字搜索预处理
	 * @param pager
	 */
	private void searchExecute(Pager<Enterprise> pager) {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int currentPageNo = pager.getPageNo();
		ParamCondition paramCondition = pager.getParamCondition();
		String __key = paramCondition.getParameter("searchKey");
		
		if(currentPageNo ==1 && __key != null) {
			paramCondition.addParameter("__flag", "0");
		}
		
		String __flag = paramCondition.getParameter("__flag");
		if(__flag!=null &&__flag.equals("0")) {
			SearchedKeyword sk = new SearchedKeyword();
			sk.setKeyword(__key);
			sk.setLastSearchTime(new Date());
			sk.setSearchIp(request.getRemoteAddr());
			searchedKeywordService.insert(sk);
			
			keywordService.addKeywordSearchTimes(sk.getKeyword());
			
			paramCondition.addParameter("__flag", "1");
			
			request.getSession().setAttribute("__flag", "1");
			request.getSession().setAttribute("__key", __key);
			
		}
		
	}	

	public List<Industry> getIndustries() {
		return industries;
	}

	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

}
