package com.physilink.repository.user;

import com.physilink.model.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Vignesh G
 */
public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);

}
