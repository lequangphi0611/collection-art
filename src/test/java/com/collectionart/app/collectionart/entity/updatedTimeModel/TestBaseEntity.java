package com.collectionart.app.collectionart.entity.updatedTimeModel;

import com.collectionart.app.collectionart.entity.BaseEntity;
import com.collectionart.app.collectionart.entity.IdObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestBaseEntity extends BaseEntity implements IdObject<String> {
    @Id
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
