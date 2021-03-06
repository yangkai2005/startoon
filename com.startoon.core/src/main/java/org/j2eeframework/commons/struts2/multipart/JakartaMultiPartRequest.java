package org.j2eeframework.commons.struts2.multipart;

/*
 * $Id: JakartaMultiPartRequest.java 724074 2008-12-07 04:51:34Z wesw $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Multipart form data request adapter for Jakarta Commons Fileupload package.
 */
public class JakartaMultiPartRequest implements MultiPartRequest {

	static final Logger LOG = LoggerFactory.getLogger(MultiPartRequest.class);

	// maps parameter name -> List of FileItem objects
	private final Map<String, List<FileItem>> files = new HashMap<String, List<FileItem>>();

	// maps parameter name -> List of param values
	private final Map<String, List<String>> params = new HashMap<String, List<String>>();

	// any errors while processing this request
	private final List<String> errors = new ArrayList<String>();

	private long maxSize;

	@Inject(StrutsConstants.STRUTS_MULTIPART_MAXSIZE)
	public void setMaxSize(String maxSize) {
		this.maxSize = Long.parseLong(maxSize);
	}

	/**
	 * Creates a new request wrapper to handle multi-part data using methods adapted from Jason Pell's
	 * multipart classes (see class description).
	 *
	 * @param saveDir        the directory to save off the file
	 * @param servletRequest the request containing the multipart
	 * @throws java.io.IOException  is thrown if encoding fails.
	 */
	public void parse(HttpServletRequest servletRequest, String saveDir) throws IOException {
		DiskFileItemFactory fac = new DiskFileItemFactory();
		// Make sure that the data is written to file
		fac.setSizeThreshold(0);
		if (saveDir != null) {
			fac.setRepository(new File(saveDir));
		}

		// Parse the request
		try {
			ServletFileUpload upload = new ServletFileUpload(fac);
			upload.setSizeMax(maxSize);

			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(createRequestContext(servletRequest));

			for (Object item1 : items) {
				FileItem item = (FileItem) item1;
				if (LOG.isDebugEnabled())
					LOG.debug("Found item " + item.getFieldName());
				if (item.isFormField()) {
					LOG.debug("Item is a normal form field");
					List<String> values;
					if (params.get(item.getFieldName()) != null) {
						values = params.get(item.getFieldName());
					} else {
						values = new ArrayList<String>();
					}

					// note: see http://jira.opensymphony.com/browse/WW-633
					// basically, in some cases the charset may be null, so
					// we're just going to try to "other" method (no idea if this
					// will work)
					String charset = servletRequest.getCharacterEncoding();
					if (charset != null) {
						values.add(item.getString(charset));
					} else {
						values.add(item.getString());
					}
					params.put(item.getFieldName(), values);
				} else {
					LOG.debug("Item is a file upload");

					// Skip file uploads that don't have a file name - meaning that no file was selected.
					if (item.getName() == null || item.getName().trim().length() < 1) {
						LOG.debug("No file has been uploaded for the field: " + item.getFieldName());
						continue;
					}

					List<FileItem> values;
					if (files.get(item.getFieldName()) != null) {
						values = files.get(item.getFieldName());
					} else {
						values = new ArrayList<FileItem>();
					}

					values.add(item);
					files.put(item.getFieldName(), values);
				}
			}
		} catch (SizeLimitExceededException e) {
			ArrayList<String> values = new ArrayList<String>();
			values.add("SizeLimitExceededException");
			params.put("exception", values);//处理上传出错问题
		} catch (FileUploadException e) {
			LOG.error("Unable to parse request", e);
			ArrayList<String> values = new ArrayList<String>();
			values.add("FileUploadException");
			params.put("exception", values);
			errors.add(e.getMessage());
		}
	}

	public Enumeration<String> getFileParameterNames() {
		return Collections.enumeration(files.keySet());
	}

	public String[] getContentType(String fieldName) {
		List<FileItem> items = files.get(fieldName);

		if (items == null) {
			return null;
		}

		List<String> contentTypes = new ArrayList<String>(items.size());
		for (FileItem fileItem : items) {
			contentTypes.add(fileItem.getContentType());
		}

		return contentTypes.toArray(new String[contentTypes.size()]);
	}

	public File[] getFile(String fieldName) {
		List<FileItem> items = files.get(fieldName);

		if (items == null) {
			return null;
		}

		List<File> fileList = new ArrayList<File>(items.size());
		for (FileItem fileItem : items) {
			fileList.add(((DiskFileItem) fileItem).getStoreLocation());
		}

		return fileList.toArray(new File[fileList.size()]);
	}

	public String[] getFileNames(String fieldName) {
		List<FileItem> items = files.get(fieldName);

		if (items == null) {
			return null;
		}

		List<String> fileNames = new ArrayList<String>(items.size());
		for (FileItem fileItem : items) {
			fileNames.add(getCanonicalName(fileItem.getName()));
		}

		return fileNames.toArray(new String[fileNames.size()]);
	}

	public String[] getFilesystemName(String fieldName) {
		List<FileItem> items = files.get(fieldName);

		if (items == null) {
			return null;
		}

		List<String> fileNames = new ArrayList<String>(items.size());
		for (FileItem fileItem : items) {
			fileNames.add(((DiskFileItem) fileItem).getStoreLocation().getName());
		}

		return fileNames.toArray(new String[fileNames.size()]);
	}

	public String getParameter(String name) {
		List<String> v = params.get(name);
		if (v != null && v.size() > 0) {
			return v.get(0);
		}

		return null;
	}

	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(params.keySet());
	}

	public String[] getParameterValues(String name) {
		List<String> v = params.get(name);
		if (v != null && v.size() > 0) {
			return v.toArray(new String[v.size()]);
		}

		return null;
	}

	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Returns the canonical name of the given file.
	 *
	 * @param filename  the given file
	 * @return the canonical name of the given file
	 */
	private String getCanonicalName(String filename) {
		int forwardSlash = filename.lastIndexOf("/");
		int backwardSlash = filename.lastIndexOf("\\");
		if (forwardSlash != -1 && forwardSlash > backwardSlash) {
			filename = filename.substring(forwardSlash + 1, filename.length());
		} else if (backwardSlash != -1 && backwardSlash >= forwardSlash) {
			filename = filename.substring(backwardSlash + 1, filename.length());
		}

		return filename;
	}

	/**
	 * Creates a RequestContext needed by Jakarta Commons Upload.
	 *
	 * @param req  the request.
	 * @return a new request context.
	 */
	private RequestContext createRequestContext(final HttpServletRequest req) {
		return new RequestContext() {
			public String getCharacterEncoding() {
				return req.getCharacterEncoding();
			}

			public String getContentType() {
				return req.getContentType();
			}

			public int getContentLength() {
				return req.getContentLength();
			}

			public InputStream getInputStream() throws IOException {
				InputStream in = req.getInputStream();
				if (in == null) {
					throw new IOException("Missing content in the request");
				}
				return req.getInputStream();
			}
		};
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

}
