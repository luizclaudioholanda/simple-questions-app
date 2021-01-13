package br.com.questions.simplequestionsapp.users.dto;

import br.com.questions.simplequestionsapp.questionsform.model.dto.QuestionDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersDTO {

    private Long id;
    private String name;
    private String login;
    private String email;
    private String password;
    private List<QuestionDTO> questions;
}
