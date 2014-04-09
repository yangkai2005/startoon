package org.j2eeframework.startoon.web.actions.admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class CategorySortAction extends ActionSupport {
	private static final long serialVersionUID = -1275582708763253044L;
	
	private static final Log log = LogFactory.getLog(CategorySortAction.class);
	
	@Resource
	private CategoryService categoryService;
	private List<Category> categories;
	
	private String sortIds;
	
	private Long fatherId;
	
	
	@Override
	@Action(value="sort", results={@Result(name="success", location="/admin/category/category-sort.jsp")})
	public String execute() {
		categories = categoryService.getCategoryByFatherId(0L);
		return SUCCESS;
	}
	
	@Action(results={@Result(name="list", location="/admin/category/category-list.action" ,type="redirect")})
	public String sort() {
		
		if(sortIds!=null && sortIds.length()>0) {
			String[] ids = sortIds.split(",");
			
			for(String s : ids) {
				String[] arr = s.split("-");
				String id = arr[1], index = arr[0];
				Category c = categoryService.getEntityById(Long.parseLong(id));
				c.setOrderNo(Integer.parseInt(index));
				
				categoryService.update(c);
			}
		}
		
		return "list";
	}
	
	@Action(value="categoriesList", results={@Result(name="success", location="/admin/category/category-sort-list.jsp")})
	public String getCategoriesByFatherId() {
		categories = categoryService.getCategoryByFatherId(fatherId);
		return "success";
	}
	
	public String subCategory() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			
			String fid = request.getParameter("fatherId");
			Long fatherId = new Long(fid);
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
	
	public String subCategoryByLevel() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpServletRequest request = ServletActionContext.getRequest();
			String l = request.getParameter("level");
			int level = new Integer(l);
			List<Category> categories = categoryService.getCategoryByLevel(level);
			
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getSortIds() {
		return sortIds;
	}

	public void setSortIds(String sortIds) {
		this.sortIds = sortIds;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

}
