package br.com.questions.simplequestionsapp.questionsform.controller.converter;

import br.com.questions.simplequestionsapp.questionsform.model.Question;
import br.com.questions.simplequestionsapp.questionsform.model.dto.QuestionDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionConverter {

    public QuestionDTO toDTO(final Question question){
        if(question == null){
            return null;
        }

        QuestionDTO dto = new QuestionDTO();

        dto.setId(question.getId());
        dto.setQuestion(question.getQuestion());
        dto.setAnswer(question.getAnswer());

        return dto;
    }

    public Question toModel(final QuestionDTO questionDTO){
        if(questionDTO == null){
            return null;
        }

        Question model = new Question();

        model.setId(questionDTO.getId());
        model.setQuestion(questionDTO.getQuestion());
        model.setAnswer(questionDTO.getAnswer());

        return model;
    }

    public List<QuestionDTO> toDTO(final List<Question> questions) {
        return questions.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Question> toModel(final List<QuestionDTO> question) {
        return question.stream().map(this::toModel).collect(Collectors.toList());
    }
}
