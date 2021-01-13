package br.com.questions.simplequestionsapp.questionsform.controller;

import br.com.questions.simplequestionsapp.questionsform.controller.converter.QuestionConverter;
import br.com.questions.simplequestionsapp.questionsform.model.Question;
import br.com.questions.simplequestionsapp.questionsform.model.dto.QuestionDTO;
import br.com.questions.simplequestionsapp.questionsform.service.FillFormService;
import br.com.questions.simplequestionsapp.questionsform.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionController {

    private QuestionService questionService;
    private QuestionConverter questionConverter;
    private FillFormService fillFormService;

    public QuestionController(final QuestionService questionService,
                              final QuestionConverter questionConverter,
                              final FillFormService fillFormService){
        this.questionService = questionService;
        this.questionConverter = questionConverter;
        this.fillFormService = fillFormService;
    }



    @PostMapping("/questions")
    public void add(@ModelAttribute("question") QuestionDTO questionDTO, Model model) {

        Question question = questionConverter.toModel(questionDTO);
        questionService.add(question);
    }

    @GetMapping("/create-questions")
    public String findAll(Model model) {
        List<Question> listQuestions = questionService.findAll();
        model.addAttribute("questions", listQuestions);
        model.addAttribute("questionDTO", new QuestionDTO());
        return "create_question";
    }
}
