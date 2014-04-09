package org.j2eeframework.commons.util;

import java.util.Random;

/**
 * 随机码工具
 * 
 * @author william
 * @since 1.0.2
 * 
 */
public class RandomCodeUtil {

	/**
	 * 随机码范围
	 */
	private static char[] source = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 生成随机码
	 * 
	 * @param length
	 *            随机码长度
	 * @return 随机码
	 * @since 1.0.2
	 */
	public static String random(int length) {
		Random random = new Random();
		int sourceLength = source.length;
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(source[random.nextInt(sourceLength)]);
		}
		return sb.toString();
	}
}
