package com.ethihats.Ethihats.Store.service;
import com.ethihats.Ethihats.Store.exception.UserAlreadyExistsException;
import com.ethihats.Ethihats.Store.model.Role;
import com.ethihats.Ethihats.Store.model.User;
import com.ethihats.Ethihats.Store.repository.RoleRepository;
import com.ethihats.Ethihats.Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists, please choose another one.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roles = roleRepository.findAll();
        List<Role> assignedRoles = roles.stream()
                .filter(role -> user.getRoles().stream()
                        .anyMatch(userRole -> userRole.getName().equals(role.getName())))
                .collect(Collectors.toList());
        user.setRoles(assignedRoles);
        return userRepository.save(user);
    }


}
