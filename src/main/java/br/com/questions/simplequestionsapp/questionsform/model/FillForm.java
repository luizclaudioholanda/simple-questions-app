package br.com.questions.simplequestionsapp.questionsform.model;

import br.com.questions.simplequestionsapp.users.model.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FILL_FORM")
@Getter
@Setter
public class FillForm {

    @Id
    @GeneratedValue
    private Long id;

    private String createDate;

    private String title;

    @OneToMany(mappedBy="fillForm")
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
