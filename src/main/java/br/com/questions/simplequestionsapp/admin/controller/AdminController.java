package br.com.questions.simplequestionsapp.admin.controller;

import br.com.questions.simplequestionsapp.questionsform.controller.converter.FillFormConverter;
import br.com.questions.simplequestionsapp.questionsform.model.FillForm;
import br.com.questions.simplequestionsapp.questionsform.model.dto.FillFormDTO;
import br.com.questions.simplequestionsapp.questionsform.service.FillFormService;
import br.com.questions.simplequestionsapp.users.model.Users;
import br.com.questions.simplequestionsapp.users.service.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class AdminController {

    private UsersService usersService;
    private FillFormService fillFormService;
    private FillFormConverter fillFormConverter;

    public AdminController(final UsersService usersService,
                           final FillFormService fillFormService,
                           final FillFormConverter fillFormConverter){
        this.usersService = usersService;
        this.fillFormService = fillFormService;
        this.fillFormConverter = fillFormConverter;
    }

    @Value("${spring.application.name}")
    String appName;

    @PostMapping("/login")
    public String login(@ModelAttribute Users users, Model model) {
        final Users existedUser = usersService.findUser(users.getLogin(),users.getPassword());

        if(existedUser != null){
            List<FillForm> fillFormList = fillFormService.findAllByUser(existedUser);
            List<FillFormDTO> fillFormListDTO = fillFormConverter.toDTO(fillFormList);

            model.addAttribute("userId",existedUser.getId());
            model.addAttribute("fillFormListDTO", fillFormListDTO);

            return "view_form";
        } else {
            return "index";
        }
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

}
