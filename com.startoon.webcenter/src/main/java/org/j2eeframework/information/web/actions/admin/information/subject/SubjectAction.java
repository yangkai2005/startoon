package org.j2eeframework.information.web.actions.admin.information.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Subject;
import org.j2eeframework.information.service.SubjectService;

public class SubjectAction extends ServiceBaseManageAction<Subject, Long> {
	private static final long serialVersionUID = -6430130452190872461L;
	private static final Log log = LogFactory.getLog(SubjectAction.class);
	@Resource
	private SubjectService subjectService;
	private Subject subject;
	@Override
	public IGenericService<Subject, Long> getGenericService() {
		return subjectService;
	}

	public Subject getModel() {
		return subject;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			subject = new Subject();
		} else {
			subject = subjectService.getEntityById(getRequestId());
		}
	}

	@SuppressWarnings("null")
	public String online() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			subjectService.online(getRequestId());
			out.write("success");
		} catch (IOException e) {
			log.error("专题上线", e);
			out.write("fail");
		}
		out.flush();
		return null;
	}
	@SuppressWarnings("null")
	public String offline() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			subjectService.offline(getRequestId());
			out.write("success");
		} catch (IOException e) {
			log.error("专题下线", e);
			out.write("fail");
		}
		out.flush();
		return null;
	}

}
