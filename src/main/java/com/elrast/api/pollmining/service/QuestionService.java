package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Question;
import com.elrast.api.pollmining.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(Question question) {

//        questionRepository.sav
        return null;
    }

    public List<Question> lookup() {
        return questionRepository.findAll();
    }
}
