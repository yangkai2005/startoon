package org.j2eeframework.startoon.web.actions.enterprise.enterprise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Business;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Industry;
import org.j2eeframework.startoon.service.BusinessService;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.IndustryService;


@Results({ @Result(name="baseinfo", location="/enterprise/enterprise/enterprise!info.action?flag=${flag}", type="redirect") })
public class EnterpriseAction extends ServiceBaseManageAction<Enterprise, Long> {
	private static final long serialVersionUID = 7492538587698850675L;
	private static final Log log = LogFactory.getLog(EnterpriseAction.class);
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private EntInfoService entInfoService;
	@Resource
	private IndustryService industryService;
	@Resource
	private BusinessService businessService;
	
	private Enterprise enterprise;
	private long entId;
	private List<Category> categories;
	private boolean flag;
	
	private EntInfo entInfo;
	private String banner;
	
	private List<Industry> industries;
	
	private List<Long> cid; //主营业务类别ID
	
	private List<Business> businesses;
	
	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	public Enterprise getModel() {
		return enterprise;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			enterprise = new Enterprise();
		} else {
			enterprise = enterpriseService.getEntityById(getRequestId());
		}
		
		categories = categoryService.getCategoryByFatherId(0L);
		
		industries = industryService.getAllEntity();
		
		businesses = businessService.getPrimaryBusiness(SysContext.getCurrentEnterpriserUser().getId());
	}
	
	public String info() {
		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		long id = ent.getId();
		enterprise = enterpriseService.getEntityById(id);
		log.debug("Enterprise[ " + enterprise + " ]");
		
		return "info";
	}
	
	public String detail() {
		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		long id = ent.getId();
		enterprise = enterpriseService.getEntityById(id);
		
		log.debug("Enterprise[ " + enterprise + " ]");
		
		return "detail";
	}
	

	public String updatebase() {
		
		long id = enterprise.getId();
		
		Enterprise ent = enterpriseService.getEntityById(id);
		
		ent.setName(enterprise.getName());
		ent.setSiteUrl(enterprise.getSiteUrl());
		ent.setAddress(enterprise.getAddress());
		ent.setManageType(enterprise.getManageType());
		ent.setManageDirection(enterprise.getManageDirection());
		ent.setBusiness(enterprise.getBusiness());
		ent.setLinkman(enterprise.getLinkman());
		ent.setLinkmanSex(enterprise.getLinkmanSex());
		ent.setMobilePhone(enterprise.getMobilePhone());
		ent.setTelephone(enterprise.getTelephone());
		ent.setFax(enterprise.getFax());
		ent.setEmail(enterprise.getEmail());
		ent.setQq(enterprise.getQq());
		ent.setMsn(enterprise.getMsn());
		ent.setIndustry(enterprise.getIndustry());
		ent.setCartoon(enterprise.isCartoon());
		
		//拼音
		String pinyin = ent.getNamePinyinByName();
		String firstPinyin = ent.getNameFirstPinyinByName();
		ent.setNamePinyin(pinyin);
		ent.setNameFirstPinyin(firstPinyin);
		
		enterpriseService.update(ent);
		
		
		//主营业务
		if(cid!=null) {
			for(Long categoryId : cid) {
				enterpriseService.addBusiness(enterprise.getId(), categoryId);
			}
		}
 		
		enterprise = getGenericService().getEntityById(id);
		
		flag = true;
		
		return "info";
	}
	
	public String updatedetail() {
		
		long id = enterprise.getId();
		Enterprise ent = enterpriseService.getEntityById(id);
		
		ent.setScale(enterprise.getScale());
		ent.setCtime(enterprise.getCtime());
		ent.setType(enterprise.getType());
		ent.setRegisteredCapital(enterprise.getRegisteredCapital());
		ent.setAcreage(enterprise.getAcreage());
		ent.setTurnover(enterprise.getTurnover());
		ent.setIns(enterprise.getIns());
		ent.setOuts(enterprise.getOuts());
		ent.setBrand(enterprise.getBrand());
		ent.setBank(enterprise.getBank());
		ent.setClients(enterprise.getClients());
		ent.setBank(enterprise.getBank());
		ent.setBankAccount(enterprise.getBankAccount());
		
		enterpriseService.update(ent);
		
		flag = true;
		
		return "detail";
	}

	public String forwardBanner() {
		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		long id = ent.getId();
		
		entInfo = entInfoService.getEntInfoByEnterpriseId(id);
		if(entInfo!=null){
			banner = entInfo.getBanner();
		}
		return "banner";
		
	}
	
	public String banner() {
		
		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		long id = ent.getId();
		
		entInfo = entInfoService.getEntInfoByEnterpriseId(id);

		entInfo.setIndexImgUrl(banner);
		
		entInfoService.update(entInfo);
		banner = entInfo.getBanner();
		flag = true;
		
		return "banner";
	}
	
	public String removeBusiness() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		String categoryId = request.getParameter("categoryId");
		if(categoryId!=null) {
			Long cid = new Long(categoryId);
			enterpriseService.removeBusiness(user.getId(), cid);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		log.debug("删除主营业务ID：" + categoryId);
		return null;
	}
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public long getEntId() {
		return entId;
	}

	public void setEntId(long entId) {
		this.entId = entId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public List<Industry> getIndustries() {
		return industries;
	}

	public void setIndustries(List<Industry> industries) {
		this.industries = industries;
	}

	public List<Long> getCid() {
		return cid;
	}

	public void setCid(List<Long> cid) {
		this.cid = cid;
	}

	public List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}

}
