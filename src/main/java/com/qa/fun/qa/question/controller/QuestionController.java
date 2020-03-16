package com.qa.fun.qa.question.controller;

import com.qa.fun.qa.question.model.QuestionRepo;
import com.qa.fun.qa.vote.question.model.QuestionVoteRepo;
import com.qa.fun.qa.user.model.UserRepo;
import com.qa.fun.qa.question.model.Question;
import com.qa.fun.qa.vote.question.model.QuestionVote;
import com.qa.fun.qa.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

	private static Logger logger = LoggerFactory.getLogger(QuestionController.class.getName());
	@Autowired
	private QuestionRepo questionRepo;

	@Autowired
	private QuestionVoteRepo questionVoteRepo;
	
	@Autowired
	private UserRepo userRepo;

	@RequestMapping({"/question/create", "question/update"})
	public void createQuestion(Question question) {
		questionRepo.save(question);
	}

	@RequestMapping("question/list/all")
	public List<Question> getAllQuestions() {
		return questionRepo.findAll();
	}

	@RequestMapping("question/list/{id}")
	public Question getQuestion(@PathVariable String id) {
		return questionRepo.findById(Long.parseLong(id)).orElse(null);
	}

	@RequestMapping("question/votes/{questionId}")
	public List<QuestionVote> getQuestionVotes(@PathVariable("questionId") Long questionId){
		return questionVoteRepo.findByQuestionVotedId(questionId);
	}
	
	@RequestMapping("user/{userId}")
	public User getUser(@PathVariable("userId") Long userId){
		return userRepo.findById(userId).orElse(null);
	}
	
}
