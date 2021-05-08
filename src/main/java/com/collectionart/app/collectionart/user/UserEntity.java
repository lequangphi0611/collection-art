package com.collectionart.app.collectionart.user;

import com.collectionart.app.collectionart.email.EmailConstants;
import com.collectionart.app.collectionart.email.EmailEntity;
import com.collectionart.app.collectionart.role.RoleEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = UserConstants.ENTITY_TABLE_NAME)
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends UserAuditEntity implements User {

    @Id
    @Column(length = 20)
    private String username;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    private LocalDate birthDay;

    private String avatar;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = UserConstants.ENTITY_USER_ROLE,
            joinColumns = @JoinColumn(name = UserConstants.USER_USERNAME),
            inverseJoinColumns = @JoinColumn(name = UserConstants.ROLE_ID)
    )
    private Collection<RoleEntity> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = EmailConstants.EMAIL, referencedColumnName = EmailConstants.ID)
    private EmailEntity email;
}
