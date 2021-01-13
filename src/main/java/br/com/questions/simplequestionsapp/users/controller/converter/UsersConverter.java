package br.com.questions.simplequestionsapp.users.controller.converter;

import br.com.questions.simplequestionsapp.questionsform.controller.converter.QuestionConverter;
import br.com.questions.simplequestionsapp.users.dto.UsersDTO;
import br.com.questions.simplequestionsapp.users.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersConverter {

    private QuestionConverter questionsConverter;

    public UsersConverter(final QuestionConverter questionsConverter){
        this.questionsConverter = questionsConverter;
    }

    public UsersDTO toDTO(final Users users){
        if(users == null){
            return null;
        }

        UsersDTO dto = new UsersDTO();

        dto.setId(users.getId());
        dto.setEmail(users.getEmail());
        dto.setPassword(users.getPassword());
        dto.setLogin(users.getLogin());
        dto.setName(users.getName());

        return dto;
    }

    public Users toModel(final UsersDTO usersDTO){
        if(usersDTO == null){
            return null;
        }

        Users model = new Users();

        model.setId(usersDTO.getId());
        model.setEmail(usersDTO.getEmail());
        model.setPassword(usersDTO.getPassword());
        model.setLogin(usersDTO.getLogin());
        model.setName(usersDTO.getName());

        return model;
    }

    public List<UsersDTO> toDTO(final List<Users> users) {
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Users> toModel(final List<UsersDTO> usersDTO) {
        return usersDTO.stream().map(this::toModel).collect(Collectors.toList());
    }
}
