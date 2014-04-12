package org.j2eeframework.startoon.web.actions.enterprise.booking;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Booking;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.BookingService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class BookingAction extends ServiceBaseManageAction<Booking, Long> {
	private static final long serialVersionUID = 3277264698387993718L;
	@Resource
	private BookingService bookingService;
	@Resource
	private EnterpriseService enterpriseService;
	
	private Booking booking;
	
	private Enterprise enterprise;

	private Long category1;
	private Long category2;
	private Long category3;
	private Long category4;

	@Override
	public IGenericService<Booking, Long> getGenericService() {
		return bookingService;
	}

	public Booking getModel() {
		return booking;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			booking = new Booking();
		} else {
			booking = bookingService.getEntityById(getRequestId());
		}
		
		enterprise = SysContext.getCurrentEnterpriserUser();
		
		booking.setReceiveEmail(enterprise.getBookingEmail());
		
	}

	public String insert() {
		
		Long categoryId = getRequestCategoryId();

		Category category = new Category();
		category.setId(categoryId);
		
		booking.setEnterprise(enterprise);
		booking.setCategory(category);
		
		enterprise = enterpriseService.getEntityById(enterprise.getId());
		enterprise.setBookingEmail(booking.getReceiveEmail());
		enterpriseService.update(enterprise);
		
		SysContext.setEnterpriseUser(enterprise);

		return super.insert();
	}

	private Long getRequestCategoryId() {
		Long categoryId = 0L;
		if (category3 != null && category3 != 0) {
			categoryId = category3;
		} else if (category2 != null && category2 != 0) {
			categoryId = category2;
		} else if (category1 != null && category1 != 0) {
			categoryId = category1;
		}
		return categoryId;
	}

	public Long getCategory1() {
		return category1;
	}

	public void setCategory1(Long category1) {
		this.category1 = category1;
	}

	public Long getCategory2() {
		return category2;
	}

	public void setCategory2(Long category2) {
		this.category2 = category2;
	}

	public Long getCategory3() {
		return category3;
	}

	public void setCategory3(Long category3) {
		this.category3 = category3;
	}

	public Long getCategory4() {
		return category4;
	}

	public void setCategory4(Long category4) {
		this.category4 = category4;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}
