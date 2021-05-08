package com.collectionart.app.collectionart.role;

import com.collectionart.app.collectionart.auth.AuthorityEntity;
import com.collectionart.app.collectionart.entity.UuidEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "role")
public class RoleEntity extends UuidEntity implements Role {

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_name")
    )
    @EqualsAndHashCode.Exclude
    private Set<AuthorityEntity> authorities;

}
