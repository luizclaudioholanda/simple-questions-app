package br.com.questions.simplequestionsapp.questionsform.repository;

import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.Question;
import br.com.questions.simplequestionsapp.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FillFormRepository extends JpaRepository<FillForm, Long> {

    List<FillForm> findAllByUsers(Users users);

}
