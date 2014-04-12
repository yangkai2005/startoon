package org.j2eeframework.startoon.web.actions.member.booking;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Booking;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.BookingService;
import org.j2eeframework.startoon.service.CategoryService;


public class BookingListAction extends ServiceBasePaginationAction<Booking, Long> {

	private static final long serialVersionUID = -2307046544599333678L;

	@Resource
	private BookingService bookingService;
	@Resource
	private CategoryService categoryService;
	
	private List<Category> categories;
	
	@Override
	public IGenericService<Booking, Long> getGenericService()	{
		return bookingService;
	}

	@Override
	public void preExecute() {

		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		
		getPager().getParamCondition().addParameter("enterpriseId", ent.getId() + "");
		categories = categoryService.getCategoryByFatherId(0L);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
