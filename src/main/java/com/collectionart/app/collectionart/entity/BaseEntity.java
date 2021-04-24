package com.collectionart.app.collectionart.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity implements UpdatedTimeModel {

    @CreationTimestamp
    private LocalDateTime lastUpdatedTime = null;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime = null;

    @Override
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    @Override
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
