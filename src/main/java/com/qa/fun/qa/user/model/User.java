package com.qa.fun.qa.user.model;

import com.qa.fun.qa.answer.model.Answer;
import com.qa.fun.qa.common.model.BaseEntity;
import com.qa.fun.qa.question.model.Question;
import com.qa.fun.qa.vote.answer.model.AnswerVote;
import com.qa.fun.qa.vote.question.model.QuestionVote;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "USER_TABLE")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "USER_ROLE")
	private String userRole;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Answer> answers;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Question> questions;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<QuestionVote> questionVotes;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AnswerVote> answerVotes;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<QuestionVote> getQuestionVotes() {
		return questionVotes;
	}

	public void setQuestionVotes(Set<QuestionVote> questionVotes) {
		this.questionVotes = questionVotes;
	}

	public Set<AnswerVote> getAnswerVotes() {
		return answerVotes;
	}

	public void setAnswerVotes(Set<AnswerVote> answerVotes) {
		this.answerVotes = answerVotes;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return Objects.equals(getId(), user.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
