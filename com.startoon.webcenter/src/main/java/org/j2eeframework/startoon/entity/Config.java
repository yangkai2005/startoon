package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_config")
public class Config implements Serializable {

	private static final long serialVersionUID = 5511284197584717460L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * 存储的键
	 */
	private String skey;
	/**
	 * 存储的值
	 */
	private String svalue;
	/**
	 * 描述内容
	 */
	private String depict;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSvalue() {
		return svalue;
	}

	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	@Override
	public String toString() {
		return "Config [id=" + id + ", skey=" + skey + ", svalue=" + svalue + ", depict=" + depict + "]";
	}
}
