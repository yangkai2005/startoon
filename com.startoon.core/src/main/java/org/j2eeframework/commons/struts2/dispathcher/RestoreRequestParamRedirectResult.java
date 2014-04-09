package org.j2eeframework.commons.struts2.dispathcher;

import org.apache.struts2.dispatcher.ServletActionRedirectResult;

public class RestoreRequestParamRedirectResult extends ServletActionRedirectResult {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2672891943137606365L;
	private boolean restore_params = false;

	public boolean isRestore_params() {
		return restore_params;
	}

	public void setRestore_params(boolean restoreParams) {
		restore_params = restoreParams;
	}

}
