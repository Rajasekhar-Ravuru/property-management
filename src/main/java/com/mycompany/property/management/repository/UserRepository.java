package com.mycompany.property.management.repository;

import com.mycompany.property.management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
