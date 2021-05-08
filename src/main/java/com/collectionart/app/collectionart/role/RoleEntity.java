package com.collectionart.app.collectionart.role;

import com.collectionart.app.collectionart.auth.AuthorityEntity;
import com.collectionart.app.collectionart.entity.UuidEntity;
import com.collectionart.app.collectionart.user.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = RoleConstants.ENTITY_TABLE_NAME)
public class RoleEntity extends UuidEntity implements Role {

    @Column(length = 50)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = RoleConstants.JOIN_TABLE_AUTHORITIES_TABLE_NAME,
            joinColumns = @JoinColumn(name = RoleConstants.JOIN_TABLE_AUTHORITIES_JOIN_COLUMN),
            inverseJoinColumns = @JoinColumn(name = RoleConstants.JOIN_TABLE_AUTHORITIES_INVERSE_COLUMN)
    )
    private Collection<AuthorityEntity> authorities;

    @ManyToMany(mappedBy = RoleConstants.JOIN_TABLE_USERS_MAPPED_BY)
    private Collection<UserEntity> users;

}
