package com.physilink.repository.user;

import com.physilink.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Vignesh G
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
