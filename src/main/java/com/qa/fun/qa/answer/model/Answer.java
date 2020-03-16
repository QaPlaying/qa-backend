package com.qa.fun.qa.answer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.fun.qa.vote.answer.model.AnswerVote;
import com.qa.fun.qa.common.model.BaseEntity;
import com.qa.fun.qa.user.model.User;
import com.qa.fun.qa.question.model.Question;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Answer extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ANSWER_CONTENT")
	private String answerContent;

	@Column(name = "USER_ID")
	private Long userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private User user;

	@Column(name = "QUESTION_ID")
	private Long questionId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "QUESTION_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Question question;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AnswerVote> answerVotes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Set<AnswerVote> getAnswerVotes() {
		return answerVotes;
	}

	public void setAnswerVotes(Set<AnswerVote> answerVotes) {
		this.answerVotes = answerVotes;
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
		if (!(o instanceof Answer)) return false;
		Answer answer = (Answer) o;
		return Objects.equals(getId(), answer.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
