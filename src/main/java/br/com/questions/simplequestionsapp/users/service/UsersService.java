package br.com.questions.simplequestionsapp.users.service;

import br.com.questions.simplequestionsapp.users.model.Users;
import br.com.questions.simplequestionsapp.users.repository.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    private UsersService(UsersRepository userRepository){
        this.usersRepository = userRepository;
    }

    public Users save(final Users users){
        return usersRepository.save(users);
    }

    public void delete(final Users users){
        usersRepository.delete(users);
    }

    public void delete(final Long id) {
        usersRepository.deleteById(id);
    }

    public Users update(final Users users){
        return this.save(users);
    }

    public Users findByName(final String name){
        return usersRepository.findByName(name);
    }

    public Users findByEmail(final String email) {
        return usersRepository.findByEmail(email);
    }

    public Users findByLogin(final String login) {
        return usersRepository.findByLogin(login);
    }

    public Users findUser(final String login, final String password) {
        return usersRepository.findByLoginAndPassword(login, password);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Page<Users> find(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    public Users findById(String userId) {
        return usersRepository.findById(Long.valueOf(userId)).get();
    }
}
