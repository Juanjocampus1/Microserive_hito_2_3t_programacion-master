package com.empresa.microserviceUserManagement.Repository;

import com.empresa.microserviceUserManagement.Entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {


}
