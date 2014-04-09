package org.j2eeframework.startoon.entity;

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
@Table(name = "t_payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = -5695315532350483344L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String orderid;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise creator;

	private Float amount;

	/***
	 * 订单状态 1: 未处理 2： 已付款 3: 已删除
	 */
	private int status;

	private Date ordertime;

	/**
	 * 充值类型 0-会员充值 1-管理员充值
	 */
	private int type = 0;

	@ManyToOne
	@JoinColumn(name = "admin_user_id")
	private AdminUser adminUser;

	public String getStatusZh() {
		String s = "";
		switch (status) {
		case 1:
			s = "未处理";
			break;
		case 2:
			s = "已付款";
			break;
		case 3:
			s = "已删除";
			break;
		}
		return s;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Enterprise getCreator() {
		return creator;
	}

	public void setCreator(Enterprise creator) {
		this.creator = creator;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

	@Override
	public String toString() {
		return "Payment [adminUser=" + adminUser + ", amount=" + amount + ", creator=" + creator + ", id=" + id + ", orderid=" + orderid + ", ordertime=" + ordertime + ", status=" + status + ", type=" + type + "]";
	}
}
