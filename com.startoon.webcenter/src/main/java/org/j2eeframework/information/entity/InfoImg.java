package org.j2eeframework.information.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.j2eeframework.startoon.commons.SystemConfig;

@Entity
@Table(name = "t_info_img")
public class InfoImg implements Serializable {

	private static final long serialVersionUID = -8065921751731125092L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="info_id")
	private Info info;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 图片名称
	 */
	private String name;
	
	/**
	 * 是否为新闻主图
	 */
	private Boolean isMainImg = false;
	
	/**
	 * 图片保存路径
	 */
	private String imgUrl;
	
	/**
	 * 小图路径
	 */
	private String smallImgUrl;
	
	/**
	 * 是否为视频
	 */
	private boolean isVideo;
	
	/**
	 * 视频存放路径
	 */
	private String videoPath;
	
	/**
	 * 视频类型
	 * 0：视频链接
	 * 1：视频文件
	 */
	private Integer videoType = 0;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsMainImg() {
		return isMainImg;
	}

	public void setIsMainImg(Boolean isMainImg) {
		this.isMainImg = isMainImg;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSmallImgUrl() {
		return smallImgUrl;
	}

	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}
	
	public boolean getIsVideo() {
		return isVideo;
	}
	
	public void setIsVideo(boolean isVideo) {
		this.isVideo = isVideo;
	}
	
	public String getVideoPath() {
		return videoPath;
	}
	
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public Integer getVideoType() {
		return videoType;
	}

	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}	
	
	/*
	 * 获取小图
	 */
	public String getSmallImg() {
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + getSmallImgUrl();
	}
	
	/*
	 * 获取大图
	 */
	public String getNormalImg() {
		return SystemConfig.CONTEXT_PATH + "/FileView?id=" + getImgUrl();
	}
	
	
	/**
	 * 获取视频路径
	 * @return
	 */
	public String getVideo() {
		String url = null;
		if(getVideoType()==1) {
			url = SystemConfig.CONTEXT_PATH + "/video/" + getVideoPath();
		} else {
			url = getVideoPath();
		}
		return url;
	}
	
}
