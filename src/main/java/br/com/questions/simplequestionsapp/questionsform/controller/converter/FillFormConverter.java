package br.com.questions.simplequestionsapp.questionsform.controller.converter;

import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.Question;
import br.com.questions.simplequestionsapp.questionsform.model.dto.FillFormDTO;
import br.com.questions.simplequestionsapp.questionsform.model.dto.QuestionDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FillFormConverter {

    private QuestionConverter questionsConverter;

    public FillFormConverter(final QuestionConverter questionsConverter){
        this.questionsConverter = questionsConverter;
    }

    public FillFormDTO toDTO(final FillForm fillForm){
        if(fillForm == null){
            return null;
        }

        FillFormDTO dto = new FillFormDTO();

        dto.setId(fillForm.getId());
        dto.setTitle(fillForm.getTitle());
        dto.setCreatedDate(fillForm.getCreateDate());
        if(fillForm.getQuestions()!=null) {
            dto.setQuestions(questionsConverter.toDTO(fillForm.getQuestions()));
        }

        return dto;
    }

    public FillForm toModel(final FillFormDTO fillFormDTO){
        if(fillFormDTO == null){
            return null;
        }

        FillForm model = new FillForm();

        model.setId(fillFormDTO.getId());
        model.setTitle(fillFormDTO.getTitle());
        model.setCreateDate(fillFormDTO.getCreatedDate());
        if(fillFormDTO.getQuestions()!=null) {
            model.setQuestions(questionsConverter.toModel(fillFormDTO.getQuestions()));
        }

        return model;
    }

    public List<FillFormDTO> toDTO(final List<FillForm> fillForms) {
        return fillForms.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FillForm> toModel(final List<FillFormDTO> fillForm) {
        return fillForm.stream().map(this::toModel).collect(Collectors.toList());
    }
}
