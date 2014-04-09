package org.j2eeframework.commons.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

public class ResourceType {

	private static final String RESOURCE_TYPE = "resource-type.properties";
	private static Properties p = new Properties();

	public static final List<String> FILES = new ArrayList<String>();
	public static final List<String> IMAGES = new ArrayList<String>();
	public static final List<String> FLASHS = new ArrayList<String>();
	public static final List<String> MEDIAS = new ArrayList<String>();

	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(RESOURCE_TYPE);
			p.load(in);

			String file = p.getProperty("resourceType.file.extensions.allowed");
			String image = p.getProperty("resourceType.image.extensions.allowed");
			String flash = p.getProperty("resourceType.flash.extensions.allowed");
			String media = p.getProperty("resourceType.media.extensions.allowed");

			String[] fileArr  =  file != null ? file.split("|") :  null;
			String[] imageArr = image != null ? image.split("|") : null;
			String[] flashArr = flash != null ? flash.split("|") : null;
			String[] mediaArr = media != null ? media.split("|") : null;

			for (String e : fileArr) {
				FILES.add(e);
			}

			for (String e : imageArr) {
				IMAGES.add(e);
			}

			for (String e : flashArr) {
				FLASHS.add(e);
			}

			for (String e : mediaArr) {
				MEDIAS.add(e);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isFileAllowed(String fileName) {
		String ext = FilenameUtils.getExtension(fileName);
		return getAllowedExtension().contains(ext);
	}
	
	public static List<String> getAllowedExtension() {
		List<String> list = new ArrayList<String>();
		list.addAll(FILES);
		list.addAll(FLASHS);
		list.addAll(IMAGES);
		list.addAll(MEDIAS);
		return list;
	} 
	
	public static void main(String[] args) {
		String fn= "test.ext";
		System.out.println(isFileAllowed(fn));
	}
}
