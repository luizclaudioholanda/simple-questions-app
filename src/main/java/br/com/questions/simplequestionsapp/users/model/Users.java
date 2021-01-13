package br.com.questions.simplequestionsapp.users.model;

import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String login;

    private String email;

    private String password;

    @OneToMany(mappedBy="users")
    private List<FillForm> fillForm;
}
