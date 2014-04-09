package org.j2eeframework.startoon.web.actions.member.favorite;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Favorite;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.FavoriteService;
import org.j2eeframework.startoon.service.PostedProService;
import org.j2eeframework.startoon.service.SupplyService;


public class FavoriteListAction extends ServiceBasePaginationAction<Favorite, Long> {

	private static final long serialVersionUID = 3461640125061259625L;

	@Resource
	private FavoriteService favoriteService;
	@Resource
	private SupplyService supplyService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private PostedProService postedProService;
	
	@Override
	public IGenericService<Favorite, Long> getGenericService()	{
		return favoriteService;
	}


	@Override
	public void preExecute() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		
		getPager().getParamCondition().addParameter("enterpriseId", user.getId() + "");
	}
	
	@Override
	public String execute() {
		
		super.execute();
		
		int type = getPager().getParamCondition().getInteger("type");
		
		List<Favorite> favorites = getPager().getItems();
		
		if(type==0) {
			for(Favorite f : favorites) {
				Long supplyId = f.getEntityId();
				Supply supply = supplyService.getEntityById(supplyId);
				f.setSupply(supply);
			}
			return "supply";
		} else if(type==1) {
			for(Favorite f : favorites) {
				Long pid = f.getEntityId();
				PostedPro postedPro = postedProService.getEntityById(pid);
				f.setPostedPro(postedPro);
			}
			return "pro";
			
		} else if(type==2) {
			for(Favorite f : favorites) {
				Long eid = f.getEntityId();
				Enterprise ent = enterpriseService.getEntityById(eid);
				f.setEnt(ent);
			}
			return "enterprise";
			
		}
		
		return SUCCESS;
	}

}
