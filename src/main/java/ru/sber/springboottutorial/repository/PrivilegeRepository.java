package ru.sber.springboottutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.springboottutorial.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);
}