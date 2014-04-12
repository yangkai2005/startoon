package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IHelpDAO;
import org.j2eeframework.startoon.dao.IHelpclassDAO;
import org.j2eeframework.startoon.entity.Help;
import org.j2eeframework.startoon.entity.Helpclass;
import org.springframework.stereotype.Service;

@Service
public class HelpService extends AbstractService<Help, Long, IHelpDAO>
{
	@Resource
	private IHelpDAO helpDAO;
	
	@Resource
	private IHelpclassDAO helpclassDAO;
	
	private StringBuffer sbTree = new StringBuffer("");
	private static final Log log = LogFactory.getLog(HelpService.class);
	public long cid;
	public String cname;
	public long parentId;
	int level=0;
	@Override
	public IHelpDAO getGenericDAO()
	{
		return helpDAO;
	}
	
	//用递归算法，显示分类之间的父子关系(用于下拉列表)
	@SuppressWarnings("unchecked")
	public String getTreeForSelect(){
		try{
			sbTree = new StringBuffer("");
			String sql2="from Helpclass where parentid=0";
			List list = helpDAO.findByHql(sql2);
			if(list != null && !list.isEmpty()){//begin if
				for(int j=0;j<list.size();j++){//begin for
					cid = ((Helpclass)list.get(j)).getId().longValue();
					cname = ((Helpclass)list.get(j)).getClassname();
	
					sbTree.append("<optgroup label=\""+cname+"\">");
					sql2 = " from Helpclass where parentid=" + cid;
					List tmpList = helpDAO.findByHql(sql2);
					if(tmpList != null && tmpList.size()>0){
						
						for(int k=0;k<tmpList.size();k++){
							Helpclass tmpobj = (Helpclass)tmpList.get(k);
							sbTree.append("<option value=\""+tmpobj.getId()+"\">" + tmpobj.getClassname() + "</option>");
						}
					}
					sbTree.append("</optgroup>");
		
				}//end for
			}//end if
		}catch(Exception e){
			e.printStackTrace();
			log.error("getTree:"+e.getMessage());
		}
		return sbTree.toString();
	}

	/***
	 * 获取帮助中心的顶级类别
	 * @return
	 */
//	public List<Helpclass> getParentHelpclassList(){
//		List<Helpclass> list = helpDAO.findByHql("from Helpclass where parentid=0 order by sortnum");
//		
//		return list;
//	}
	
	/***
	 * 获取帮助中心的顶级类别
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> getParentHelpclassList(){
		List<Map<String,String>> returnList = new ArrayList();
		List list = helpDAO.findByHql("from Helpclass where parentid=0 order by sortnum");
		if(list != null && !list.isEmpty()){
			for(int i=0;i<list.size();i++){
				Map map = new HashMap();
				Helpclass obj = (Helpclass)list.get(i);
				map.put("helpclass", obj);
				List tmplist = this.getSubHelpList(obj.getId().toString());
				map.put("sublist", tmplist);
				returnList.add(map);
			}
		}
		
		return returnList;
	}
	
	/***
	 * 根据父级Id获取帮助中心的二级类别
	 * @param parentid: 
	 * @return
	 */
	public List getSubHelpList(String parentid){
		List list = helpDAO.findByHql("from Helpclass where parentid="+parentid+" order by sortnum");
		return list;
	}
	
	
	/***
	 * 根据父级Id获取帮助中心的二级类别
	 * @param parentid: 
	 * @return
	 */
	public List getHelpNewsList(String parentid){
		List newslist = helpDAO.findByHql("from Help where classid="+parentid);
		return newslist;
	}
	
	/***
	 * 根据classid获取此类别下的首条新闻(用于帮助中心的关于星力网)
	 * @param cid: 
	 * @return
	 */
	public Help getHelpByClassid(String ids){
		List newslist = helpDAO.findByHql("from Help where classid="+ids);
		Help help = new Help();
		if(newslist!=null && !newslist.isEmpty()){
			help = (Help)newslist.get(0);
		}
		return help;
	}
	
	/***
	 * 根据父级Id获取帮助中心的二级类别
	 * @param parentid: 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getSubHelpclassList(String parentid){
		List returnList = new ArrayList();
		Map map = null;
		
		List list = helpDAO.findByHql("from Helpclass where parentid="+parentid+" order by sortnum");
		if(list != null && !list.isEmpty()){
			for(int i=0;i<list.size();i++){
				Helpclass helpc = (Helpclass)list.get(i);
				map = new HashMap();
				
				//子分类对象
				map.put("helpclass", helpc);
				
				//子分类文章列表
				List newslist = helpDAO.findByHql("from Help where helpclass.id="+helpc.getId());
				if(newslist != null){log.info(helpc.getClassname() + "-----------newslist count: " + newslist.size());}
				map.put("newslist", newslist);
				returnList.add(map);	//子分类对象
			}
		}
		
		return returnList;
	}
	
	public Helpclass getHelpclassById(Long id){
		Helpclass obj = helpclassDAO.getEntityById(id);
		return obj;
	}
	
}
