package org.j2eeframework.startoon.web.actions.help;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Feedback;
import org.j2eeframework.startoon.entity.Help;
import org.j2eeframework.startoon.entity.Helpclass;
import org.j2eeframework.startoon.service.FeedbackService;
import org.j2eeframework.startoon.service.HelpService;
import org.j2eeframework.startoon.service.HelpclassService;

public class HelpAction extends ServiceBaseManageAction<Help,Long>
{
	private static final Log log = LogFactory.getLog(HelpAction.class);
	private static final long serialVersionUID = -2099525419191135739L;
	@Resource
	private HelpService helpService;
	@Resource
	private HelpclassService helpclassService;
	@Resource
	private FeedbackService feedbackService;
	private Help help;
	private List<Map<String,String>> list;	//顶级帮助中心分类
	@SuppressWarnings("unchecked")
	private List sublist;	//子级帮助中心分类
	private String ids;
	private String id;
	private String cid;
	private Help showhelp = new Help();
	private Helpclass helpclass = new Helpclass();
	
	private String name;
	private String phone;
	private String mobile;
	private String qq;
	private String company;
	private String msn;
	private String content;
	private String email;
	private String fax;
	private String message;
	
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

	@Override
	@Action(results = { @Result(name = "success", location = "/WEB-INF/content/help/index.jsp") })
	public String execute() {
		log.debug(">>>帮助中心首页.....");
		
		//帮助中心顶级目录
		list = helpService.getParentHelpclassList();
		
		return SUCCESS;
	}
	
	/***
	 * 帮助中心首页，右边二级分类及文章列表
	 * 
	 * @return
	 */
	public String list(){
		//@Action(results = { @Result(name = "fail", location = "/help/detail.jsp") })
		String str = "list";
		if(ids==null || ids.equals("")){
			ids = "1";	//默认为帮助中心
		}
		if(cid!=null && cid.equals("2")){//关于星力网
			help = helpService.getHelpByClassid(ids);
			showhelp = new Help();
			if(help!=null && help.getId()!=null){
				id = help.getId().toString();

				if(id!=null && !id.equals("")){
					showhelp = helpService.getEntityById(Long.valueOf(id));
				}
			}
			//帮助中心顶级目录
			list = helpService.getParentHelpclassList();
			str = "sdetail";
		}
		
		sublist = helpService.getHelpNewsList(ids);
		//helpclass = helpclassService.getEntityById(Long.valueOf(ids));
		
		return str;
	}
	
	//@Action(results = { @Result(name = "savefb", location = "/help/help.action", type="redirect") })
	public String saveFeedBack(){
		
		Feedback obj = new Feedback();
		obj.setName(name);
		obj.setPhone(phone);
		obj.setMobile(mobile);
		obj.setCompany(company);
		obj.setFax(fax);
		obj.setEmail(email);
		obj.setContent(content);
		obj.setQq(qq);
		obj.setMsn(msn);
		feedbackService.insert(obj);
		
		ids="6";
		message = "success";
		//帮助中心顶级目录
		list = helpService.getParentHelpclassList();
		
		return SUCCESS;
	}

	/***
	 * 帮助中心内页
	 * @return
	 */
	public String detail(){
		showhelp = new Help();
		if(id!=null && !id.equals("")){
			showhelp = helpService.getEntityById(Long.valueOf(id));
		}
		//帮助中心顶级目录
		list = helpService.getParentHelpclassList();
		return "detail";
	}
	
	public List<Map<String,String>> getList() {
		return list;
	}

	public void setList(List<Map<String,String>> list) {
		this.list = list;
	}

	@SuppressWarnings("unchecked")
	public List getSublist() {
		return sublist;
	}

	@SuppressWarnings("unchecked")
	public void setSublist(List sublist) {
		this.sublist = sublist;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Helpclass getHelpclass() {
		return helpclass;
	}

	public void setHelpclass(Helpclass helpclass) {
		this.helpclass = helpclass;
	}

	public Help getShowhelp() {
		return showhelp;
	}

	public void setShowhelp(Help showhelp) {
		this.showhelp = showhelp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
