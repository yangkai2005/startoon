package org.j2eeframework.generator;



public class Generator {

	public static void main(String[] args) {

		String basePackage = "org.j2eeframework.example";     //基础包路径
		String entityName = "Example";                          //实体名称
		String namespace = "/example";                       //struts2命名空间如/example/test            
		String namespacePackageStype = "example";            //struts2命名空间包路径形式如example.test
		
		GenerateUtil generator = new GenerateUtil(basePackage, entityName, namespace, namespacePackageStype);
		
		generator.generate();

	}

}
