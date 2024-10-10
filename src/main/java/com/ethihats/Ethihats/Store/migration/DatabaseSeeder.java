package com.ethihats.Ethihats.Store.migration;

import com.ethihats.Ethihats.Store.model.Role;
import com.ethihats.Ethihats.Store.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            Role userRole = new Role(null, "ROLE_USER");
            Role adminRole = new Role(null, "ROLE_ADMIN");
            roleRepository.saveAll(Arrays.asList(userRole, adminRole));
        }
    }
}
