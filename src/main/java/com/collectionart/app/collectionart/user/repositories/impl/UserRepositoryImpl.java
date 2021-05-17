package com.collectionart.app.collectionart.user.repositories.impl;

import com.collectionart.app.collectionart.user.User;
import com.collectionart.app.collectionart.user.UserEntity;
import com.collectionart.app.collectionart.user.repositories.FindUserByUsernameOrEmailRepository;
import com.collectionart.app.collectionart.user.repositories.UserRepository;
import lombok.var;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements FindUserByUsernameOrEmailRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_USER_NAME_OR_EMAIL = "SELECT * \n" +
            "FROM user u, \n" +
            "email e \n" +
            "WHERE u.email_id = e.id AND (u.username = ? OR e.value = ?)";

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UserEntity> findByUsernameOrEmail(String username, String email) {
        var found = entityManager
                .createNativeQuery(FIND_BY_USER_NAME_OR_EMAIL, UserEntity.class)
                .setParameter(1, username)
                .setParameter(2, email)
                .getSingleResult();
        return Optional.ofNullable((UserEntity) found);
    }

}
