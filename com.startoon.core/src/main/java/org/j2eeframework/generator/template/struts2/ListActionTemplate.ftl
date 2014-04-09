package ${classPackagePath};

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import ${entityPackagePath}.${entityName};
import ${servicePackagePath}.${serviceName};


public class ${className} extends ServiceBasePaginationAction<${entityName}, Long> {

	private static final long serialVersionUID = ${serialVersionUID}L;

	@Resource
	private ${serviceName} ${serviceVariableName};
	
	@Override
	public IGenericService<${entityName}, Long> getGenericService()	{
		return ${serviceVariableName};
	}

	@Override
	public void preExecute() {
		
	}

}
