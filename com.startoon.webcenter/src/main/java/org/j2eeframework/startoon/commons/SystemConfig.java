package org.j2eeframework.startoon.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alipay.config.AlipayConfig;

public class SystemConfig {

	private static final Log log = LogFactory.getLog(SystemConfig.class);

	public static String UPLOAD_FILE_DIR = null;

	public static String UPLOAD_VIDEO_DIR = null; // 视频上传路径

	public static String CONTEXT_PATH = null;

	public static int IMAGE_ABBREVIATIVE_WIDTH = 100; // 图片缩略图宽

	public static int IMAGE_ABBREVIATIVE_HEIGHT = 100; // 图片缩略图高

	public static String ROOT_PATH = null;

	/**
	 * 邮箱配置
	 */
	public static boolean MAIL_SERVER_VALIDATE = true;
	public static String MAIL_SERVER_HOST;
	public static String MAIL_SERVER_PORT = "25";
	public static String MAIL_SERVER_USERNAME;
	public static String MAIL_SERVER_PASSWORD;
	public static String MAIL_SERVER_FROM;
	public static String MAIL_SUBJECT;
	public static String MAIL_CONTENT;
	public static String MAIL_SERVER_ALIAS;

	public static String BOOKING_MAIL_SUBJECT;
	public static String BOOKING_MAIL_CONTENT;
	public static String BOOKING_MAIL_SUPPLY;
	public static String BOOKING_MAIL_POSTEDPRO;
	public static Integer BOOKING_MAIL_BATCH_SEND_COUNT = 10;

	public static int PUBLISH_JOB_COUNT_LIMIT = 5; // 免费会员发布招聘的次数限制
	public static int VIEW_RESUME_COUNT_LIMIT = 60; // 免费会员预览简历的次数限制
	
	public static String VIRUS_DETECT_PATH = "";

	public static void load() {
		try {
			log.info("%%% 开始加载配置文件...  %%%");

			Properties p = new Properties();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("system-parameters.properties");
			p.load(in);

			UPLOAD_FILE_DIR = p.getProperty("upload.file.dir");
			log.info("SystemConfig.UPLOAD_FILE_DIR:" + UPLOAD_FILE_DIR);

			UPLOAD_VIDEO_DIR = p.getProperty("upload.video.dir");
			log.info("SystemConfig.UPLOAD_VIDEO_DIR:" + UPLOAD_VIDEO_DIR);

			String width = p.getProperty("image.abbreviative.width");
			if (width != null && width.length() > 0) {
				IMAGE_ABBREVIATIVE_WIDTH = Integer.parseInt(width);
			}
			log.info("SystemConfig.IMAGE_ABBREVIATIVE_WIDTH:" + IMAGE_ABBREVIATIVE_WIDTH);

			String height = p.getProperty("image.abbreviative.height");
			if (height != null && height.length() > 0) {
				IMAGE_ABBREVIATIVE_HEIGHT = Integer.parseInt(height);
			}
			log.info("SystemConfig.IMAGE_ABBREVIATIVE_HEIGHT:" + IMAGE_ABBREVIATIVE_HEIGHT);

			log.info("开始读取邮箱配置...");

			String v = p.getProperty("mail.server.validate");
			MAIL_SERVER_VALIDATE = Boolean.parseBoolean(v);
			MAIL_SERVER_HOST = p.getProperty("mail.server.host");
			MAIL_SERVER_PORT = p.getProperty("mail.server.port");
			MAIL_SERVER_USERNAME = p.getProperty("mail.server.username");
			MAIL_SERVER_PASSWORD = p.getProperty("mail.server.password");
			MAIL_SERVER_FROM = p.getProperty("mail.server.from");
			MAIL_SUBJECT = p.getProperty("mail.subject");
			MAIL_CONTENT = p.getProperty("mail.content");
			MAIL_SERVER_ALIAS = p.getProperty("mail.server.alias");

			log.info("MAIL_SERVER_VALIDATE:" + MAIL_SERVER_VALIDATE);
			log.info("MAIL_SERVER_HOST:" + MAIL_SERVER_HOST);
			log.info("MAIL_SERVER_PORT:" + MAIL_SERVER_PORT);
			log.info("MAIL_SERVER_USERNAME:" + MAIL_SERVER_USERNAME);
			log.info("MAIL_SERVER_PASSWORD:" + MAIL_SERVER_PASSWORD);
			log.info("MAIL_SERVER_FROM:" + MAIL_SERVER_FROM);
			log.info("MAIL_SUBJECT:" + MAIL_SUBJECT);
			log.info("MAIL_CONTENT:" + MAIL_CONTENT);
			log.info("MAIL_SERVER_ALIAS:" + MAIL_SERVER_ALIAS);

			log.info("读取邮箱配置完成。");

			BOOKING_MAIL_SUBJECT = p.getProperty("booking.mail.subject");
			BOOKING_MAIL_CONTENT = p.getProperty("booking.mail.content");
			BOOKING_MAIL_SUPPLY = p.getProperty("booking.mail.supply");
			BOOKING_MAIL_POSTEDPRO = p.getProperty("booking.mail.postedpro");
			String batchSendMailCount = p.getProperty("booking.mail.batch.send.count");
			if (StringUtils.isBlank(batchSendMailCount)) {
				BOOKING_MAIL_BATCH_SEND_COUNT = new Integer(batchSendMailCount);
			}

			log.info("BOOKING_MAIL_SUBJECT:" + BOOKING_MAIL_SUBJECT);
			log.info("BOOKING_MAIL_CONTENT:" + BOOKING_MAIL_CONTENT);
			log.info("BOOKING_MAIL_SUPPLY:" + BOOKING_MAIL_SUPPLY);
			log.info("BOOKING_MAIL_POSTEDPRO:" + BOOKING_MAIL_POSTEDPRO);

			log.info("开始读取订阅配置...");

			log.info("读取订阅配置完成。");

			// begin 在线支付
			log.info("==> 开始读取在线支付配置...");
			if (p.getProperty("alipay.partner") != null) {
				AlipayConfig.partner = p.getProperty("alipay.partner");
				log.info("AlipayConfig.partner: " + AlipayConfig.partner);
			}
			if (p.getProperty("alipay.key") != null) {
				AlipayConfig.key = p.getProperty("alipay.key");
				log.info("AlipayConfig.key: " + AlipayConfig.key);
			}
			if (p.getProperty("alipay.seller_email") != null) {
				AlipayConfig.seller_email = p.getProperty("alipay.seller_email");
				log.info("AlipayConfig.seller_email: " + AlipayConfig.seller_email);
			}
			if (p.getProperty("alipay.notify_url") != null) {
				AlipayConfig.notify_url = p.getProperty("alipay.notify_url");
				log.info("AlipayConfig.notify_url: " + AlipayConfig.notify_url);
			}
			if (p.getProperty("alipay.return_url") != null) {
				AlipayConfig.return_url = p.getProperty("alipay.return_url");
				log.info("AlipayConfig.return_url: " + AlipayConfig.return_url);
			}
			if (p.getProperty("alipay.show_url") != null) {
				AlipayConfig.show_url = p.getProperty("alipay.show_url");
				log.info("AlipayConfig.show_url: " + AlipayConfig.show_url);
			}
			if (p.getProperty("alipay.mainname") != null) {
				AlipayConfig.mainname = p.getProperty("alipay.mainname");
				log.info("AlipayConfig.mainname: " + AlipayConfig.mainname);
			}
			if (p.getProperty("alipay.input_charset") != null) {
				AlipayConfig.input_charset = p.getProperty("alipay.input_charset");
				log.info("alipay.input_charset: " + AlipayConfig.input_charset);
			}
			if (p.getProperty("alipay.sign_type") != null) {
				AlipayConfig.sign_type = p.getProperty("alipay.sign_type");
				log.info("alipay.sign_type: " + AlipayConfig.sign_type);
			}
			if (p.getProperty("alipay.transport") != null) {
				AlipayConfig.transport = p.getProperty("alipay.transport");
				log.info("alipay.transport: " + AlipayConfig.transport);
			}
			log.info("==> 读取在线支付完成。");
			// end 在线支付

			String virusDetectPath = p.getProperty("virus.detect.path");
			if (virusDetectPath != null && virusDetectPath.trim().length() > 0) {
				VIRUS_DETECT_PATH = virusDetectPath;
				log.info("SystemConfig.VIRUS_DETECT_PATH: " + VIRUS_DETECT_PATH);
			}

			log.info("%%% 加载配置文件完成  %%%");

		} catch (IOException e) {
			e.printStackTrace();
			log.error(e);
		}

	}
}
