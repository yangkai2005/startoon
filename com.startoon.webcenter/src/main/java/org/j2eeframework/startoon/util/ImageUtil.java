package org.j2eeframework.startoon.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.file.FileItemInfo;
import org.j2eeframework.commons.file.IFileSystem;
import org.j2eeframework.commons.file.impl.LocalFileSystem;
import org.j2eeframework.startoon.commons.SystemConfig;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public final class ImageUtil {

	private static final Log log = LogFactory.getLog(ImageUtil.class);

	public ImageUtil() {
		super();
	}

	/**
	 * 把图片印刷到图片上
	 * 
	 * @param pressImg
	 *            -- 水印文件
	 * @param targetImg
	 *            -- 目标文件
	 * @param x
	 *            --x坐标
	 * @param y
	 *            --y坐标
	 */
	public final static void pressImage(String pressImg, String targetImg, int x, int y) {
		try {
			// 目标文件
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);

			// 水印文件
			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao, null);
			// 水印文件结束
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** */
	/**
	 * 打印文字水印图片
	 * 
	 * @param pressText
	 *            --文字
	 * @param targetImg
	 *            -- 目标图片
	 * @param fontName
	 *            -- 字体名
	 * @param fontStyle
	 *            -- 字体样式
	 * @param color
	 *            -- 字体颜色
	 * @param fontSize
	 *            -- 字体大小
	 * @param x
	 *            -- 偏移量
	 * @param y
	 */
	public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, int color, int fontSize, int x, int y) {
		File file = new File(targetImg);
		pressText(pressText, file, fontName, fontStyle, color, fontSize, x, y);
	}

	/** */
	/**
	 * 打印文字水印图片
	 * 
	 * @param pressText
	 *            --文字
	 * @param targetImg
	 *            -- 目标图片
	 * @param fontName
	 *            -- 字体名
	 * @param fontStyle
	 *            -- 字体样式
	 * @param color
	 *            -- 字体颜色
	 * @param fontSize
	 *            -- 字体大小
	 * @param x
	 *            -- 偏移量
	 * @param y
	 */

	public static void pressText(String pressText, File targetImg, String fontName, int fontStyle, int color, int fontSize, int x, int y) {
		try {
			Image src = ImageIO.read(targetImg);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			g.setColor(new Color(color, color, color));
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.drawString(pressText, wideth - fontSize - x, height - fontSize / 2 - y);
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}

	public static void pressText(File image) {
		String pressText = "http://www.chnam.com";
		pressText(pressText, image, "font-weight", Font.BOLD, 204, 18, 200, 15);
	}

	/**
	 * 存储图片
	 * @param file
	 * @param fileName
	 * @return
	 */
	public static String storeNormalImg(File file, String fileName) {
		IFileSystem fileSystem = new LocalFileSystem();
		String extension = FilenameUtils.getExtension(fileName);
		FileItemInfo fileItemInfo = fileSystem.saveFile(file, extension, SystemConfig.UPLOAD_FILE_DIR);

		return fileItemInfo.getFileId();
	}

	/**
	 * 生成缩略图
	 * @param file
	 * @param fileName
	 * @return
	 */
	public static String storeSmallImg(File file, String fileName) {
		return storeSmallImg(file, fileName, SystemConfig.IMAGE_ABBREVIATIVE_WIDTH, SystemConfig.IMAGE_ABBREVIATIVE_HEIGHT);
	}

	/**
	 * 生成缩略图
	 * @param file
	 * @param fileName
	 * @return
	 */
	public static String storeSmallImg(File file, String fileName, int width, int height) {

		// 生产缩略图
		String extension = FilenameUtils.getExtension(fileName);
		String uniqueFileName = FileNameUtil.getUniqueFileName(extension);
		String fullPath = SystemConfig.UPLOAD_FILE_DIR + "/" + uniqueFileName;
		File targetFile = new File(fullPath);
		try {
			ScaleImage scaleImage = new ScaleImage();
			scaleImage.saveImageAsJpg(file, targetFile, width, height);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("生成缩略图失败：", e);
		}

		return uniqueFileName;
	}
}