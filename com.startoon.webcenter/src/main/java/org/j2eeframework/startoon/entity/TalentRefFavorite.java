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

import org.j2eeframework.information.entity.Talent;

@Entity
@Table(name = "t_talent_ref_favorite")
public class TalentRefFavorite implements Serializable {

	private static final long serialVersionUID = 8976760962809480816L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "enterprise_id")
	private Enterprise creator;

	@ManyToOne
	@JoinColumn(name = "talent_id")
	private Talent talent;

	private Date ctime = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Enterprise getCreator() {
		return creator;
	}

	public void setCreator(Enterprise creator) {
		this.creator = creator;
	}

	public Talent getTalent() {
		return talent;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}
