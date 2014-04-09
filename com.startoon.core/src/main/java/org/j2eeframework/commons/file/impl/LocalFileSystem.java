package org.j2eeframework.commons.file.impl;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.exception.FileException;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.util.DateUtil;

/**
 * 本地文件系统接口
 * 
 * @author william
 * 
 */
public class LocalFileSystem implements IFileSystem {

	private final static Log log = LogFactory.getLog(LocalFileSystem.class);

	private static final String EXTENSIONS_ALLOWED = "7z|aiff|asf|avi|bmp|csv|doc|fla|flv|gif|gz|gzip|jpeg|jpg|mid|mov|mp3|mp4|mpc|mpeg|mpg|ods|odt|pdf|png|ppt|pxd|qt|ram|rar|rm|rmi|rmvb|rtf|sdc|sitd|swf|sxc|sxw|tar|tgz|tif|tiff|txt|vsd|wav|wma|wmv|xls|xml|zip";

	public static List<String> ALLOWED_EXTENSIONS;

	static {
		ALLOWED_EXTENSIONS = Arrays.asList(EXTENSIONS_ALLOWED.split("\\|"));
	}

	public static boolean isAllowed(String extension) {
		return extension != null && extension.trim().length() > 0 && ALLOWED_EXTENSIONS.contains(extension.toLowerCase());
	}

	public FileItemInfo saveImageFileAndGenerateAbbreviative(File uploadedFile, String fileExtension, String basePath, int outputWidth, int outputHeight) {
		try {
			FileItemInfo info = saveFile(uploadedFile, fileExtension, basePath);
			
			if(info==null) {
				return null;
			}
			
			// 文件存放的绝对路径
			String realPath = (basePath.lastIndexOf("/") == 0 ? basePath : basePath + "/") + info.getFileUrl();
			// 产生缩略图
			String abbreviativeImgPath = realPath + "/" + "s_" + info.getNameWithoutExt() + ".jpg";

			generateAbbreviativeImage(abbreviativeImgPath, uploadedFile, outputWidth, outputHeight);
			return info;
		} catch (Exception e) {
			log.error("保存图片文件失败", e);
			throw new FileException("保存图片文件失败", e);
		}
	}

	public void saveImageAsJpg(InputStream in, File saveFile, int width, int hight) throws Exception {
		BufferedImage srcImage;
		srcImage = ImageIO.read(in);
		if (width > 0 || hight > 0) {
			srcImage = resize(srcImage, width, hight);
		}
		ImageIO.write(srcImage, "JPEG", saveFile);
		in.close();
	}

	public BufferedImage resize(BufferedImage source, int targetW, int targetH) {
		// targetW，targetH分别表示目标长和宽
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();

		// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
		// 则将下面的if else语句注释即可
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}

		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			target = new BufferedImage(targetW, targetH, type);
		Graphics2D g = target.createGraphics();
		// smoother than exlax:
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	public FileItemInfo saveFile(File uploadedFile, String fileExtension, String basePath) {
		try {

			// 对文件扩展名进行验证
			if (!isAllowed(fileExtension)) {
				log.error("==>上传文件类型不允许：" + fileExtension);
				return null;
			}

			// 存放路径
			String filePath = DateUtil.formatDateByPattern(new Date(), "yyyy/MM/dd");
			// 文件存放的绝对路径
			String realPath = (basePath.lastIndexOf("/") == 0 ? basePath : basePath + "/") + filePath;

			File fileForde = new File(realPath);
			// 判断此文件夹是否存在？不存在则创建
			if (!fileForde.exists())
				fileForde.mkdirs();

			String extension = fileExtension;
			String nameWithoutExt = UUID.randomUUID().toString();
			// 获得唯一文件名
			String newFileName = nameWithoutExt + "." + extension;
			String fileUrl = realPath + "/" + newFileName;
			InputStream in = new FileInputStream(uploadedFile);

			// 保存文件
			FileOutputStream out = new FileOutputStream(fileUrl);

			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
				out.write(buffer, 0, bytesRead);// 将文件写入服务器
			}
			in.close();
			out.close();

			FileItemInfo fi = new FileItemInfo();
			fi.setFileUrl(filePath);
			fi.setNameWithoutExt(nameWithoutExt);
			fi.setExtension(extension);

			return fi;
		} catch (Exception e) {
			log.error("保存文件失败", e);
			throw new FileException("保存文件失败", e);
		}
	}

	/**
	 * 产生图片文件等比缩略图
	 * 
	 * @author william
	 */
	private void generateAbbreviativeImage(String abbreviativeImgPath, File uploadedFile, int outputWidth, int outputHeight) {
		try {
			saveImageAsJpg(new FileInputStream(uploadedFile), new File(abbreviativeImgPath), outputWidth, outputHeight);
		} catch (Exception e) {
			log.error("产生缩略图文件失败", e);
			throw new FileException("产生缩略图文件失败", e);
		}
	}


}
