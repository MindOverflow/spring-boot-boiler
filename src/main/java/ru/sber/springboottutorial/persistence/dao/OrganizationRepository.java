package ru.sber.springboottutorial.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.springboottutorial.persistence.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByName(String name);
}
