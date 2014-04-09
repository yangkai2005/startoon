package org.j2eeframework.startoon.web.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.commons.SystemConfig;

public class FileViewServlet extends HttpServlet {

	private static final long serialVersionUID = -9122963711517096713L;

	private static final Log log = LogFactory.getLog(FileViewServlet.class);

	private enum FileType {
		jpeg, jpg, gif, png, bmp, swf, mp3, wma, wmv, flv, doc, xls;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		InputStream in = null;
		OutputStream out = null;

		try {

			long sMillis = System.currentTimeMillis();
			String id = req.getParameter("id");

			log.debug("==> 开始处理文件文件请求[" + sMillis + "|id=" + id + "]");

			String path = SystemConfig.UPLOAD_FILE_DIR + File.separator + id;
			File file = new File(path);
			if (!file.exists()) {
				log.warn("==> 文件不存在[" + path + "]");
				return;
			}

			String type = FilenameUtils.getExtension(id);
			if (!contains(type)) {
				log.warn("==> 文件类型不存在[" + type + "]");
				return;
			}

			setContentType(resp, type);

			in = new BufferedInputStream(new FileInputStream(file));
			out = resp.getOutputStream();

			byte[] length = new byte[1024];
			int data;

			while ((data = in.read(length)) != -1) {
				out.write(length, 0, data);
				out.flush();
			}

			long eMillis = System.currentTimeMillis();
			long cast = eMillis - sMillis;

			log.debug("==> 文件请求处理结束[" + eMillis + "|耗时: " + cast + "]");

		} catch (Exception e) {
			log.error("%%%%% 文件请求处理异常 %%%%%", e);

		} finally {

			if (null != in) {
				in.close();
			}
			if (null != out) {
				out.close();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void setContentType(HttpServletResponse resp, String type) {
		FileType fileType = Enum.valueOf(FileType.class, type.toLowerCase());
		switch (fileType) {
		case jpeg:
		case jpg:
			resp.setContentType("image/jpeg");
			break;
		case gif:
		case png:
		case bmp:
			resp.setContentType("image/" + type);
			break;
		case swf:
			resp.setContentType("application/x-shockwave-flash");
			break;
		case mp3:
			resp.setContentType("audio/mp3");
			break;
		case wma:
			resp.setContentType("audio/x-ms-wma");
			break;
		case wmv:
			resp.setContentType("video/x-ms-wmv");
			break;
		case flv:
			resp.setContentType("video/x-flv");
			break;
		case doc:
			resp.setContentType("application/msword");
		case xls:
			resp.setContentType("application/x-xls");
			break;
		default:
			break;
		}
	}

	private boolean contains(String type) {
		boolean exist = false;
		for (FileType fileType : FileType.values()) {
			if (fileType.name().equals(type.toLowerCase())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

}
