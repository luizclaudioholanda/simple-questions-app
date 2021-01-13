package br.com.questions.simplequestionsapp.questionsform.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FillFormDTO {

    private Long id;
    private List<QuestionDTO> questions;
    private String title;
    private String createdDate;
    private String userId;

    public void addQuestion(QuestionDTO question){
        this.questions.add(question);
    }
}
