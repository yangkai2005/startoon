package org.j2eeframework.startoon.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class AdminUser implements Serializable {

	private static final long serialVersionUID = -5695315532350483344L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String account;
	
	private String password;
	
	private String name;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserRefRole> userRefRoles;
	
	@Transient
	private Map<Long, List<Permission>> permission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AdminUser [account=" + account + ", id=" + id + ", name="
				+ name + ", password=" + password + "]";
	}

	public List<UserRefRole> getUserRefRoles() {
		return userRefRoles;
	}

	public void setUserRefRoles(List<UserRefRole> userRefRoles) {
		this.userRefRoles = userRefRoles;
	}

	public Map<Long, List<Permission>> getPermission() {
		return permission;
	}

	public void setPermission(Map<Long, List<Permission>> permission) {
		this.permission = permission;
	}
}
