package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_job_type")
public class JobType implements Serializable {

	private static final long serialVersionUID = -6278470036432430821L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private JobType parent;

	private String name;

	private String pos;

	private Integer lvl = 1;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<JobType> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JobType getParent() {
		return parent;
	}

	public void setParent(JobType parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	@Override
	public String toString() {
		return "JobType [id=" + id + ", parent=" + parent + ", name=" + name + ", pos=" + pos + ", lvl=" + lvl + "]";
	}

	public List<JobType> getChildren() {
		return children;
	}

	public void setChildren(List<JobType> children) {
		this.children = children;
	}

}
