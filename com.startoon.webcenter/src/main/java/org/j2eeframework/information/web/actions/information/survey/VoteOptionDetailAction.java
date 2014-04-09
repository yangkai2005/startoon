package org.j2eeframework.information.web.actions.information.survey;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.VoteOption;
import org.j2eeframework.information.entity.VoteOptionDetail;
import org.j2eeframework.information.service.VoteOptionDetailService;
import org.j2eeframework.information.service.VoteOptionService;

public class VoteOptionDetailAction extends
		ServiceBaseManageAction<VoteOptionDetail, Long> {
	
	private static final long serialVersionUID = 952614258523803694L;
	
	@Resource
	private VoteOptionDetailService voteOptionDetailService;
	
	@Resource
	private VoteOptionService voteOptionService;
	
	private VoteOptionDetail voteOptionDetail;
	
	private String optionIds;

	@Override
	public IGenericService<VoteOptionDetail, Long> getGenericService() {
		return voteOptionDetailService;
	}

	public VoteOptionDetail getModel() {
		return voteOptionDetail;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			voteOptionDetail = new VoteOptionDetail();
		} else {
			voteOptionDetail = voteOptionDetailService
					.getEntityById(getRequestId());
		}
	}
	
	public String vote() throws IOException {
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse rsp = ServletActionContext.getResponse();

		String ip = req.getRemoteAddr();
		if(optionIds!=null) {
			
			String[] ids = optionIds.split(",");
			for(String id : ids) {
				Long optionId = new Long(id);
				VoteOption option = voteOptionService.getEntityById(optionId);
				
				VoteOptionDetail detail = new VoteOptionDetail();
				detail.setSourceIp(ip);
				detail.setOption(option);
				
				getGenericService().insert(detail);
				
				voteOptionService.addVoteOptionCount(option); //投票计算器加一
				
			}
		}
		
		rsp.setContentType("text/html;charset=utf-8");
		PrintWriter out = rsp.getWriter();
		out.write("success");
		out.flush();
		
		return null;
		
	}

	public String getOptionIds() {
		return optionIds;
	}

	public void setOptionIds(String optionIds) {
		this.optionIds = optionIds;
	}

}
