package com.ethihats.Ethihats.Store.service;
import com.ethihats.Ethihats.Store.exception.UserAlreadyExistsException;
import com.ethihats.Ethihats.Store.model.Role;
import com.ethihats.Ethihats.Store.model.User;
import com.ethihats.Ethihats.Store.repository.RoleRepository;
import com.ethihats.Ethihats.Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
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

    public User registerUser(User user) throws RoleNotFoundException {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists, please choose another one.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> assignedRoles = roleRepository.findAllById(user.getRoleIds());
        if (assignedRoles.size() != user.getRoleIds().size()) {
            throw new RoleNotFoundException("One or more roles not found");
        }
        user.setRole(assignedRoles);
        return userRepository.save(user);
    }



}
