package org.j2eeframework.information.entity;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_vote_option")
public class VoteOption implements Serializable {

	private static final long serialVersionUID = 2673336098508782775L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 调查ID
	 */
	@ManyToOne
	@JoinColumn(name = "vote_id")
	private Vote vote;

	/**
	 * 选项内容
	 */
	private String optionContent;

	/**
	 * 投票数
	 */
	private Integer voteCount = 0;
	
	/**
	 * 当前调查所有的投票数
	 */
	@Transient
	private float precent = 0.0F;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public float getPrecent() {
		
		int totalCount = getVote().getTotalVoteCount();
		int currentCount = getVoteCount();
		
		if(totalCount!=0) {
			precent = (float) (100.0 * currentCount/totalCount);
		}
		
		return precent;
	}

	public void setPrecent(float precent) {
		this.precent = precent;
	}
	
	public String getFormatPrecent() {
		float p = getPrecent();
		DecimalFormat format=new DecimalFormat("##.#");
		String f = format.format(p);
		return f;
	}
	
}
