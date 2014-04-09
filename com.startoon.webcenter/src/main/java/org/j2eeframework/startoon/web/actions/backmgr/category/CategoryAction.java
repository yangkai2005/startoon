package org.j2eeframework.startoon.web.actions.backmgr.category;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.service.AttrTypeService;
import org.j2eeframework.startoon.service.CategoryAttrService;
import org.j2eeframework.startoon.service.CategoryService;

public class CategoryAction extends ServiceBaseManageAction<Category, Long> {
	private static final long serialVersionUID = -1071113265793687574L;
	private static final Log log = LogFactory.getLog(CategoryAction.class);
	@Resource
	private CategoryService categoryService;
	@Resource
	private CategoryAttrService categoryAttrService;
	@Resource
	private AttrTypeService attrTypeService;

	private Category category;
	private CategoryAttr categoryAttr;

	private String fatherid; // 父级ID
	private String cname; // 分类名称
	private String remark; // 分类说明
	private long cid; // 分类ID
	private long aid; // 分类属性ID

	private String attrvalue; // 属性值
	private String attrname; // 属性名
	private String attrinput; // 输入类型
	private String treeString; // 树型

	private Long attrTypeId;
	private List<AttrType> attrTypes;

	private String msg; // 提示信息

	private List<Category> categories;

	@Override
	public IGenericService<Category, Long> getGenericService() {
		return categoryService;
	}

	public IGenericService<CategoryAttr, Long> getGenericAttrService() {
		return categoryAttrService;
	}

	public Category getModel() {
		return category;
	}

	public void prepare() throws Exception {
		categories = categoryService.getCategoryByFatherId(0L);
		attrTypes = attrTypeService.getAllEntity();
	}

	private List getCategoryTree() {
		List list = new ArrayList();
		categories = categoryService.getCategoryByFatherId(new Long(0));
		return list;
	}

	/***
	 * 添加分类
	 * 
	 * @return
	 */
	// @Action(results = { @Result(name = "success", location =
	// "/backmgr/success.jsp")})
	@Override
	public String insert() {

		Category obj = new Category();
		Category pObj = new Category();
		pObj = categoryService.getEntityById(new Long(fatherid));
		obj.setDelete(false);
		obj.setCategory(pObj);
		obj.setName(cname);
		obj.setRemark(remark);
		int level = categoryService.getLevel("from Category",Long.parseLong(fatherid));
		obj.setCategoryLevel(Integer.valueOf(level+2));
		categoryService.insert(obj);
		
		msg = SUCCESS;
		 treeString = "";//清空
		 treeString = categoryService.getTreeForSelect("from Category ", 0);

		return "input";
	}

	/***
	 * 初始化添加分类属性
	 * 
	 * @return
	 */
	public String inputattr() {
		category = categoryService.getEntityById(new Long(cid));
		cname = category.getName();
		treeString = "";// 清空

		// treeString = categoryService.getTreeForSelect("from Category ", 0);
		log.info(treeString);
		return "inputattr";
	}

	/***
	 * 初始化添加分类
	 * 
	 * @return
	 */
	@Override
	public String input() {
		// category = categoryService.getEntityById(new Long(cid));
		// cname = category.getName();
		treeString = "";// 清空
		treeString = categoryService.getTreeForSelect("from Category ", 0);
		// log.info(treeString);
		return "input";
	}

	/***
	 * 添加分类属性
	 * 
	 * @return
	 */
	public String insertattr() {

		category = categoryService.getEntityById(new Long(cid));
		cname = category.getName();

		CategoryAttr obj = new CategoryAttr();
		obj.setAttrInput(attrinput);
		obj.setAttrName(attrname);
		obj.setAttrValue(attrvalue);
		obj.setOrdernum(0);
		obj.setCategory(category);

		/*
		 * 属性分类
		 */
//		AttrType attrType = new AttrType();
//		attrType.setId(attrTypeId);
//		obj.setAttrType(attrType);

		categoryAttrService.insert(obj);

		msg = SUCCESS;
		return "inputattr";
	}

	/***
	 * 初始化修改分类属性
	 * 
	 * @return
	 */
	public String infoattr() {
		categoryAttr = categoryAttrService.getEntityById(new Long(aid));
		category = categoryService.getEntityById(new Long(cid));
		cname = category.getName();
		return "infoattr";
	}

	/***
	 * 修改分类属性
	 * 
	 * @return
	 */
	public String updateattr() {

		category = categoryService.getEntityById(new Long(cid));
		cname = category.getName();
		categoryAttr = categoryAttrService.getEntityById(new Long(aid));
		categoryAttr.setAttrInput(attrinput);
		categoryAttr.setAttrName(attrname);
		categoryAttr.setAttrValue(attrvalue);

//		AttrType attrType = new AttrType();
//		attrType.setId(attrTypeId);
//		categoryAttr.setAttrType(attrType);

		categoryAttrService.update(categoryAttr);

		msg = SUCCESS;
		return "infoattr";
	}

	// /***
	// * 删除分类属性
	// * @return
	// */
	// @Action(results = { @Result(name = "tolist", location =
	// "/backmgr/categoryattr/category-attr-list.action")})
	// public String deleteattr(){
	// categoryAttr = categoryAttrService.getEntityById(new Long(aid));
	// categoryAttrService.delete(categoryAttr);
	// return "tolist";
	// }

	/***
	 * 初始化修改分类
	 * 
	 * @return
	 */
	public String info() {
		// categories = categoryService.getCategoryByFatherId(1L);
		category = categoryService.getEntityById(new Long(cid));
		cname = category.getName();
		remark = category.getRemark();
		fatherid = category.getCategory().getId().toString();

		treeString = "";// 清空
		treeString = categoryService.getTreeForSelect("from Category ", 0);

		log.info("cid------->" + cid);
		log.info("fatherid------->" + category.getCategory().getId());
		log.info("name------->" + category.getName());
		return "info";
	}

	/***
	 * 修改分类
	 * 
	 * @return
	 */
	// @Action(results = { @Result(name = "info", location =
	// "/backmgr/success.jsp")})
	@Override
	public String update() {

		log.info("cid------->" + cid);
		log.info("name------->" + cname);
		log.info("remark------->" + remark);
		log.info("fatherid------->" + fatherid);

		Category obj = new Category();
		Category pObj = new Category();
		pObj = categoryService.getEntityById(new Long(fatherid));
		obj = categoryService.getEntityById(new Long(cid));
		obj.setCategory(pObj);
		obj.setName(cname);
		obj.setRemark(remark);

		int level = categoryService.getLevel("from Category",Long.parseLong(fatherid));
		obj.setCategoryLevel(Integer.valueOf(level+2));
		
		categoryService.update(obj);

		fatherid = obj.getCategory().getId().toString();
		msg = SUCCESS;
		
		treeString = "";// 清空
		treeString = categoryService.getTreeForSelect("from Category ", 0);

		
		return "info";
	}

	
	/*************************************************
	 * 
	 * getter and setter
	 * 
	 *************************************************/
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryAttr getCategoryAttr() {
		return categoryAttr;
	}

	public void setCategoryAttr(CategoryAttr categoryAttr) {
		this.categoryAttr = categoryAttr;
	}

	public String getFatherid() {
		return fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getAttrvalue() {
		return attrvalue;
	}

	public void setAttrvalue(String attrvalue) {
		this.attrvalue = attrvalue;
	}

	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	public String getAttrinput() {
		return attrinput;
	}

	public void setAttrinput(String attrinput) {
		this.attrinput = attrinput;
	}

	public String getTreeString() {
		return treeString;
	}

	public void setTreeString(String treeString) {
		this.treeString = treeString;
	}

	public Long getAttrTypeId() {
		return attrTypeId;
	}

	public void setAttrTypeId(Long attrTypeId) {
		this.attrTypeId = attrTypeId;
	}

	public List<AttrType> getAttrTypes() {
		return attrTypes;
	}

	public void setAttrTypes(List<AttrType> attrTypes) {
		this.attrTypes = attrTypes;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


}
