package org.j2eeframework.startoon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostedProParam implements Serializable {

	private static final long serialVersionUID = -1957822395381313922L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="posted_pro_id")
	private PostedPro postedPro;
	
	private String pkey;

	private String pvalue;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}

	public String getPkey() {
		return pkey;
	}

	public void setPkey(String pkey) {
		this.pkey = pkey;
	}

	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
}
