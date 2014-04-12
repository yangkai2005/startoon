package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_attachment")
public class Attachment implements Serializable {

	private static final long serialVersionUID = -6158029865312590514L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 文件格式
	 */
	private String format;

	/**
	 * 文件大小
	 */
	private Long filesize;

	/***
	 *创建时间
	 */
	private Date createTime = new Date();

	/**
	 * 上传资料名称
	 */
	private String dataName;

	/**
	 * 资料保存路径
	 */
	private String dataPath;

	/**
	 * 资料状态
	 */
	private Integer status = 0;

	/**
	 * 资料的URL地址
	 */
	private String url;

	/**
	 * 封面图片
	 */
	private String imgUrl;

	@ManyToOne
	@JoinColumn(name = "attachment_type_id")
	private AttachmentType attachmentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public AttachmentType getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(AttachmentType attachmentType) {
		this.attachmentType = attachmentType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Attachment [attachmentType=" + attachmentType + ", createTime=" + createTime + ", dataName=" + dataName + ", dataPath=" + dataPath + ", description=" + description + ", filesize=" + filesize + ", format=" + format + ", id=" + id + ", imgUrl=" + imgUrl + ", name=" + name + ", status=" + status + ", url=" + url + "]";
	}
}
