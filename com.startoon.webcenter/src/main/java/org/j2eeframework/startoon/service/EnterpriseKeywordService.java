package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.dao.IEnterpriseKeywordDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.EnterpriseRefKeyword;
import org.j2eeframework.startoon.entity.Supply;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseKeywordService extends AbstractService<EnterpriseKeyword, Long, IEnterpriseKeywordDAO>
{
	private static final Log log = LogFactory.getLog(EnterpriseKeywordService.class);
	
	@Resource
	private IEnterpriseKeywordDAO enterpriseKeywordDAO;
	@Resource
	private SupplyService supplyService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private KeywordService keywordService;
	@Resource
	private EnterpriseRefKeywordService enterpriseRefKeywordService;

	@Override
	public IEnterpriseKeywordDAO getGenericDAO()
	{
		return enterpriseKeywordDAO;
	}
	
	public List<EnterpriseKeyword> getEnterpriseKeywordByKeywordId(Long keywordId) {
		return enterpriseKeywordDAO.getEnterpriseKeywordByKeywordId(keywordId);
	}
	
	public boolean existKeyword(Long keywordId) {
		
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		
		EnterpriseKeyword ek = findEntKey(user.getId(), keywordId);
		
		if(ek!=null) {
			return true;
		}
		
		return false;
	}
	
	public EnterpriseKeyword buy(EnterpriseKeyword enterpriseKeyword) {
		
		//更新关键字当前的最高价格
		Long keywordId = enterpriseKeyword.getKeyword().getId();
		Float currentPrice = enterpriseKeyword.getPrice();
		keywordService.updateKeywordCurrentPrice(keywordId, currentPrice);
		
		insert(enterpriseKeyword);
		
		return enterpriseKeyword;
	}
	
	public EnterpriseKeyword findEntKey(Long enterpriseId, Long keywordId) {
		return enterpriseKeywordDAO.findEntKey(enterpriseId, keywordId);
	}
	
	/**
	 * 关键字绑定验证
	 * @param id
	 * @return
	 */
	public boolean canBind(long id) {
		EnterpriseKeyword ek = getEntityById(id);
		int useLimit = ek.getUsedLimit();
		return useLimit>0;
	}
	
	/**
	 * 对产品进行关键词进行绑定
	 * @param supplyId
	 * @param enterpriseKeywordId
	 */
	public void bindToSupply(Long supplyId, Long enterpriseKeywordId) {
		
		Supply supply = supplyService.getEntityById(supplyId);
		
		//释放已绑定的关键词
		Long id = supply.getEnterpriseKeywordId();
		if(id!=null) {
			free(id, true);
		}

		//绑定关键字
		EnterpriseKeyword enterpriseKeyword = enterpriseKeywordDAO.getEntityById(enterpriseKeywordId);
		String keyword = enterpriseKeyword.getKeyword().getKeyword();
		float price = enterpriseKeyword.getPrice();
		int keywordPrice = (int) (price * 100); //去掉小数点，这样加快数据库排序速度

		supply.setKeyword(keyword);
		supply.setKeywordPrice(keywordPrice);
		supply.setEnterpriseKeywordId(enterpriseKeywordId);
		
		supplyService.update(supply);
		
		//关键字绑定后续处理，在关键字可用绑定次数减1
		bind(enterpriseKeywordId, true, supplyId);
		
	}
	
	/**
	 * 释放绑定在产品的关键词
	 * @param supplyId
	 */
	public void unbindFromSupply(Long supplyId) {
		
		Supply supply = supplyService.getEntityById(supplyId);
		Long id = supply.getEnterpriseKeywordId();
		
		//释放绑定的关键字
		supply.setEnterpriseKeywordId(null);
		supply.setKeyword(null);
		supply.setKeywordPrice(null);
		supply.setKeywordStatus(false);
		
		supplyService.update(supply);
		
		//将关键字使用次数还原
		if(id!=null) {
			free(id, true);
		}
		
	}

	/**
	 * 绑定关键字到企业
	 * @param enterpriseId
	 * @param enterpriseKeywordId
	 * @author kai
	 */
	public void bindToEnt(Long enterpriseId, Long enterpriseKeywordId) {
		
		log.debug(" %%%%%%%%%%%%%%% begin bind enterprisekeyword to enterprise  %%%%%%%%%%%%%%% ");
		
		Enterprise ent = enterpriseService.getEntityById(enterpriseId);
		
		//释放已经绑定的关键字
		Long ekid = ent.getEnterpriseKeywordId();
		if(ekid!=null) {
			free(ekid, false);
		}
		
		//绑定关键字
		EnterpriseKeyword newBindEnterpriseKeyword = getEntityById(enterpriseKeywordId);
		String keyword = newBindEnterpriseKeyword.getKeyword().getKeyword();
		int price = (int) (newBindEnterpriseKeyword.getPrice() * 100);
		
		ent.setKeywordPrice(price);
		ent.setKeyword(keyword);
		ent.setEnterpriseKeywordId(enterpriseKeywordId);
		
		enterpriseService.update(ent);
		
		//关键字绑定后续处理，在关键字可用绑定次数减1
		bind(enterpriseKeywordId, false, null);
		
		log.debug(" %%%%%%%%%%%%%%% end bind enterprisekeyword to enterprise %%%%%%%%%%%%%%% ");
	}
	
	/**
	 * 绑定关键词到企业
	 * @param enterpriseId
	 * @param enterpriseKeywordId
	 * @author kai
	 */
	public void bindToEnterprise(Long enterpriseId, Long enterpriseKeywordId) {
		
		log.debug(" %%%%%%%%%%%%%%% begin bind enterprisekeyword to enterprise  %%%%%%%%%%%%%%% ");
		
		Enterprise ent = enterpriseService.getEntityById(enterpriseId);
		
		//绑定关键字
		EnterpriseKeyword newBindEnterpriseKeyword = getEntityById(enterpriseKeywordId);
		String keyword = newBindEnterpriseKeyword.getKeyword().getKeyword();
		int price = (int) (newBindEnterpriseKeyword.getPrice() * 100);
		
		EnterpriseRefKeyword enterpriseRefKeyword = new EnterpriseRefKeyword();
		enterpriseRefKeyword.setEnterprise(ent);
		enterpriseRefKeyword.setEnterpriseKeyword(newBindEnterpriseKeyword);
		enterpriseRefKeyword.setKeyword(keyword);
		enterpriseRefKeyword.setPrice(price);
		enterpriseRefKeywordService.insert(enterpriseRefKeyword);
		
		
		//关键字绑定后续处理，在关键字可用绑定次数减1
		bind(enterpriseKeywordId, false, null);
		
		log.debug(" %%%%%%%%%%%%%%% end bind enterprisekeyword to enterprise %%%%%%%%%%%%%%% ");
	}
	
	/**
	 * 将关键字从企业上解除绑定
	 * @param enterpriseId
	 * @param enterpriseKeywordId
	 * @author kai
	 */
	public void unbindFromEnt(Long enterpriseId, Long enterpriseKeywordId) {
		
		Enterprise ent = enterpriseService.getEntityById(enterpriseId);
		
		//释放已经绑定的关键字
		Long ekid = ent.getEnterpriseKeywordId();
		if(ekid!=null) {
			free(ekid, false);
		}
		
		//处理绑定关键字
		ent.setKeywordPrice(0);
		ent.setKeyword(null);
		ent.setEnterpriseKeywordId(null);
		
		enterpriseService.update(ent);
		
	}
	
	/**
	 * 将关键字从企业上解除绑定
	 * @param enterpriseId
	 * @param enterpriseKeywordId
	 * @author kai
	 */
	public void unbindFromEnterprise(Long enterpriseId, Long enterpriseKeywordId) {
		
		//释放已经绑定的关键字
		if(enterpriseKeywordId!=null) {
			free(enterpriseKeywordId, false);
		}
		
		//处理绑定关键字
		enterpriseRefKeywordService.deleteByLogicKey(enterpriseId, enterpriseKeywordId);
	}
	
	public EnterpriseKeyword addUseLimit(Long id) {
		return addUseLimit(id, 1);
	}
	
	/**
	 * 根据ID修改关键字使用次数
	 * 正整数为添加，负整数为减少
	 * @param id
	 * @param count
	 * @return
	 */
	public EnterpriseKeyword addUseLimit(Long id, int count) {
		EnterpriseKeyword ek = getGenericDAO().getEntityById(id);
		int limit = ek.getUsedLimit();
		limit += count;
		ek.setUsedLimit(limit);
		getGenericDAO().update(ek);
		return ek;
	}
	
	/**
	 * 绑定关键字
	 * @param id
	 * @return
	 * @author kai
	 */
	public EnterpriseKeyword bind(long id, boolean isSupply, Long supplyId) {
		
		log.info(">>> bind enterprisekeyword begin.");
		
		EnterpriseKeyword newBindEnterpriseKeyword = enterpriseKeywordDAO.getEntityById(id);
		int usedLimit = newBindEnterpriseKeyword.getUsedLimit();
		usedLimit -= 1;
		newBindEnterpriseKeyword.setUsedLimit(usedLimit);
		if(isSupply) {
			newBindEnterpriseKeyword.setBindSupply(true);
			newBindEnterpriseKeyword.setSupplyId(supplyId);
		}
		else
			newBindEnterpriseKeyword.setBindEnt(true);
		
		enterpriseKeywordDAO.update(newBindEnterpriseKeyword);

		log.info(">>> bind enterprisekeyword end.");
		
		return newBindEnterpriseKeyword;
	}
	
	/**
	 * 释放绑定的关键字
	 * @param id
	 * @return
	 * @author kai
	 */
	public EnterpriseKeyword free(long id, boolean isSupply) {

		log.info(">>> free enterprisekeyword begin .");
		
		EnterpriseKeyword bindedEnterpriseKeyword = enterpriseKeywordDAO.getEntityById(id);
		int usedLimit = bindedEnterpriseKeyword.getUsedLimit();
		usedLimit += 1;
		bindedEnterpriseKeyword.setUsedLimit(usedLimit);
		if(isSupply) {
			bindedEnterpriseKeyword.setBindSupply(false);
			bindedEnterpriseKeyword.setSupplyId(null);
		}
		else
			bindedEnterpriseKeyword.setBindEnt(false);
		
		enterpriseKeywordDAO.update(bindedEnterpriseKeyword);
		
		log.info(">>> free enterprisekeyword end .");
		
		return bindedEnterpriseKeyword;
		
	}
	
	@Override
	public void getEntitiesOfPagerByParamCondition(Pager<EnterpriseKeyword> pager) {
		
		super.getEntitiesOfPagerByParamCondition(pager);
		List<EnterpriseKeyword> items = pager.getItems();
		for(EnterpriseKeyword item : items) {
			Long supplyId = item.getSupplyId();
			if(supplyId!=null) {
				Supply supply = supplyService.getEntityById(supplyId);
				item.setSupply(supply);
			}
		}
		
	}

	
}
