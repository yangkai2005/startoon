package org.j2eeframework.util;

import org.j2eeframework.generator.GenerateUtil;

public class Generator {

	public static void main(String[] args) {

		String basePackage = "org.j2eeframework.information"; // 基础包路径

		String entityName = "Advertisement"; // 实体名称
		String namespace = "/admin/information/adhit"; // struts2命名空间如/example/test
		String namespacePackageStype = "admin.information.adhit"; // struts2命名空间包路径形式如example.test

		GenerateUtil generator = new GenerateUtil(basePackage, entityName, namespace, namespacePackageStype);

		generator.generate();

	}

}
