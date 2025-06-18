package com.undercloud.application.repository;

import com.undercloud.application.entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<UsersEntity, String> {

     UserDetails findByLogin(String login);
     boolean existsByLogin(String login);
}
