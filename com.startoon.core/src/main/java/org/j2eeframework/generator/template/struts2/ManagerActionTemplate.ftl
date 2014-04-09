package ${classPackagePath};

import javax.annotation.Resource;

import ${entityPackagePath}.${entityName};
import ${servicePackagePath}.${serviceName};
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class ${className} extends ServiceBaseManageAction<${entityName},Long>
{
	private static final long serialVersionUID = ${serialVersionUID}L;
	@Resource
	private ${serviceName} ${serviceVariableName};
	private ${entityName} ${entityVariableName};
	@Override
	public IGenericService<${entityName}, Long> getGenericService()
	{
		return ${serviceVariableName};
	}

	public ${entityName} getModel()
	{
		return ${entityVariableName};
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			${entityVariableName} = new ${entityName}();
		} else
		{
			${entityVariableName} = ${serviceVariableName}.getEntityById(getRequestId());
		}
	}

}
