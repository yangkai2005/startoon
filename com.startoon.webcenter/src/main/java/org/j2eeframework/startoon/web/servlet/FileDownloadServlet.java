package org.j2eeframework.startoon.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.commons.SystemConfig;

/**
 * Servlet implementation class FileDownloadServlet
 */
public class FileDownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4478555975380258929L;

	private static final Log log = LogFactory.getLog(FileDownloadServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDownloadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long start = System.currentTimeMillis();
		log.info("开始处理文件下载请求...");

		// 根据文件的ID获取文件的存放路径
		String fileId = request.getParameter("id");
		String fileName = request.getParameter("fn");
		String path = SystemConfig.UPLOAD_FILE_DIR + "/" + fileId;
		String ex = FilenameUtils.getExtension(fileId);
		log.debug("==>getExtension:" + ex);
		log.debug("==>" + path);

		// 关于文件下载时采用文件流输出的方式处理：
		// 加上response.reset()，并且所有的％>后面不要换行，包括最后一个；

		response.reset();// 可以加也可以不加
		response.setContentType("application/x-download");
		String filedownload = path;
		fileName = fileName != null ? fileName : DateUtil.formatDateByPattern(new Date(), "yyyyMMddHHmmss");
		String filedisplay = fileName + "." + ex;
		filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);

		OutputStream outp = null;
		FileInputStream in = null;
		try {
			outp = response.getOutputStream();
			in = new FileInputStream(filedownload);

			byte[] b = new byte[1024];
			int i = 0;

			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("下载文件出错", e);
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			if (outp != null) {
				outp.close();
				outp = null;
			}
		}

		long cast = System.currentTimeMillis() - start;
		log.info("耗时-" + cast + ", 处理文件请求完成.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
