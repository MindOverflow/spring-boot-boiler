package ru.sber.springboottutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sber.springboottutorial.model.Organization;
import ru.sber.springboottutorial.repository.OrganizationRepository;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;


    @PreAuthorize(value="isMember(#id)")
    @GetMapping("/organizations/{id}")
    @ResponseBody
    public Organization findOrgById(@PathVariable final long id) {
        return organizationRepository.findById(id)
                .orElse(null);
    }
}