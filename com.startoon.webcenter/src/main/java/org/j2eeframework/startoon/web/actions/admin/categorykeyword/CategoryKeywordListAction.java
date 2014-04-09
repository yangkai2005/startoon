package org.j2eeframework.startoon.web.actions.admin.categorykeyword;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.service.CategoryKeywordService;


public class CategoryKeywordListAction extends ServiceBasePaginationAction<CategoryKeyword, Long> {

	private static final long serialVersionUID = -2904319042547667458L;

	@Resource
	private CategoryKeywordService categoryKeywordService;
	
	@Override
	public IGenericService<CategoryKeyword, Long> getGenericService()	{
		return categoryKeywordService;
	}

	@Override
	public void preExecute() {
		
	}
	
	@Override
	public String execute() {
		
		super.execute();
//		List<CategoryKeyword> categoryKeywords = getPager().getItems();
//		List<CategoryKeyword> items = generate(categoryKeywords);
//		getPager().setItems(items);		
		return SUCCESS;
		
	}
	
	private List<CategoryKeyword> generate(List<CategoryKeyword> categoryKeywords) {
		
		List<CategoryKeyword> list = new ArrayList<CategoryKeyword>(15);
		
		
		for(int i=0; i<15; i++) {
			CategoryKeyword ck = null;
			if(exist(categoryKeywords, i+1)) {
				ck = getCategoryKeywordByRank(categoryKeywords, i+1);
			} else {
				ck = new CategoryKeyword();
				ck.setRank(i+1);
			}
			list.add(i, ck);
		}
		return list;
	}
	
	private boolean exist(List<CategoryKeyword> categoryKeywords, int rank) {
		boolean b = false;
		for(CategoryKeyword c : categoryKeywords) {
			int r = c.getRank();
			if(rank == r) {
				b = true;
				break;
			}
		}
		return b;
	}
	
	private CategoryKeyword getCategoryKeywordByRank(List<CategoryKeyword> categoryKeywords, int rank) {
		CategoryKeyword ck = null;
		for(CategoryKeyword c : categoryKeywords) {
			int r = c.getRank();
			if(rank == r) {
				ck = c;
				break;
			}
		}
		return ck;
	}

}
