package org.j2eeframework.startoon.web.actions.admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.CategoryService;

public class CategoryAction extends ServiceBaseManageAction<Category, Long> {
	private static final long serialVersionUID = -1275582708763253044L;
	private static final Log log = LogFactory.getLog(CategoryAction.class);
	
	@Resource
	private CategoryService categoryService;
	private List<Category> categoryList;
	private Category category;
	private long fatherId;

	@Override
	public IGenericService<Category, Long> getGenericService() {
		return categoryService;
	}

	public Category getModel() {
		return category;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			category = new Category();
		} else {
			category = categoryService.getEntityById(getRequestId());
		}
		
		categoryList = categoryService.getCategoryByFatherId(0L);
	}
	
	@Override
	public String input() {
		categoryList = categoryService.getCategoryByFatherId(0L);
		for(Category c: categoryList) {
			log.debug(c);
		}
		return super.input();
	}
	
	/***
	 * Ajax调用，检查是否可以删除自定义分类属性
	 * 返回 1 不可删除,0 可删除
	 * @return
	 * @throws IOException
	 */
	public String deletecheck()throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();    
	       //设置字符集    
	       response.setCharacterEncoding("UTF-8");    
	       PrintWriter out = response.getWriter(); 
		try {
			if(categoryService.isExistsSupply(this.getRequestId())){
				out.println(1);
			}else{
				out.println(0);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			out.println(-1);
			log.error("query deletecheck error:"+e.getMessage());
		}
		
		return null;
	}
	
	public String subCategory() {
		
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			
			List<Category> categories = categoryService.getCategoryByFatherId(fatherId);
			
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for(Category category : categories) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("oV", category.getId() + "");
				map.put("oT", category.getName());
				list.add(map);
			}
			
			JSONObject json = new JSONObject();
			json.put("array", list);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			out.flush();
			log.debug(json.toString());
			
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
			return null;
		}
		
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
