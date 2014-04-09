package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_searched_keyword")
public class SearchedKeyword implements Serializable {

	private static final long serialVersionUID = -1799498197496673529L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String keyword;
	
	private Integer searchedTimes = 0;
	
	private Date lastSearchTime = new Date();
	
	private String searchIp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getSearchedTimes() {
		return searchedTimes;
	}

	public void setSearchedTimes(Integer searchedTimes) {
		this.searchedTimes = searchedTimes;
	}

	public Date getLastSearchTime() {
		return lastSearchTime;
	}

	public void setLastSearchTime(Date lastSearchTime) {
		this.lastSearchTime = lastSearchTime;
	}

	public String getSearchIp() {
		return searchIp;
	}

	public void setSearchIp(String searchIp) {
		this.searchIp = searchIp;
	}
}
