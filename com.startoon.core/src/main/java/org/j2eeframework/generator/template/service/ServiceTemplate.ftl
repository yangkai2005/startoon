package ${classPackagePath};

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import ${daoInterfacePackagePath}.${daoInterfaceName};
import ${entityPackagePath}.${entityName};

@Service
public class ${className} extends AbstractService<${entityName}, Long, ${daoInterfaceName}>
{
	@Resource
	private ${daoInterfaceName} ${daoVariableName};

	@Override
	public ${daoInterfaceName} getGenericDAO()
	{
		return ${daoVariableName};
	}
}
