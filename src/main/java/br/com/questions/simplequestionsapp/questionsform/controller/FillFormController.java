package br.com.questions.simplequestionsapp.questionsform.controller;

import br.com.questions.simplequestionsapp.questionsform.controller.converter.FillFormConverter;
import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.dto.FillFormDTO;
import br.com.questions.simplequestionsapp.questionsform.service.FillFormService;
import br.com.questions.simplequestionsapp.users.model.Users;
import br.com.questions.simplequestionsapp.users.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/fill-forms")
public class FillFormController {

    private FillFormConverter fillFormConverter;
    private FillFormService fillFormService;
    private UsersService usersService;

    public FillFormController(final FillFormConverter fillFormConverter,
                              final FillFormService fillFormService,
                              final UsersService usersService){
        this.fillFormConverter = fillFormConverter;
        this.fillFormService = fillFormService;
        this.usersService = usersService;
    }

    @PostMapping
    public String saveForm(@ModelAttribute("fillForm") FillFormDTO fillFormDTO, Model model){

        FillForm form = fillFormConverter.toModel(fillFormDTO);
        Users users = usersService.findById(fillFormDTO.getUserId());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());

        form.setUsers(users);
        form.setCreateDate(date);

        fillFormService.add(form);

        model.addAttribute("fillFormDTO", new FillFormDTO());
        model.addAttribute("formId",form.getId());
        return "create_form";
    }

    @GetMapping
    public String createForm(Model model) {

        List<FillForm> fillFormList = fillFormService.findAll();
        List<FillFormDTO> fillFormListDTO = fillFormConverter.toDTO(fillFormList);

        model.addAttribute("fillFormDTO", new FillFormDTO());
        model.addAttribute("fillFormListDTO", fillFormListDTO);

        return "create_form";
    }
}
