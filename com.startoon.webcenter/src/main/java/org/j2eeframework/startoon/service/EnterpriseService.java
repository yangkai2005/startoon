package org.j2eeframework.startoon.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.commons.util.EncryptUtil;
import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.information.service.HrLimitService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.dao.IEnterpriseDAO;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Cast;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseService extends AbstractService<Enterprise, Long, IEnterpriseDAO> {

	private static final Log log = LogFactory.getLog(EnterpriseService.class);

	@Resource
	private IEnterpriseDAO enterpriseDAO;

	@Resource
	private EntInfoService entInfoService;

	@Resource
	private CategoryService categoryService;

	@Resource
	private BusinessService businessService;

	@Resource
	private PaymentService paymentService;

	@Resource
	private CastService castService;

	@Resource
	private HrLimitService hrLimitService;

	@Override
	public IEnterpriseDAO getGenericDAO() {
		return enterpriseDAO;
	}

	public Enterprise auth(String account, String password) throws Exception {

		Enterprise ent = null;
		ent = enterpriseDAO.getEnterpriseByAccount(account);

		if (ent == null) {
			throw new Exception("用户不存在！");
		}

		int status = ent.getStatus();

		switch (status) {
		case 0:
			throw new Exception("用户审核当中！");

		case 1:
			throw new Exception("用户审核不通过！");

		case 3:
			throw new Exception("用户不存在！");

		case 4:
			throw new Exception("该帐号已冻结！");
		}

		String enPwd = EncryptUtil.md5(password);

		if (!ent.getPassword().equals(enPwd)) {
			throw new Exception("密码不正确！");
		}

		return ent;

	}

	public Enterprise auth(String account, String password, int userType) throws Exception {

		Enterprise ent = null;
		ent = enterpriseDAO.getEnterpriseByAccount(account);

		if (ent == null) {
			throw new Exception("用户不存在！");
		}
		if (ent.getUserType() != userType) {
			throw new Exception("用户类型不正确！");
		}

		int status = ent.getStatus();

		switch (status) {
		case 0:
			throw new Exception("用户审核当中！");

		case 1:
			throw new Exception("用户审核不通过！");

		case 3:
			throw new Exception("用户不存在！");
		}

		String enPwd = EncryptUtil.md5(password);

		if (!ent.getPassword().equals(enPwd)) {
			throw new Exception("密码不正确！");
		}

		return ent;

	}

	public Enterprise getEntByEmail(String email) {
		return enterpriseDAO.getEnterpriseByAccount(email);
	}

	public boolean exist(String email) {
		Enterprise ent = getEntByEmail(email);
		return ent != null;
	}

	public List<Enterprise> getLatestEnt(int size) {

		Pager<Enterprise> pager = new Pager<Enterprise>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("orderBy", "id");
		pager.getParamCondition().addParameter("userType", "1");

		getEntitiesOfPagerByParamCondition(pager);

		return pager.getItems();

	}

	/**
	 * 根据编号获取企业对象
	 * 
	 * @param ids
	 * @return
	 */
	public List<Enterprise> getEnterpriseByIds(String ids, int size) {
		Pager<Enterprise> pager = new Pager<Enterprise>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("ids", ids);
		getEntitiesOfPagerByParamCondition(pager);
		List<Enterprise> enterprises = pager.getItems();

		for (Enterprise enterprise : enterprises) {
			EntInfo entInfo = entInfoService.getEntInfoByEnterpriseId(enterprise.getId());
			enterprise.setEntInfo(entInfo);
		}

		return enterprises;

	}

	/**
	 * 根据ID字符串获取企业对象
	 * 
	 * @param ids
	 * @return
	 */
	public List<Enterprise> getEnterpriseByIds(String ids) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("ids", ids);
		condition.addParameter("userType", "-1");
		List<Enterprise> enterprises = getGenericDAO().getEntitiesByParamCondition(condition, 0, 100000);
		return enterprises;

	}

	/**
	 * 
	 * @param size
	 * @return
	 */
	public List<Enterprise> getEnterpriseBySize(int size) {
		Pager<Enterprise> pager = new Pager<Enterprise>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("nameNotNull", "true");
		getEntitiesOfPagerByParamCondition(pager);
		List<Enterprise> enterprises = pager.getItems();

		for (Enterprise enterprise : enterprises) {
			EntInfo entInfo = entInfoService.getEntInfoByEnterpriseId(enterprise.getId());
			enterprise.setEntInfo(entInfo);
		}

		return enterprises;

	}

	public List<Enterprise> getAll() {
		Pager<Enterprise> pager = new Pager<Enterprise>();
		pager.setPageSize(100000);
		pager.getParamCondition().addParameter("nameNotNull", "true");
		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}

	public boolean generatePinyin() {

		Pager<Enterprise> pager = new Pager<Enterprise>();
		pager.setPageSize(100);
		getEntitiesOfPagerByParamCondition(pager);

		int pages = pager.getCountOfPager();

		for (int i = 0; i < pages; i++) {
			int currentPageNo = i + 1;
			pager.setPageNo(currentPageNo);
			pager.setPageSize(100);
			getEntitiesOfPagerByParamCondition(pager);
			List<Enterprise> ents = pager.getItems();

			for (Enterprise e : ents) {
				String pinyin = e.getNamePinyinByName(), firstPinyin = e.getNameFirstPinyinByName();

				e.setNamePinyin(pinyin);
				e.setNameFirstPinyin(firstPinyin);

				log.debug(">>>>> 企业 更新拼音：id:" + e.getId() + ", name: " + e.getName() + ", pinyin:" + e.getNamePinyin() + ", first_pinyin:" + e.getNameFirstPinyin());

				String sql = "update enterprise set name_pinyin='" + e.getNamePinyin() + "', name_first_pinyin='" + e.getNameFirstPinyin() + "' where id=" + e.getId();
				getGenericDAO().execUpdate(sql);
			}
		}

		return true;
	}

	/**
	 * 根据用户的ID扣取指定金额
	 * 
	 * @param id
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public boolean pay(Long id, float amount, String description) throws Exception {
		Enterprise enterprise = getEntityById(id);
		float currentAmount = enterprise.getAmount();

		if (currentAmount < amount) {
			throw new Exception("账户余额不足！");
		}

		currentAmount -= amount;
		enterprise.setAmount(currentAmount);

		Cast cast = new Cast();
		cast.setAmount(amount);
		cast.setCtime(new Date());
		cast.setEnterprise(enterprise);
		cast.setDescription(description);

		try {
			update(enterprise);
			castService.insert(cast);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("==>扣费异常：", e);
			throw new Exception("扣费异常", e.getCause());
		}

		return true;
	}

	/**
	 * 后台充值
	 * 
	 * @param enterpriseId
	 * @param amount
	 * @return
	 */
	public Enterprise recharge(Long enterpriseId, float amount) {

		AdminUser adminUser = SysContext.getCurrentAdminUser();
		Long adminUserId = adminUser.getId();

		Enterprise ent = getEntityById(enterpriseId);

		float currentAmount = ent.getAmount();
		float totalAmount = currentAmount + amount;

		ent.setAmount(totalAmount);
		update(ent);

		paymentService.rechargeByAdminUser(enterpriseId, amount, adminUserId);

		log.warn("$$$ " + " 充值[Enterprise.Id:" + enterpriseId + ", Enterprise.amount:" + amount + ", AdminUser.Id:" + adminUserId + "] $$$");

		return ent;

	}

	public String addBusinessIds(String businessIds, Long categoryId) {

		Category category = categoryService.getEntityById(categoryId);
		Category fatherCategory = category.getCategory();
		String cid1 = "#" + fatherCategory.getId() + "#", cid2 = "#" + category.getId() + "#";
		if (businessIds == null && cid1.length() > 2) {
			businessIds = cid1;
		} else if (cid1.length() > 2 && businessIds.indexOf(cid1) < 0) {
			businessIds += cid1;
		}

		if (businessIds == null && cid2.length() > 2) {
			businessIds = cid2;
		} else if (cid2.length() > 2 && businessIds.indexOf(cid2) < 0) {
			businessIds += cid2;
		}

		return businessIds;
	}

	/**
	 * 删除主营业务
	 * 
	 * @return
	 */
	public String removeBusinessIds(String businessIds, Long categoryId) {

		if (businessIds == null) {
			return null;
		}

		Category category = categoryService.getEntityById(categoryId);
		Category fatherCategory = category.getCategory();
		String cid1 = "#" + fatherCategory.getId() + "#", cid2 = "#" + category.getId() + "#";
		if (cid1.length() > 2) {
			businessIds = businessIds.replace(cid1, "");
		}
		if (cid2.length() > 2) {
			businessIds = businessIds.replace(cid2, "");
		}

		return businessIds;
	}

	/**
	 * 添加主营业务
	 * 
	 * @param id
	 * @param categoryId
	 * @return
	 */
	public Enterprise addBusiness(Long id, Long categoryId) {

		businessService.addBusiness(id, categoryId);

		Enterprise enterprise = getEntityById(id);
		String businessIds = enterprise.getBusinessIds();
		businessIds = addBusinessIds(businessIds, categoryId);
		enterprise.setBusinessIds(businessIds);
		update(enterprise);

		return enterprise;
	}

	/**
	 * 删除主营业务
	 * 
	 * @param id
	 * @param categoryId
	 * @return
	 */
	public Enterprise removeBusiness(Long id, Long categoryId) {

		businessService.removeBusiness(id, categoryId);

		Enterprise enterprise = getEntityById(id);
		String businessIds = enterprise.getBusinessIds();
		businessIds = removeBusinessIds(businessIds, categoryId);
		enterprise.setBusinessIds(businessIds);
		update(enterprise);

		return enterprise;
	}

	public Enterprise invalidKeyword(Long enterpriseId) {
		Enterprise enterprise = enterpriseDAO.getEntityById(enterpriseId);
		enterprise.setEnterpriseKeywordId(null);
		enterprise.setKeyword(null);
		enterprise.setKeywordPrice(null);
		enterpriseDAO.update(enterprise);

		return enterprise;
	}

	/**
	 * 关键词搜索单独处理的方法
	 * 
	 * @param pager
	 */
	public void search(Pager<Enterprise> pager) {

		ParamCondition condition = pager.getParamCondition();
		int offset = pager.getFirstResult(), pageSize = pager.getPageSize();

		List<Enterprise> items = getGenericDAO().search(condition, offset, pageSize);
		int totalCount = getGenericDAO().count(condition);

		pager.setItems(items);
		pager.setCountOfTotalItem(totalCount);
	}

	/**
	 * 根据条件查询注册用户
	 * 
	 * @param condition
	 * @return
	 */
	public List<Enterprise> getUserByCondition(ParamCondition condition) {
		int offset = 0, pageSize = 100000;
		List<Enterprise> items = getGenericDAO().getEntitiesByParamCondition(condition, offset, pageSize);
		return items;
	}

	/**
	 * 查询个人用户
	 * 
	 * @param condition
	 * @return
	 */
	public List<Enterprise> getPersonalUser() {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("userType", Enterprise.USER_TYPE_PERSON + "");
		return getUserByCondition(condition);
	}

	/**
	 * 查询企业用户
	 * 
	 * @return
	 */
	public List<Enterprise> getEnterpriseUser() {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("userType", Enterprise.USER_TYPE_ENTERPRISE + "");
		return getUserByCondition(condition);
	}

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	public List<Enterprise> getAllUser() {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("userType", "-1");
		return getUserByCondition(condition);
	}

	/**
	 * 查询指定用户
	 * 
	 * @param flag
	 *            0-所有用户 1-企业用户 2-个人用户
	 * @return
	 */
	public List<Enterprise> getUserByFlag(int flag) {
		List<Enterprise> items = null;
		if (flag == 0) {
			items = getAllUser();
		} else if (flag == 1) {
			items = getEnterpriseUser();
		} else if (flag == 2) {
			items = getPersonalUser();
		}

		return items;

	}

	/**
	 * 将用户信息转换为json数据格式
	 * 
	 * @param flag
	 * @return
	 */
	public String getUserJsonByFlag(int flag) {

		List<Enterprise> users = getUserByFlag(flag);
		JSONArray arr = new JSONArray();
		for (Enterprise u : users) {
			String name = StringUtils.isBlank(u.getName()) ? u.getAccount() : u.getName();
			JSONObject json = new JSONObject();
			json.put("uid", u.getId() + "");
			json.put("name", name);
			arr.add(json);

		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("items", arr);

		String jsonString = arr.toString();
		log.debug("%%% json: " + jsonString);

		return jsonString;
	}

	/**
	 * 查询所有企业的ID
	 * @return
	 */
	public List<Long> getAllId() {
		return enterpriseDAO.getAllId();
	}

	/**
	 * 会员升级
	 */
	public void upgrade(Long id, int updgradeLevel) {

		Enterprise enterprise = getEntityById(id);

		Integer level = enterprise.getMemberLevel();
		level = level == null ? 0 : level;
		level += updgradeLevel;
		level = level < 0 ? 0 : (level > 2 ? 2 : level);
		enterprise.setMemberLevel(level);

		update(enterprise);

		HrLimit hrLimit = enterprise.getLimit();
		if (hrLimit == null) {
			hrLimit = new HrLimit();
		}

		Date now = new Date();
		Date dueTime = DateUtil.addMonths(now, 3);
		int maxJobCount = HrLimit.JOB_COUNT_0, maxViewCount = HrLimit.VIEW_COUNT_0;

		switch (level) {
		case 0:
			maxJobCount = HrLimit.JOB_COUNT_0;
			maxViewCount = HrLimit.VIEW_COUNT_0;
			break;

		case 1:
			maxJobCount = HrLimit.JOB_COUNT_1;
			maxViewCount = HrLimit.VIEW_COUNT_1;
			break;

		case 2:
			maxJobCount = HrLimit.JOB_COUNT_2;
			maxViewCount = HrLimit.VIEW_COUNT_2;
			break;
		}

		hrLimit.setMemberDeadTime(dueTime);
		hrLimit.setMaxJobCount(maxJobCount);
		hrLimit.setMaxViewCount(maxViewCount);
		hrLimit.setMemberLevel(level);

		hrLimitService.saveOrUpdate(hrLimit);
	}

}
