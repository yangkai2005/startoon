package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.commons.util.SystemContext;
import org.j2eeframework.startoon.dao.ICategoryDAO;
import org.j2eeframework.startoon.dao.hibernate.CategoryDAOImpl;
import org.j2eeframework.startoon.entity.Category;
import org.springframework.stereotype.Service;

@SuppressWarnings("unchecked")
@Service
public class CategoryService extends AbstractService<Category, Long, ICategoryDAO> {
	@Resource
	private ICategoryDAO categoryDAO;
	
	private static final Log log = LogFactory.getLog(CategoryService.class);

	@Override
	public ICategoryDAO getGenericDAO() {
		return categoryDAO;
	}
	
	public long parentId;
	int level=0;
	public long cid;
	public String cname;
	private StringBuffer sbTree = new StringBuffer("");
	
	private List<Category> listCategories = new ArrayList<Category>();
	
	public List<Category> getListCategories() {
		return listCategories;
	}

	
	public void setListCategories(List<Category> listCategories) {
		this.listCategories = listCategories;
	}

	public List<Category> getCategoryByFatherId(Long fatherId) {
		ParamCondition paramCondition = new ParamCondition();
		paramCondition.addParameter("fatherId", fatherId + "");
		return getGenericDAO().getEntitiesByParamCondition(paramCondition, 0, 100);
	}
	
	public List<Category> getCategoryByFatherId(Long fatherId, int size) {
		ParamCondition paramCondition = new ParamCondition();
		paramCondition.addParameter("fatherId", fatherId + "");
		return getGenericDAO().getEntitiesByParamCondition(paramCondition, 0, size);
	}
	
	public List<Category> getCategoriesByFatherId(Long fatherCategoryId) {
		return categoryDAO.getCategoriesByFatherId(fatherCategoryId);
	}
	
	public List<Category> getAllSubCategoryById(long id) {
		return getListById(" from Category ", id, true);
//		return getSubCategory(id);
	}
	
	
	//用递归算法,获得某一个分类的等级,0为顶级分类
	public int getLevel(String sql,long Id){
		try{
			String sql2=sql+" where id="+Id;
			List list = categoryDAO.findByHql(sql2);
			if(list != null && !list.isEmpty()){
				Iterator it = list.iterator();
				while(it.hasNext()){
					parentId = Long.parseLong(((Category)it.next()).getCategory().getId().toString());
				}
			}
		
		}catch(Exception e){
			log.error("getLevel:"+e.getMessage());
		}
		while(parentId!=0){
			level++;                   //level为全局变量,其他函数使用完后都应清零
			getLevel(sql,parentId);    ////递归
		}
		return level;
	}

	//检测当前分类是否为最底层的分类
	public boolean isLast(String sql,long Id){
		boolean last=false;
		try{
			String sql2=sql+" where category.id="+Id;
			List list = categoryDAO.findByHql(sql2);
			if(list != null && list.size()>0){
				last = false;
			}else{
				last = true;
			}
		}catch(Exception e){
			log.error("isLast:"+e.getMessage());
		}	
		return last;
	}	

	/***
	 * 根据ID返回此ID下的所有子集
	 * @param sql
	 * @param parentId
	 * @return
	 */
	public List<Category> getListById(String sql,long parentId,boolean initFlag){
		if (initFlag==true)listCategories = new ArrayList();//清空操作
		initFlag = false;
		try{
			String sql2=sql+" where is_delete=0 and name!='root' and category.id="+parentId;
			List list = categoryDAO.findByHql(sql2);
			if(list != null && !list.isEmpty()){
				for(int j=0;j<list.size();j++){
					listCategories.add((Category)list.get(j));
					getListById(sql,((Category)list.get(j)).getId(),initFlag);                  //递归
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("getListById:"+e.getMessage());
		}
		return listCategories;
	}
	
	//用递归算法，显示分类之间的父子关系
	public String getTree(String sql,long parentId){
		if (parentId==0)sbTree = new StringBuffer("");//清空操作
		int printCount=0;
		String li="";
		try{
			String sql2=sql+" where is_delete=0 and name!='root' and category.id="+parentId;
			List list = categoryDAO.findByHql(sql2);
			if(list != null && !list.isEmpty()){
				for(int j=0;j<list.size();j++){
					cid = ((Category)list.get(j)).getId().longValue();
					cname = ((Category)list.get(j)).getName();
					printCount=getLevel(sql,cid);
					
					for(int i=0;i<printCount;i++)
						sbTree.append("&nbsp;&nbsp;&nbsp;&nbsp;");
					if(level==0){
						sbTree.append("+");
					}else if(isLast(sql,cid)){ 
						sbTree.append("|--");
					}else{
					    sbTree.append("|--");
					}
					
					sbTree.append(li+cname+"<br/>");
					level=0;                       //level为全局变量,其他函数使用完后都应清零
					
					getTree(sql,cid);                  //递归
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("getTree:"+e.getMessage());
		}
		return sbTree.toString();
	}
	
	
	//用递归算法，显示分类之间的父子关系(用于下拉列表)
	public String getTreeForSelect(String sql,long parentId){
		if (parentId==0)sbTree = new StringBuffer("");//清空操作
		int printCount=0;
		try{
			String sql2=sql+" where is_delete=0 and name!='root' and category.id="+parentId;
			List list = categoryDAO.findByHql(sql2);
			if(list != null && !list.isEmpty()){
				for(int j=0;j<list.size();j++){
					cid = ((Category)list.get(j)).getId().longValue();
					cname = ((Category)list.get(j)).getName();
					printCount=getLevel(sql,cid);
					sbTree.append("<option value=\""+cid+"\">");
					for(int i=0;i<printCount;i++)
						sbTree.append("&nbsp;&nbsp;&nbsp;&nbsp;");
					if(level==0){
						sbTree.append("");
					}else if(isLast(sql,cid)){ 
						sbTree.append("|--");
					}else{
					    sbTree.append("|--");
					}
					
					sbTree.append(cname+"</option>");
					level=0;                       //level为全局变量,其他函数使用完后都应清零
					
					getTreeForSelect(sql,cid);                  //递归
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("getTree:"+e.getMessage());
		}
		return sbTree.toString();
	}

	public Category getAllCategoryByTree() {
		
		return null;
	}
	
	/**
	 * 根据类别ID查询所有的类别
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<Category> getAllSubCategory(long categoryId) {
		SubCategory subCategory = new SubCategory();
		subCategory.getCategoryById(categoryId);
		List<Category> list = subCategory.getCategories();
		return list;
	}
	
	/**
	 * 根据当前ID查询一级父类别
	 * @param currentCategoryId
	 * @return
	 */
	public Category getTopCategory(long currentCategoryId) {
		
		Category c = getEntityById(currentCategoryId);
		Category c1 = null;
		if(c.getCategory().getId()==0L) {
			return c; 
		} else {
			Long fid = c.getCategory().getId();
			c1 = getTopCategory(fid);
		}
		
		return c1;
		
	}
	
	/**
	 * 获取所有的父类别
	 * @param cid
	 * @return
	 */
	public List<Category> getFatherCategories(Long cid) {
		FatherCategory fc = new FatherCategory();
		fc.getCategoryById(cid);
		return fc.getCategories();
	}
	
	/***
	 * 判断分类是否已被引用
	 * 返回true表示已被引用，false 表示未被引用
	 * @param id
	 * @return
	 */
	public boolean isExistsSupply(Long id){
		boolean flag = false;
		
		List list = categoryDAO.executeQuery("select count(*) as total from supply where is_delete=0 and category_id = " + id);
		if(list != null && !list.isEmpty()){
			
			if(Integer.parseInt(list.get(0).toString())>0){
				flag = true;
			}
		}
		list = categoryDAO.executeQuery("select count(*) as total from category where is_delete=0 and father_id = " + id);
		if(list != null && !list.isEmpty()){
			if(Integer.parseInt(list.get(0).toString())>0){
				flag = true;
			}
		}
		
		return flag;
	}


	/**
	 * 根据当前类别ID查询相应的类别
	 * 如果是底层，就找相同的类别
	 * 如果不是，就直接找子类别
	 * @param categoryId
	 * @return
	 */
	public List<Category> getCategory4Filter(Long categoryId) {
		
		List<Category> categories = new ArrayList<Category>();
		
		Category category = getGenericDAO().getEntityById(categoryId);
		
		int level = category.getCategoryLevel();
		if(level==3 || level==4) {
			Category fatherCategory = category.getCategory();
			Long fid = fatherCategory.getId();
			categories = getAllSubCategory(fid);
		} else {
			categories = getAllSubCategory(categoryId);
		}
		
		return categories;
	}


	public List<Category> getCategoryByLevel(int level) {
		return categoryDAO.getCategoryByLevel(level);
	}
	
	public List<Long> findCategoryIdByName(String name) {
		
		ParamCondition condition = new ParamCondition();
		condition.addParameter("cname", name);
		
		List<Category> categories = categoryDAO.getEntitiesByParamCondition(condition, 0, 1000);
		
		List<Long> ids = new ArrayList<Long>();
		for(Category category : categories) {
			ids.add(category.getId());
		}
		
		return ids;
		
	}
	
}


/**
 * 查询所有父类别的类
 * @author Administrator
 *
 */
class FatherCategory {
	private ICategoryDAO categoryDAO = (CategoryDAOImpl)SystemContext.getApplicationContext().getBean("categoryDAOImpl");
	
	private List<Category> categories = new ArrayList<Category>();
	
	public void getCategoryById(Long id) {
		Category c = categoryDAO.getEntityById(id);
		categories.add(c);
		if(c.getId()!=0) {
			getCategoryById(c.getCategory().getId());
		}
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
}


/**
 * 
 * 查询所有子类别的类
 * 
 * @author Administrator
 *
 */
class SubCategory {
	
	private ICategoryDAO categoryDAO = (CategoryDAOImpl)SystemContext.getApplicationContext().getBean("categoryDAOImpl");
	
	private List<Category> categories = new ArrayList<Category>();
	
	public void getCategoryById(Long id) {
		Category c = categoryDAO.getEntityById(id);
		categories.add(c);
		
		List<Category> subCategories =  getCategoryByFatherId(c.getId());
		
		if(subCategories!=null && subCategories.size()>0) {
			for(Category category : subCategories) {
				getCategoryById(category.getId());
			}
		}
	}
	
	public List<Category> getCategoryByFatherId(Long fatherId) {
		ParamCondition paramCondition = new ParamCondition();
		paramCondition.addParameter("fatherId", fatherId + "");
		return categoryDAO.getEntitiesByParamCondition(paramCondition, 0, 1000);
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
}
