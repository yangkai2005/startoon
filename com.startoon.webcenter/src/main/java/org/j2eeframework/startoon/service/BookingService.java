package org.j2eeframework.startoon.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.dao.IBookingDAO;
import org.j2eeframework.startoon.entity.Booking;
import org.j2eeframework.startoon.entity.EmailTemplate;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.MailQueue;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.Supply;
import org.springframework.stereotype.Service;

@Service
public class BookingService extends AbstractService<Booking, Long, IBookingDAO> {
	
	private static final Log log = LogFactory.getLog(BookingService.class);
	
	@Resource
	private IBookingDAO bookingDAO;
	
	@Resource
	private MailQueueService mailQueueService;

	@Resource
	private SupplyService supplyService;
	
	@Resource
	private PostedProService postedProService;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private EmailTemplateService emailTemplateService;

	@Override
	public IBookingDAO getGenericDAO() {
		return bookingDAO;
	}
	
	
	public List<Booking> getBookingByCategoryId(Long categoryId) {
		Pager<Booking> pager = new Pager<Booking>();
		pager.getParamCondition().addParameter("categoryId", categoryId + "");
		pager.setPageSize(10000);
		getEntitiesOfPagerByParamCondition(pager);
		
		return pager.getItems();
	}
	
	public MailQueue addToMailQueue(String to, String subject, String content) {
		MailQueue mailQueue = generateMailQueue(to, subject, content);
		log.info(" ==> 插入订阅邮件到邮件队列表当中[" + mailQueue + "]");
		mailQueueService.insert(mailQueue);
		return mailQueue;
	}
	
	public MailQueue generateMailQueue(String to, String subject, String content) {
		MailQueue mailQueue = new MailQueue();
		mailQueue.setTo(to);
		mailQueue.setSubject(subject);
		mailQueue.setContent(content);
		
		return mailQueue;
		
	}
	
	/**
	 * 批量添加订阅发送邮件
	 * @param categoryId 类别ID
	 * @param id 供应/产品ID
	 * @param type 类别
	 */
	public void batchAddToQueues(Long categoryId, Long id, int type) {
		
		String subject = SystemConfig.BOOKING_MAIL_SUBJECT;
		String content = SystemConfig.BOOKING_MAIL_CONTENT;
		String supplyUrl = SystemConfig.BOOKING_MAIL_SUPPLY;
		String postedproUrl = SystemConfig.BOOKING_MAIL_POSTEDPRO;
		String url = null;
		

		List<Booking> list = getBookingByCategoryId(categoryId);

		for(Booking b : list) {
			
			String to = b.getReceiveEmail();
			
			int t = b.getType();
			
			if(type!=t) continue;
			
			if(t==0)
				url = supplyUrl;
			else if(t==1)
				url = postedproUrl;
			
			url = url.replace("${id}", id + "");
			content = content.replace("${url}", url);
			
			addToMailQueue(to, subject, content);
			
		}
	}
	
	/**
	 * 生成订阅邮件
	 * @param start 开始时间
	 * @param end 结束时间
	 */
	public void gernateEmail(Date start, Date end) {
		
		// key:categoryId, value:List<Supply>
		Map<Long, List<Supply>> supplyCache = new HashMap<Long, List<Supply>>();
		// key:categoryId, value:List<PostedPro>
		Map<Long, List<PostedPro>> postedProCache = new HashMap<Long, List<PostedPro>>();
		// key:enterpriseId, value:List<Supply>
		Map<Long, List<Supply>> userSupply =  new HashMap<Long, List<Supply>>();
		// key:enterpriseId, value:List<PostedPro>
		Map<Long, List<PostedPro>> userPostedPro =  new HashMap<Long, List<PostedPro>>();
		// key:enterpriseId, value:订阅的类别ID
		// Map<Long, Set<Long>> userCategoryFilter = new HashMap<Long, Set<Long>>();
		
		List<Booking> bookings = getAllEntity();
		
		// 处理订阅，根据用户分类
		for(Booking bk : bookings) {
			Long uid = bk.getEnterprise().getId();
			Long cid = bk.getCategory().getId();
			int type = bk.getType();
			
			if(type==1) { //采购
				
				// 缓存采购数据
				List<PostedPro> cachedPostedPros = postedProCache.get(cid);
				if(cachedPostedPros==null) {
					cachedPostedPros = postedProService.getPostedProByTime(cid, start, end, 6);
					postedProCache.put(cid, cachedPostedPros);
				}
				
				int size = 0;
				if(cachedPostedPros!=null && cachedPostedPros.size()>0) {
					size = cachedPostedPros.size();
				}
				
				// 用户订阅的采购信息数据
				List<PostedPro> postedPros = userPostedPro.get(uid);
				if(postedPros==null) {
					postedPros = new ArrayList<PostedPro>(Arrays.asList(new PostedPro[size]));
					Collections.copy(postedPros, cachedPostedPros);
					userPostedPro.put(uid, postedPros);
				} else {
					List<PostedPro> tempPostedPros = new ArrayList<PostedPro>(Arrays.asList(new PostedPro[size]));
					Collections.copy(tempPostedPros, cachedPostedPros);
					postedPros.addAll(tempPostedPros);
				}
				
			} else { // 供应
				
				// 缓存供应数据
				List<Supply> cachedSupplies = supplyCache.get(cid);
				if(cachedSupplies==null) {
					cachedSupplies = supplyService.getSupplyByTime(cid, start, end, 8);
					supplyCache.put(cid, cachedSupplies);
				}
				
				int size = 0;
				if(cachedSupplies!=null && cachedSupplies.size()>0) {
					size = cachedSupplies.size();
				}
				// 用户订阅的供应信息数据
				List<Supply> supplies = userSupply.get(uid);
				if(supplies==null) {
					supplies = new ArrayList<Supply>(Arrays.asList(new Supply[size]));
					Collections.copy(supplies, cachedSupplies);
					userSupply.put(uid, supplies);
				} else {
					List<Supply> tempSupplies = new ArrayList<Supply>(Arrays.asList(new Supply[size]));
					Collections.copy(tempSupplies, cachedSupplies);
					supplies.addAll(tempSupplies);
				}
			}
			
			
		}
		
		// 循环处理每一个用户的订阅邮件
		EmailTemplate template = emailTemplateService.getEntityById(1L);
		String content = template.getContent();
		String subject = SystemConfig.BOOKING_MAIL_SUBJECT;
		SimpleDateFormat fmt = new SimpleDateFormat("MM月dd日");
		subject = subject.replace("${date}", fmt.format(new Date()));
		
		fmt.applyPattern("yyyy年MM月dd日");
		String now = fmt.format(new Date());
		
		for(Long uid : userSupply.keySet()) {
			Enterprise enterprise = enterpriseService.getEntityById(uid);
			String email = enterprise.getBookingEmail();
			
			List<Supply> supplies = userSupply.get(uid);
			List<PostedPro> postedPros = userPostedPro.get(uid);
			
			String supplyHTML = gernateSupplyHtml(supplies);
			String postedProHTML = gernatePostedProHtml(postedPros);
			
			if("".equals(supplyHTML) && "".equals(postedProHTML)) {
				continue;
			}
			
			String emailContent = new String(content);
			emailContent = emailContent
							.replace("${supplies}", supplyHTML)
							.replace("${postedPros}", postedProHTML)
							.replace("${now}", now);
			
			addToMailQueue(email, subject, emailContent);
			
		}
		
	}
	
	/**
	 * 生成全部的供应信息HTML
	 * @param supplies
	 * @return
	 */
	public String gernateSupplyHtml(List<Supply> supplies) {
		
		if(supplies==null || supplies.isEmpty()) {
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(Supply supply : supplies) {
			String html = gernateSupplyHtml(supply);
			sb.append(html);
		}
		
		return sb.toString();
		
	}
	
	/**
	 * 生成多条供应信息
	 * @param postedPros
	 * @return
	 */
	public String gernatePostedProHtml(List<PostedPro> postedPros) {
		if(postedPros==null || postedPros.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(PostedPro postedPro : postedPros) {
			String html = gernatePostedProHtml(postedPro);
			sb.append(html);
		}
		return sb.toString();
	}
	
	/**
	 * 生成单条供应信息html
	 * @param supply
	 * @return
	 */
	public String gernateSupplyHtml(Supply supply) {
		
		if(supply==null) {
			return "";
		}
		String url = "http://www.chnam.com/supply/supply-manage!detail.action?supplyId=";
		String img = "http://www.chnam.com/FileView?id=";
		
//		url = "http://localhost:8080/startoon/supply/supply-manage!detail.action?supplyId=";
//		img = "http://localhost:8080/startoon/FileView?id=";
		
		String html = "<li>" +
		"<div class='gqpic'><a href='${link}' target='_blank'><img src='${imgurl}' width='165px' height='130px'/></a></div>" +
		"<div class='gqxx'><a href='${link}' target='_blank'>${name}<span class='red'>${category}</span>系列<br/><span class='red'>${creator}</span></a></div>" +
		"</li>";
		
		String link = url + supply.getId();
		String imgurl = img + supply.getProductImgUrl();
		String name = supply.getName();
		String category = supply.getCategory().getName();
		
		html = html.replace("${link}", link)
			.replace("${imgurl}", imgurl)
			.replace("${category}", category)
			.replace("${creator}", supply.getCreator().getName())
			.replace("${name}", name);
		
		log.debug("生成订阅邮件的单条供应信息[" + html + "]");
		
		return html;
		
	}
	
	
	/**
	 * 生成单条采购信息的HTML
	 * @param postedPro
	 * @return
	 */
	public String gernatePostedProHtml(PostedPro postedPro) {
		
		if(postedPro==null) {
			return "";
		}
		
		String postedproUrl = SystemConfig.BOOKING_MAIL_POSTEDPRO;
		String link = postedproUrl.replace("${id}", postedPro.getId() + "");
		String originalHtml = "<tr><td class='tdsty'><a href='${link}' target='_blank'>${name}</a></td><td>${createTime}</td><td>${amount}</td><td>${address}</td></tr>";
		
		String createTime = DateUtil.formatDateByPattern(postedPro.getCreateTime(), "yyyy-MM-dd");
		
		originalHtml = originalHtml.replace("${link}", link)
								   .replace("${name}", postedPro.getProName())
								   .replace("${address}", postedPro.getTradeAddress())
								   .replace("${amount}", postedPro.getAmount() + "")
								   .replace("${createTime}", createTime);
		
		log.debug("生成单条采购信息[" + originalHtml + "]");
		
		return originalHtml;
	}
	
}
