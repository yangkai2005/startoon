package org.j2eeframework.startoon.util.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.SystemContext;
import org.j2eeframework.startoon.entity.Config;
import org.j2eeframework.startoon.service.ConfigService;

public class ConfigTag extends SimpleTagSupport {

	private static final Log log = LogFactory.getLog(ConfigTag.class);

	private String key;

	@Override
	public void doTag() throws JspException, IOException {

		JspContext ctx = getJspContext();
		ConfigService configService = (ConfigService) SystemContext.getApplicationContext().getBean("configService");

		Config config = configService.getBySkey(key);

		if (config != null) {
			log.debug(key + ":" + config);
			ctx.getOut().write(config.getSvalue());
		} else {
			log.info("键对应的值不存在！");
		}

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}