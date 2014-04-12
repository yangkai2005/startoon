package org.j2eeframework.startoon.web.actions.backmgr.categoryattr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.service.CategoryAttrService;

public class CategoryAttrAction extends ServiceBaseManageAction<CategoryAttr, Long> {
	private static final long serialVersionUID = -1275582708763253044L;
	private static final Log log = LogFactory.getLog(CategoryAttrAction.class);
	
	@Resource
	private CategoryAttrService categoryAttrService;
	private CategoryAttr categoryAttr;
	private String msg;
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CategoryAttr getCategoryAttr() {
		return categoryAttr;
	}

	public void setCategoryAttr(CategoryAttr categoryAttr) {
		this.categoryAttr = categoryAttr;
	}

	@Override
	public IGenericService<CategoryAttr, Long> getGenericService() {
		return categoryAttrService;
	}

	public CategoryAttr getModel() {
		return categoryAttr;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			categoryAttr = new CategoryAttr();
		} else {
			categoryAttr = categoryAttrService.getEntityById(getRequestId());
		}
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
			if(categoryAttrService.isExistsSupply(this.getRequestId())){
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
//	@Override
//	//@Action(results = { @Result(name = "success", location = "${pageContext.request.contextPath}/backmgr/categoryattr/category-attr-list.action?cid=${cid}&restore_params=true") })
//	public String delete(){
//		 msg = "";
//		if(!categoryAttrService.isExistsSupply(this.getRequestId())){
//			CategoryAttr obj = categoryAttrService.getEntityById(this.getRequestId());
//			categoryAttrService.delete(obj);
//		}else{
//			msg = "fail";
//		}
//		return SUCCESS;
//	}
	
}
