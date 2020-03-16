package com.qa.fun.qa.vote.answer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.fun.qa.answer.model.Answer;
import com.qa.fun.qa.common.model.BaseEntity;
import com.qa.fun.qa.user.model.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AnswerVote extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private User userVoted;

	@Column(name = "ANSWER_ID")
	private Long answerId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ANSWER_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Answer answerVoted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserVoted() {
		return userVoted;
	}

	public void setUserVoted(User userVoted) {
		this.userVoted = userVoted;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public Answer getAnswerVoted() {
		return answerVoted;
	}

	public void setAnswerVoted(Answer answerVoted) {
		this.answerVoted = answerVoted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AnswerVote)) return false;
		AnswerVote that = (AnswerVote) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
