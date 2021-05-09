package com.collectionart.app.collectionart.user.repositories;

import com.collectionart.app.collectionart.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
}
