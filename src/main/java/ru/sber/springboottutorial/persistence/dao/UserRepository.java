package ru.sber.springboottutorial.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.sber.springboottutorial.persistence.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String username);
    @Transactional
    void removeUserByUsername(String username);
}
