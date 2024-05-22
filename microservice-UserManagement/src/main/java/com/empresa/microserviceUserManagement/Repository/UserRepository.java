package com.empresa.microserviceUserManagement.Repository;

import com.empresa.microserviceUserManagement.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{


    Optional<UserEntity> findByUsername(String username);
}
