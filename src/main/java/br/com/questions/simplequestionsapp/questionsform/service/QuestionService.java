package br.com.questions.simplequestionsapp.questionsform.service;

import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.Question;
import br.com.questions.simplequestionsapp.questionsform.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionsRepository;

    public QuestionService(final QuestionRepository questionsRepository){
        this.questionsRepository = questionsRepository;
    }

    public List<Question> findAll() {
        return questionsRepository.findAll();
    }

    public void add(final Question question){
        questionsRepository.save(question);
    }

    public List<Question> findAllByFillForm(final FillForm fillForm){
        return questionsRepository.findAllByFillForm(fillForm);
    }

}
