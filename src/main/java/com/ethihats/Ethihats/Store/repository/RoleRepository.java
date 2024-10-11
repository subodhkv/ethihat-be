package com.ethihats.Ethihats.Store.repository;
import com.ethihats.Ethihats.Store.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
