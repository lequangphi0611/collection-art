package com.collectionart.app.collectionart.user.repositories;

import com.collectionart.app.collectionart.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>,
    FindUserByUsernameOrEmailRepository
{
}
