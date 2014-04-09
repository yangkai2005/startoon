package org.j2eeframework.startoon.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.commons.SystemVariables;

public class AdImgTag extends SimpleTagSupport {

	private static final Log log = LogFactory.getLog(AdImgTag.class);

	private String name;

	@Override
	public void doTag() throws JspException, IOException {
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();

		if (null != ctx.getAttribute(SystemVariables.AD_IMAGE + name)) {
			String adImg = (String) ctx.getAttribute(SystemVariables.AD_IMAGE + name);
			log.debug(">>>广告图片[" + adImg + "]");
			out.write(adImg);
		} else {
			log.warn("广告图片不存在[" + name + "]");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}