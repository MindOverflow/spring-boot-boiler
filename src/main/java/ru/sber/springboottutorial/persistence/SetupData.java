package ru.sber.springboottutorial.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.sber.springboottutorial.repository.OrganizationRepository;
import ru.sber.springboottutorial.repository.PrivilegeRepository;
import ru.sber.springboottutorial.repository.UserRepository;
import ru.sber.springboottutorial.model.Organization;
import ru.sber.springboottutorial.model.Privilege;
import ru.sber.springboottutorial.model.User;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

@Slf4j
@Component
public class SetupData {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        log.info("Выполнение метода init");
        initPrivileges();
        initOrganizations();
        initUsers();
    }

    private void initUsers() {
        final Privilege privilege1 = privilegeRepository.findByName("FOO_READ_PRIVILEGE");
        final Privilege privilege2 = privilegeRepository.findByName("FOO_WRITE_PRIVILEGE");

        final User user1 = new User();
        user1.setUsername("smith");
        user1.setPassword(encoder.encode("111"));
        user1.setPrivileges(new HashSet<>(Arrays.asList(privilege1)));
        user1.setOrganization(organizationRepository.findByName("FirstOrg"));
        userRepository.save(user1);

        final User user2 = new User();
        user2.setUsername("reingardt");
        user2.setPassword(encoder.encode("222"));
        user2.setPrivileges(new HashSet<>(Arrays.asList(privilege1, privilege2)));
        user2.setOrganization(organizationRepository.findByName("SecondOrg"));
        userRepository.save(user2);
    }

    private void initOrganizations() {
        final Organization org1 = new Organization("FirstOrg");
        organizationRepository.save(org1);

        final Organization org2 = new Organization("SecondOrg");
        organizationRepository.save(org2);
    }

    private void initPrivileges() {
        final Privilege privilege1 = new Privilege("FOO_READ_PRIVILEGE");
        privilegeRepository.save(privilege1);

        final Privilege privilege2 = new Privilege("FOO_WRITE_PRIVILEGE");
        privilegeRepository.save(privilege2);
    }
}