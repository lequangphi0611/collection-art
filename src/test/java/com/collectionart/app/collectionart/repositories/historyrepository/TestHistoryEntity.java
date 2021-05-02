package com.collectionart.app.collectionart.repositories.historyrepository;

import com.collectionart.app.collectionart.entity.BaseEntity;
import com.collectionart.app.collectionart.entity.IdObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_history")
public class TestHistoryEntity extends BaseEntity implements IdObject<String> {

    @Id
    private String id;

    private String beforeName;

    private String afterName;

    private Integer beforeAge;

    private Integer afterAge;

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }

    public String getAfterName() {
        return afterName;
    }

    public void setAfterName(String afterName) {
        this.afterName = afterName;
    }

    public Integer getBeforeAge() {
        return beforeAge;
    }

    public void setBeforeAge(Integer beforeAge) {
        this.beforeAge = beforeAge;
    }

    public Integer getAfterAge() {
        return afterAge;
    }

    public void setAfterAge(Integer afterAge) {
        this.afterAge = afterAge;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
