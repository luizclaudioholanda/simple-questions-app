package br.com.questions.simplequestionsapp.users.controller;

import br.com.questions.simplequestionsapp.users.controller.converter.UsersConverter;
import br.com.questions.simplequestionsapp.users.dto.UsersDTO;
import br.com.questions.simplequestionsapp.users.model.Users;
import br.com.questions.simplequestionsapp.users.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UsersService usersService;
    private UsersConverter usersConverter;

    private UserController(final UsersService userService, final UsersConverter usersConverter){
        this.usersService = userService;
        this.usersConverter = usersConverter;
    }

    @PostMapping
    public void add(@RequestBody UsersDTO dto) {
        Users users = usersConverter.toModel(dto);
        usersService.save(users);
    }

    @DeleteMapping(value = "{id}")
    public void remove(@PathVariable("id") final Long id){
        usersService.delete(id);
    }

    @GetMapping
    public Page<UsersDTO> find(Pageable pageable) {
        Page<Users> page = usersService.find(pageable);
        return new PageImpl<>(usersConverter.toDTO(page.getContent()), pageable, page.getTotalElements());
    }
}
