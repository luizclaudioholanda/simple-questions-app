package br.com.questions.simplequestionsapp.questionsform.service;

import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.Question;
import br.com.questions.simplequestionsapp.questionsform.repository.FillFormRepository;
import br.com.questions.simplequestionsapp.users.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillFormService {

    private FillFormRepository fillFormRepository;

    public FillFormService(final FillFormRepository fillFormRepository){
        this.fillFormRepository = fillFormRepository;
    }

    public List<FillForm> findAll() {
        return fillFormRepository.findAll();
    }

    public List<FillForm> findAllByUser(final Users users) {
        return fillFormRepository.findAllByUsers(users);
    }

    public FillForm add(final FillForm fillForm){
        return fillFormRepository.save(fillForm);
    }

}
