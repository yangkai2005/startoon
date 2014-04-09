package org.j2eeframework.startoon.web.actions.member.supply;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.commons.Unit;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.entity.SupplyParam;
import org.j2eeframework.startoon.service.CategoryAttrService;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.EntProduceService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.SupplyParamService;
import org.j2eeframework.startoon.service.SupplyService;
import org.j2eeframework.startoon.util.ImageUtil;


@Result(name = "list", location = "/member/supply/supply-list.action?flag=${errorMessage}", type = "redirect")
public class SupplyAction extends ServiceBaseManageAction<Supply, Long> {
	private static final long serialVersionUID = -6457878022077660442L;
	private static final Log log = LogFactory.getLog(SupplyAction.class);
	@Resource
	private SupplyService supplyService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private EntProduceService entProduceService;
	@Resource
	private SupplyParamService supplyParamService;
	@Resource
	private CategoryAttrService categoryAttrService;
	@Resource
	private EnterpriseService enterpriseService;

	private Supply supply;

	private long categoryId;
	private long fatherId;
	
	private Long category1;
	private Long category2;
	private Long category3;
	private Long category4;
	
	private int recommend;
	
	private String ids;	
	
	private List<Category> categories;
	
	private List<Map<String, String>> units;
	
	private String categoryStr;
	
	private List<CategoryAttr> categoryAttrs;
	
	/**
	 * 上传图片文件
	 */
    private List<File> upload;
    private List<String> uploadFileName;
    
    //修改图片
    private File upload1;
    private String upload1FileName;
    private File upload2;
    private String upload2FileName;
    private File upload3;
    private String upload3FileName;
    /**
     * 参数
     */
    List<Long> categoryAttrId;
    List<String> paramKey;
    List<String> paramValue;
    private String unitname;	//单位名称
    
	/**
     * 编辑的参数 
     */
    private List<SupplyParam> supplyParams;
    
    /**
     * 删除多个ID
     */
    private List<Long> supplyIds;
    
    /**
     * 当前企业ID
     */
    private Long enterpriseId;
    
    private String errorMessage;
    
    

	@Override
	public IGenericService<Supply, Long> getGenericService() {
		return supplyService;
	}

	public Supply getModel() {
		return supply;
	}

	public void prepare() throws Exception {
		try {
			if (getRequestId() == null || getRequestId() == 0) {
				supply = new Supply();
			} else {
				supply = supplyService.getEntityById(getRequestId());
			}
			
			categories = categoryService.getCategoryByFatherId(0L);
			
			units = Unit.getInstance().getUnits();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 修改产品
	 */
	@Override
	public String edit() {

		Category fc1 = null, fc2 = null, fc3 = null, fc4 = null;
		String cstr = "";
		
		
		fc1 = supply.getCategory();
		cstr = fc1.getName();
		
		fc2 = fc1.getCategory();
		if(fc2!=null && fc2.getId()!=0) {
			cstr = fc2.getName() + "->" + cstr;
			fc3 = fc2.getCategory();
		} 
		if(fc3!=null && fc3.getId()!=0) {
			cstr = fc3.getName() + "->" + cstr;
			fc4 = fc3.getCategory();
		} 
		if(fc4!=null && fc4.getId()!=0) {
			cstr = fc4.getName() + "->" + cstr;
		}
		
		categoryStr = cstr;
		
		//产品参数
		supplyParams = supplyParamService.getSupplyParamBySupplyId(getRequestId());
		
		return super.edit();
	}

	@Override
	public String input() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		Long uid = user.getId();
		boolean b = supplyService.canPublish(uid);
		
		if(!b)
			return "tips";
		
		return super.input();
	}
	
	/**
	 * 删除产品
	 * 
	 * @return
	 */
	@Override
	public String delete() {
		if(ids!=null && !ids.equals("")){
			ids = ids.substring(0,ids.length()-1);
			supplyService.deleteMuti(ids);
		}
		
		errorMessage = "delete";
		
		return "list";
	}

	/**
	 * 删除多条记录
	 * @return
	 */
	public String deleteAll() {
		for(Long id : supplyIds) {
			supplyService.delete(id);
		}
		
		errorMessage = "delete";
		
		return "list";
	}
	
	private Long getRequestCategoryId() {
		Long categoryId = 0L;
		if(category4!=null && category4!=0) {
			categoryId = category4;
		} else if(category3!=null && category3!=0) {
			categoryId = category3;
		} else if(category2!=null && category2!=0) {
			categoryId = category2;
		} else if(category1!=null && category1!=0) {
			categoryId = category1;
		}
		return categoryId;
	}
	
	@Override
	public String update() {
		
		//获取产品名称的拼音第一个字母
		String pinyin = supply.getNamePinyinByName();
		String firstPinyin = supply.getNameFirstPinyinByName();
		supply.setNamePinyin(pinyin);
		supply.setNameFirstPinyin(firstPinyin);
		
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		enterpriseId = enterprise.getId();
		
		Long categoryId = getRequestCategoryId();
		if(categoryId!=0) {
			Category category = new Category();
			category.setId(categoryId);
			supply.setCategory(category);
		}
		
		StringBuffer attrs = new StringBuffer();
		if(paramKey!=null) {
			int size = paramKey.size();
			for(int i = 0; i<size; i++) {
				String key = paramKey.get(i), value = paramValue.get(i);
				Long caid = categoryAttrId.get(i);
				
				attrs.append("#" + caid + "#");
				attrs.append("#" + key + "#");
				attrs.append("#" + value + "#");
			}
			log.debug("自定义属性字符串：" + attrs.toString());
			supply.setAttrContent(attrs.toString());
		}
		
		//修改图片
		if(upload1!=null) {
			File upl = upload1;
			ImageUtil.pressText(upl);
			String uplName = upload1FileName;
			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);
			supply.setProductImgUrl(fileItemInfo.getFileId());
		}
		
		if(upload2!=null) {
			File upl = upload2;
			ImageUtil.pressText(upl);
			String uplName = upload2FileName;
			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);
			supply.setImgUrl2(fileItemInfo.getFileId());
		}
		
		if(upload3!=null) {
			File upl = upload3;
			ImageUtil.pressText(upl);
			String uplName = upload3FileName;
			IFileSystem fileSystem = new LocalFileSystem();
			String extension = FilenameUtils.getExtension(uplName);
			FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);
			supply.setImgUrl3(fileItemInfo.getFileId());
		}
		
		
		if(paramKey!=null) {
			//将之前的自定义属性删除
			supplyParamService.deleteBySupplyId(supply.getId());
			
			int size = paramKey.size();
			for(int i = 0; i<size; i++) {
				String key = paramKey.get(i), value = paramValue.get(i);
				SupplyParam param = new SupplyParam();
				param.setSupply(supply);
				param.setPkey(key);
				param.setPvalue(value);
				
				supplyParamService.insert(param);
			}
		}
		
		
		//更改状态为未审核
		supply.setStatus(0);
		super.update();
		
		errorMessage = "update";
		
		return "list";
	}
	
	/**
	 * 保存数据
	 * 
	 * @return
	 */
	@Override
	public String insert() {
		
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		enterpriseId = enterprise.getId();
		
		Long categoryId = getRequestCategoryId();
		
		Category category = new Category();
		category.setId(categoryId);
		
		entProduceService.add(enterprise.getId(), categoryId);
		
		supply.setCreator(enterprise);
		supply.setCategory(category);
		
		//获取产品名称的拼音第一个字母
		String pinyin = supply.getNamePinyinByName();
		String firstPinyin = supply.getNameFirstPinyinByName();
		supply.setNamePinyin(pinyin);
		supply.setNameFirstPinyin(firstPinyin);
		
		if(upload!=null) {
			int size = upload.size();
			for(int i=0; i<size; i++) {
				File upl = upload.get(i);
				ImageUtil.pressText(upl);
				String uplName = uploadFileName.get(i);
				IFileSystem fileSystem = new LocalFileSystem();
				String extension = FilenameUtils.getExtension(uplName);
				FileItemInfo fileItemInfo = fileSystem.saveFile(upl, extension, SystemConfig.UPLOAD_FILE_DIR);
				if(i==0) {
					supply.setProductImgUrl(fileItemInfo.getFileId());
				} else if(i==1) {
					supply.setImgUrl2(fileItemInfo.getFileId());
				} else if(i==2) {
					supply.setImgUrl3(fileItemInfo.getFileId());
				}
			}
		}
		
		StringBuffer attrs = new StringBuffer();
		if(paramKey!=null) {
			int size = paramKey.size();
			for(int i = 0; i<size; i++) {
				String key = paramKey.get(i), value = paramValue.get(i);
				Long caid = categoryAttrId.get(i);
				
				attrs.append("#" + caid + "#");
				attrs.append("#" + key + "#");
				attrs.append("#" + value + "#");
			}
			log.debug("自定义属性字符串：" + attrs.toString());
			supply.setAttrContent(attrs.toString());
		}
		
		super.insert();
		
		if(paramKey!=null) {
			int size = paramKey.size();
			for(int i = 0; i<size; i++) {
				String key = paramKey.get(i), value = paramValue.get(i);
				Long caid = categoryAttrId.get(i);
				
				SupplyParam param = new SupplyParam();
				param.setSupply(supply);
				param.setPkey(key);
				param.setPvalue(value);
				
				CategoryAttr categoryAttr = new CategoryAttr();
				categoryAttr.setId(caid);
				
				param.setCategoryAttr(categoryAttr);
				
				supplyParamService.insert(param);
			}
		}
		
		/*
		 * 将企业和类别关键字关联上
		 */
		List<Category> categories = categoryService.getFatherCategories(categoryId);
		enterprise = enterpriseService.getEntityById(enterprise.getId());
		for(Category c : categories) {
			enterprise.appendCategoryId(c.getId() + "");
			enterprise.appendCategoryKey(c.getName());
		}
		
		enterpriseService.update(enterprise);
		SysContext.setEnterpriseUser(enterprise);
		
//		int i = 0;
//		for(File file : uploads) {
//			String fileName = uploadFileNames.get(i);
//			
//			IFileSystem fileSystem = new LocalFileSystem();
//			String extension = FilenameUtils.getExtension(fileName);
//			FileItemInfo fileItemInfo = fileSystem.saveFile(file, extension, SystemConfig.UPLOAD_FILE_DIR);
//			
//			SupplyImg img = new SupplyImg();
//			img.setImgUrl(fileItemInfo.getFileId());
//			img.setSupply(supply);
//			
//			supplyImgService.insert(img);
//			
//			i++;
//		}
		
		errorMessage = "insert";
		
		return "list";
	}
	
	public String recommend() {
		supply.setIsRecommend(recommend);
		getGenericService().update(supply);
		return ResultConstants.LIST;
	}
	
	public String subCategory() {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			
			List<Category> categories = categoryService.getCategoryByFatherId(fatherId);
			
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for(Category category : categories) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("oV", category.getId() + "");
				map.put("oT", category.getName());
				list.add(map);
			}
			
			JSONObject json = new JSONObject();
			json.put("array", list);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			out.flush();
			log.debug(json.toString());
			
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
			return null;
		}
	}

	public String properties() {
		
		log.debug("%%%类别ID：" + categoryId);
		
		List<Category> fcs = categoryService.getFatherCategories(categoryId);
		
		for (Category category : fcs) {
			if(category != null){
				int level = category.getCategoryLevel();
				
				if(level>1) {
					if(categoryAttrs==null) {
						categoryAttrs = new ArrayList<CategoryAttr>();
					}
					List<CategoryAttr> cas = categoryAttrService.getCategoryAttrsByCategoryId(category.getId());
					categoryAttrs.addAll( cas );
				}
			}
		}
		
		if(categoryAttrs!=null)
			log.debug(categoryAttrs.size());
		else
			log.debug("查不到对于的数据");
		
		return "properties";
	}
	
	
	/**
     * 当上传文件大小大于struts.multipart.maxSize提示时,
     * 客户端会出现如下错误:
     * "the request was rejected because its size (4501994) 
     * exceeds the configured maximum (2097152)"。
     * 此信息在commons-fileupload.jar，
     * org.apache.commons.fileupload.FileUploadBase源代码中第904行。
     * 
     * 重写addActionError()以替换默认信息。 
     */
    @Override
    public void addActionError(String anErrorMessage) {
    	
        //这里要先判断一下，是我们要替换的错误，才处理
        if (anErrorMessage.startsWith("the request was rejected because its size")) {
            //这些只是将原信息中的文件大小提取出来。
            Matcher m = Pattern.compile("\\d+").matcher(anErrorMessage);
            String s1 = "";
            if (m.find())    s1 = m.group();
            String s2 = "";
            if (m.find())    s2 = m.group();
            //偷梁换柱，将信息替换掉
            String error = "你上传的文件大小[" + s1 + "]超过允许的大小[" + s2 + "]";
            super.addActionError(error);
            errorMessage = error;
            log.warn(error);
        } else {//不是则不管它
            super.addActionError(anErrorMessage);
        }
    }
	
	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public Long getCategory1() {
		return category1;
	}

	public void setCategory1(Long category1) {
		this.category1 = category1;
	}

	public Long getCategory2() {
		return category2;
	}

	public void setCategory2(Long category2) {
		this.category2 = category2;
	}

	public Long getCategory3() {
		return category3;
	}

	public void setCategory3(Long category3) {
		this.category3 = category3;
	}

	public Long getCategory4() {
		return category4;
	}

	public void setCategory4(Long category4) {
		this.category4 = category4;
	}

	public List<Map<String, String>> getUnits() {
		return units;
	}

	public void setUnits(List<Map<String, String>> units) {
		this.units = units;
	}

	public List<String> getParamKey() {
		return paramKey;
	}

	public void setParamKey(List<String> paramKey) {
		this.paramKey = paramKey;
	}

	public List<String> getParamValue() {
		return paramValue;
	}

	public void setParamValue(List<String> paramValue) {
		this.paramValue = paramValue;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getCategoryStr() {
		return categoryStr;
	}

	public void setCategoryStr(String categoryStr) {
		this.categoryStr = categoryStr;
	}

	public List<CategoryAttr> getCategoryAttrs() {
		return categoryAttrs;
	}

	public void setCategoryAttrs(List<CategoryAttr> categoryAttrs) {
		this.categoryAttrs = categoryAttrs;
	}

	public List<SupplyParam> getSupplyParams() {
		return supplyParams;
	}

	public void setSupplyParams(List<SupplyParam> supplyParams) {
		this.supplyParams = supplyParams;
	}

	public List<Long> getSupplyIds() {
		return supplyIds;
	}

	public void setSupplyIds(List<Long> supplyIds) {
		this.supplyIds = supplyIds;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public List<Long> getCategoryAttrId() {
		return categoryAttrId;
	}

	public void setCategoryAttrId(List<Long> categoryAttrId) {
		this.categoryAttrId = categoryAttrId;
	}

	public File getUpload1() {
		return upload1;
	}

	public void setUpload1(File upload1) {
		this.upload1 = upload1;
	}

	public String getUpload1FileName() {
		return upload1FileName;
	}

	public void setUpload1FileName(String upload1FileName) {
		this.upload1FileName = upload1FileName;
	}

	public File getUpload2() {
		return upload2;
	}

	public void setUpload2(File upload2) {
		this.upload2 = upload2;
	}

	public String getUpload2FileName() {
		return upload2FileName;
	}

	public void setUpload2FileName(String upload2FileName) {
		this.upload2FileName = upload2FileName;
	}

	public File getUpload3() {
		return upload3;
	}

	public void setUpload3(File upload3) {
		this.upload3 = upload3;
	}

	public String getUpload3FileName() {
		return upload3FileName;
	}

	public void setUpload3FileName(String upload3FileName) {
		this.upload3FileName = upload3FileName;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
