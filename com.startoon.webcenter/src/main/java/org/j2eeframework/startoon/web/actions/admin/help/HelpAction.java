package org.j2eeframework.startoon.web.actions.admin.help;

import java.util.Date;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Help;
import org.j2eeframework.startoon.entity.Helpclass;
import org.j2eeframework.startoon.service.HelpService;

public class HelpAction extends ServiceBaseManageAction<Help,Long>
{
	private static final long serialVersionUID = 3166624234643870571L;
	@Resource
	private HelpService helpService;
	private Help help;
	private Help showhelp;
	private String treeString; // 树型
	private String msg; // 提示信息
	private String classid;	//类别ID
	private String title;
	private String content;
	private String cid;
	private String ids;
	
	public String getIds() {
		return ids;
	}

	public Help getShowhelp() {
		return showhelp;
	}

	public void setShowhelp(Help showhelp) {
		this.showhelp = showhelp;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getTreeString() {
		return treeString;
	}

	public void setTreeString(String treeString) {
		this.treeString = treeString;
	}

	@Override
	public IGenericService<Help, Long> getGenericService()
	{
		return helpService;
	}

	public Help getModel()
	{
		return help;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			help = new Help();
		} else
		{
			help = helpService.getEntityById(getRequestId());
		}
	}
	
	/***
	 * 初始化添加文章
	 * 
	 * @return
	 */
	@Override
	public String input() {
		treeString = "";// 清空
		treeString = helpService.getTreeForSelect();
		// log.info(treeString);
		return "input";
	}

	/***
	 * 添加文章
	 * 
	 * @return
	 */
	// @Action(results = { @Result(name = "success", location =
	// "/backmgr/success.jsp")})
	@Override
	public String insert() {

		Helpclass obj = new Helpclass();
		Help hobj = new Help();
		
		obj = helpService.getHelpclassById(Long.valueOf(classid));
		hobj.setCreateby("");
		hobj.setCreatetime(new Date());
		hobj.setHelpclass(obj);
		hobj.setTitle(title);
		hobj.setContent(content);
		helpService.insert(hobj);
		
		msg = SUCCESS;
		// treeString = "";//清空
		// treeString = categoryService.getTreeForSelect("from Category ", 0);

		return "input";
	}
	
	/***
	 * 初始化修改分类
	 * 
	 * @return
	 */
	public String info() {
		showhelp = helpService.getEntityById(new Long(ids));
		classid = showhelp.getHelpclass().getId().toString();
		treeString = "";// 清空
		treeString = helpService.getTreeForSelect();

		return "info";
	}
	
	/***
	 * 初始化修改分类
	 * 
	 * @return
	 */
	@Override
	public String update() {
		
		Helpclass obj = new Helpclass();
		Help hobj = new Help();
		hobj = helpService.getEntityById(Long.valueOf(ids));
		obj = helpService.getHelpclassById(Long.valueOf(classid));
		
		hobj.setHelpclass(obj);
		hobj.setTitle(title);
		hobj.setContent(content);
		helpService.update(hobj);
		
		showhelp = hobj;
		classid = showhelp.getHelpclass().getId().toString();
		treeString = "";// 清空
		treeString = helpService.getTreeForSelect();
		
		msg = SUCCESS;
		
		return "info";
	}

}
