package br.com.questions.simplequestionsapp.questionsform.model;

import br.com.questions.simplequestionsapp.users.model.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONS")
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private FillForm fillForm;
}
