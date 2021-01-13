package br.com.questions.simplequestionsapp.questionsform.model.dto;

import br.com.questions.simplequestionsapp.users.dto.UsersDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {

    private Long id;
    private String title;
    private String question;
    private String answer;
    private UsersDTO users;
}
