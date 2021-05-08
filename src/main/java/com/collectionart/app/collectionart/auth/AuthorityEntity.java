package com.collectionart.app.collectionart.auth;

import com.collectionart.app.collectionart.role.Role;
import com.collectionart.app.collectionart.role.RoleEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = AuthorityConstants.ENTITY_AUTHORITY_TABLE_NAME)
public class AuthorityEntity implements Authority {

    protected AuthorityEntity (){
    }

    @Id
    @Column(
        name = AuthorityConstants.ENTITY_AUTHORITY_NAME_COLUMN,
        length = 10
    )
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = AuthorityConstants.ENTITY_AUTHORITY_MAPPED_COLUMN_NAME)
    private Set<RoleEntity> roles;

}
