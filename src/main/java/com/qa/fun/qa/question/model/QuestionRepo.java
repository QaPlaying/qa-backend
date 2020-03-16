package com.qa.fun.qa.question.model;

import com.qa.fun.qa.question.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {}
