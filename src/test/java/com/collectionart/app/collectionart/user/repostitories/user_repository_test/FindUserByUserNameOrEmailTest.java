package com.collectionart.app.collectionart.user.repostitories.user_repository_test;

import com.collectionart.app.collectionart.auth.AuthorityEntity;
import com.collectionart.app.collectionart.auth.AuthorityFactory;
import com.collectionart.app.collectionart.auth.AuthorityValues;
import com.collectionart.app.collectionart.email.EmailEntity;
import com.collectionart.app.collectionart.role.RoleEntity;
import com.collectionart.app.collectionart.user.UserEntity;
import com.collectionart.app.collectionart.utils.TestUtils;
import lombok.var;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Import(UserRepositoryConfiguration.class)
public class FindUserByUserNameOrEmailTest extends AbstractUserRepositoryTest {

    private EmailEntity emaiLEntity;

    private Collection<RoleEntity> roles;

    private UserEntity userEntity;

    @Before
    public void setUp() {
        createAuthorities().forEach(entityManager::persistAndFlush);
        roles = createRoleEntities().stream().map(role -> entityManager.persistAndFlush(role)).collect(Collectors.toSet());
        emaiLEntity = entityManager.persistAndFlush(createEmail());
        userEntity = entityManager.persistAndFlush(createUserEntity());
    }

    private Collection<AuthorityEntity> createAuthorities() {
        return Arrays.asList(
                AuthorityFactory.createAuthorityEntity(AuthorityValues.CREATE_EMPLOYEE.getName()),
                AuthorityFactory.createAuthorityEntity(AuthorityValues.DELETE_EMPLOYEE.getName())
        );
    }

    private Collection<RoleEntity> createRoleEntities() {
        RoleEntity entity = new RoleEntity();
        entity.setName("ROLE001");
        entity.setAuthorities(createAuthorities());
        return Collections.singletonList(entity);
    }

    private EmailEntity createEmail() {
        EmailEntity entity = new EmailEntity();
        entity.setValue("lequangphi0611@gmail.com");
        entity.setAvailable(true);
        return entity;
    }

    private UserEntity createUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setUsername("lequagnphi0611");
        entity.setFirstName("Quang Phi");
        entity.setLastName("Le");
        entity.setAvatar("/avatars/quangphi.png");
        entity.setEmail(emaiLEntity);
        entity.setPassword("0325400847");
        entity.setBirthDay(LocalDate.of(1999, 11, 6));
        entity.setRoles(roles);
        return entity;
    }

    @Test
    public void testFindUserNameAndEmailNotExists() {
        var result = userRepository.findByUsernameOrEmail("unknown", "unknown");
        TestUtils.assertFalse(result.isPresent());
    }

    @Test
    public void testFindUserName() {
        var result = userRepository.findByUsernameOrEmail("lequagnphi0611", null);
        TestUtils.assertDeepEquals(userEntity, result.orElse(null));
    }

}
