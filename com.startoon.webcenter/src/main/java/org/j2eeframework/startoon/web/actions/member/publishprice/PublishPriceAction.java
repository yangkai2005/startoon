package org.j2eeframework.startoon.web.actions.member.publishprice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.PublishPrice;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.PostedProService;
import org.j2eeframework.startoon.service.PublishPriceService;

public class PublishPriceAction extends ServiceBaseManageAction<PublishPrice,Long>
{
	private static final long serialVersionUID = 6833890819999988250L;
	@Resource
	private PublishPriceService publishPriceService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private PostedProService postedProService;

	private PublishPrice publishPrice;
	
	private Enterprise receiver;
	
	private PostedPro postedPro;
	
	private Long receiverId;
	
	private Long pid;
	
	
	@Override
	public IGenericService<PublishPrice, Long> getGenericService()
	{
		return publishPriceService;
	}

	public PublishPrice getModel()
	{
		return publishPrice;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			publishPrice = new PublishPrice();
		} else
		{
			publishPrice = publishPriceService.getEntityById(getRequestId());
		}
		
		receiver = enterpriseService.getEntityById(receiverId);
		publishPrice.setReceiver(receiver);
		publishPrice.setSender(SysContext.getCurrentEnterpriserUser());
		
	}
	
	@Override
	public String input() {
		postedPro = postedProService.getEntityById(pid);
		publishPrice.setPostedPro(postedPro);
		return super.input();
	}
	
	
	@Override
	public String insert() {
		PostedPro p = new PostedPro();
		p.setId(pid);
		getModel().setPostedPro(p);
		getGenericService().insert(getModel());
		return "success";
	}

	public Enterprise getReceiver() {
		return receiver;
	}

	public void setReceiver(Enterprise receiver) {
		this.receiver = receiver;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public PublishPrice getPublishPrice() {
		return publishPrice;
	}

	public void setPublishPrice(PublishPrice publishPrice) {
		this.publishPrice = publishPrice;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}


}
