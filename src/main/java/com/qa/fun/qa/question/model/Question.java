package com.qa.fun.qa.question.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.fun.qa.answer.model.Answer;
import com.qa.fun.qa.common.model.BaseEntity;
import com.qa.fun.qa.vote.question.model.QuestionVote;
import com.qa.fun.qa.user.model.User;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Question extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "QUESTION_CONTENT", length = 2048)
	private String questionContent;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Answer> answers;

	@Column(name = "USER_ID")
	private Long userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<QuestionVote> questionVotes;

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<QuestionVote> getQuestionVotes() {
		return questionVotes;
	}

	public void setQuestionVotes(Set<QuestionVote> questionVotes) {
		this.questionVotes = questionVotes;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Question)) return false;
		Question question = (Question) o;
		return Objects.equals(getId(), question.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
