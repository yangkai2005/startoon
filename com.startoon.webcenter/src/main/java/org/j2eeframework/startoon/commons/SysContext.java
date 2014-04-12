package org.j2eeframework.startoon.commons;

import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.Enterprise;

public class SysContext {

	public static final ThreadLocal<Enterprise> enterpriseUsers = new ThreadLocal<Enterprise>();
	public static final ThreadLocal<AdminUser> adminUsers = new ThreadLocal<AdminUser>();
	public static final ThreadLocal<String> identifies = new ThreadLocal<String>();

	public static void clear() {
		setAdminUser(null);
		setEnterpriseUser(null);
		setIdentify(null);
	}

	public static void setEnterpriseUser(Enterprise enterprise) {
		enterpriseUsers.set(enterprise);
	}
	
	public static Enterprise getCurrentEnterpriserUser() {
		return (Enterprise) enterpriseUsers.get();
	}
	
	
	public static void setAdminUser(AdminUser adminUser) {
		adminUsers.set(adminUser);
	}
	
	public static AdminUser getCurrentAdminUser() {
		return (AdminUser) adminUsers.get();
	}

	public static String getIdentify() {
		return identifies.get();
	}

	public static void setIdentify(String identify) {
		identifies.set(identify);
	}

}
