package com.qa.fun.qa.vote.answer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerVoteRepo extends JpaRepository<AnswerVote, Long> {}
