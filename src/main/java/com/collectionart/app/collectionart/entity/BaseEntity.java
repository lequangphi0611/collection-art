package com.collectionart.app.collectionart.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements UpdatedTimeModel {

    @CreationTimestamp
    private LocalDateTime lastUpdatedTime;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime;

}
