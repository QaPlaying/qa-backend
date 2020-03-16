package com.qa.fun.qa.vote.question.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.fun.qa.common.model.BaseEntity;
import com.qa.fun.qa.user.model.User;
import com.qa.fun.qa.question.model.Question;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class QuestionVote  extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private User userVoted;

	@Column(name = "QUESTION_ID")
	private Long questionId;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "QUESTION_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Question questionVoted;


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

	public Question getQuestionVoted() {
		return questionVoted;
	}

	public void setQuestionVoted(Question questionVoted) {
		this.questionVoted = questionVoted;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof QuestionVote)) return false;
		QuestionVote that = (QuestionVote) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
