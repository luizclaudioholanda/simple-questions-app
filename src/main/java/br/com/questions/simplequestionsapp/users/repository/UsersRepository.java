package br.com.questions.simplequestionsapp.users.repository;

import br.com.questions.simplequestionsapp.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByName(final String name);
    Users findByLogin(final String userLogin);
    Users findByEmail(final String userEmail);
    Users findByLoginAndPassword(final String login, final String password);
}
