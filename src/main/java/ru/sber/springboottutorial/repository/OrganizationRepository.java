package ru.sber.springboottutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.springboottutorial.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByName(String name);
}
