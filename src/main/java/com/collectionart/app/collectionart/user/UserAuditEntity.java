package com.collectionart.app.collectionart.user;

import com.collectionart.app.collectionart.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class UserAuditEntity extends BaseEntity implements UserAudit{

    @Column(length = 20)
    private String createdBy;

    @Column(length = 20)
    private String lastUpdatedBy;
}
