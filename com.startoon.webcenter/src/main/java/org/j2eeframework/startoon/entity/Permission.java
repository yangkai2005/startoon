package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.j2eeframework.startoon.commons.SystemConfig;

@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {

	private static final long serialVersionUID = -5305921004701089550L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String url;

	private String description;
	
	/**
	 * 权限分类
	 * 1:'后台管理员维护', 2:'基本资料管理', 3:'B2B平台管理', 4:'资讯平台管理'
	 */
	private Long category;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
	
	public String getPath() {
		return SystemConfig.CONTEXT_PATH + getUrl();
	}
}
