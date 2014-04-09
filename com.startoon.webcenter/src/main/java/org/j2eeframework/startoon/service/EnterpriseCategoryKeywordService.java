package org.j2eeframework.startoon.service;

import java.util.Calendar;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.dao.IEnterpriseCategoryKeywordDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseCategoryKeyword;
import org.j2eeframework.startoon.entity.Supply;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseCategoryKeywordService extends AbstractService<EnterpriseCategoryKeyword, Long, IEnterpriseCategoryKeywordDAO>
{
	private static final Log log = LogFactory.getLog(EnterpriseCategoryKeywordService.class);
	
	@Resource
	private IEnterpriseCategoryKeywordDAO enterpriseCategoryKeywordDAO;
	@Resource
	private SupplyService supplyService;
	@Resource
	private CategoryKeywordService categoryKeywordService;
	@Resource
	private EnterpriseService enterpriseService;

	@Override
	public IEnterpriseCategoryKeywordDAO getGenericDAO()
	{
		return enterpriseCategoryKeywordDAO;
	}
	
	public boolean exist(Long categoryKeywordId) {
		EnterpriseCategoryKeyword eck = findByCategoryKeywordIdId(categoryKeywordId);
		return eck != null;
	}
	
	public EnterpriseCategoryKeyword findByCategoryKeywordIdId(Long categoryKeywordId) {
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		Long enterpriseId = enterprise.getId();
		
		return enterpriseCategoryKeywordDAO.findByCategoryKeywordIdId(categoryKeywordId, enterpriseId);
	}
	
	public EnterpriseCategoryKeyword buy(EnterpriseCategoryKeyword enterpriseCategoryKeyword) {
		
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		enterpriseCategoryKeyword.setEnterprise(enterprise);
		
		Long id = enterpriseCategoryKeyword.getCategoryKeyword().getId();
		
		int count = enterpriseCategoryKeyword.getAmount();
		
		//计算到期时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, count);
		
		enterpriseCategoryKeyword.setEtime(calendar.getTime());
		
		//支付关键字购买金额
		float discount = categoryKeywordService.getDiscountByTimeLimit(id, count);
		float price = enterpriseCategoryKeyword.getPrice();
		float amount = price;
		if(count!=1) {
			amount = (float) (0.1 * price * count * discount);
		}
		
		
		CategoryKeyword categoryKeyword = enterpriseCategoryKeyword.getCategoryKeyword();
		Category category = categoryKeyword.getCategory();
		String categoryName = category.getName();
		String desc = "购买类别关键字广告[" + categoryName + "|第" + categoryKeyword.getRank() + "位|" + amount + "]";
		
		try {
			enterpriseService.pay(enterprise.getId(), amount, desc);
			log.info(desc);
		} catch (Exception e) {
			log.error("==> 购买类别关键字出错：" + e.getMessage());
		}
		
		//更新关键字的购买状态
		categoryKeywordService.updateStatus(id, calendar.getTime() ,2);
		
		getGenericDAO().insert(enterpriseCategoryKeyword);
		
		return enterpriseCategoryKeyword;
		
	}
	
	
	public boolean canBind(long id) {
		EnterpriseCategoryKeyword eck = getEntityById(id);
		int useLimit = eck.getUseLimit();
		
		return useLimit>0;
	}
	
	public void bindToSupply(Long supplyId, Long id) {
		
		Supply supply = supplyService.getEntityById(supplyId);
		EnterpriseCategoryKeyword eck = getEntityById(id);
		
		//释放之前绑定的类别关键字
		Long pid = supply.getEnterpriseCategoryKeywordId();
		if(pid!=null && pid!=0) {
			EnterpriseCategoryKeyword e = getEntityById(pid);
			int ul = e.getUseLimit();
			ul += 1;
			e.setUseLimit(ul);
			update(e);
		}
		
		//绑定关键字
		Long keywordCategoryId = eck.getCategoryKeyword().getCategory().getId();
		Long supplyCategoryId = supply.getCategory().getId();

		supply.setCategoryKeyword(keywordCategoryId == supplyCategoryId);
		supply.setEnterpriseCategoryKeywordId(id);
		int price = (int) (eck.getPrice() * 100);
		supply.setCategoryKeywordPrice(price);
		supply.setCategoryKeywordStatus(true);
		supplyService.update(supply);
		
		
		//对已经使用的关键字做后续处理
		int useLimit = eck.getUseLimit();
		useLimit -= 1;
		eck.setUseLimit(useLimit);
		update(eck);		
		
		
	}
	
	
	public void unbindFromSupply(Long supplyId) {
		
		Supply supply = supplyService.getEntityById(supplyId);
		Long id = supply.getEnterpriseCategoryKeywordId();
		if(id!=null && id!=0) {
			EnterpriseCategoryKeyword eck = getEntityById(id);
			if(eck!=null) {
				int useLimit = eck.getUseLimit();
				useLimit = 1;
				eck.setUseLimit(useLimit);
				update(eck);		
			}
		}
		
		supply.setCategoryKeyword(false);
		supply.setEnterpriseCategoryKeywordId(null);
		supply.setCategoryKeywordPrice(0);
		supply.setCategoryKeywordStatus(false);
		supplyService.update(supply);
		
	}
	
}
