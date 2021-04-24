package com.collectionart.app.collectionart.entity.updatedTimeModel;

import com.collectionart.app.collectionart.entity.BaseEntity;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {
        "spring.jpa.hibernate.ddl-auto=none"
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BaseEntityTest {

    private static final String ID_ENTITY = "001";

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUpBeforeTest() {
        TestBaseEntity entity = new TestBaseEntity();
        entity.setId(ID_ENTITY);
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.clear();
    }

    private TestBaseEntity createUpdateEntity() {
        TestBaseEntity updateEntity  = new TestBaseEntity();
        updateEntity.setId(ID_ENTITY);
        updateEntity.setName("new name");
        return updateEntity;
    }

    @Test
    public void shouldSetCreateTimeWhenInsertHistoryEntity() {
        BaseEntity result = entityManager.find(TestBaseEntity.class, ID_ENTITY);
        Assert.assertNotNull(result.getCreatedTime());
    }

    @Test
    public void shouldCreateTimeBeNotUpdateWhenUpdateHistoryEntity() {
        LocalDateTime beforeUpdate = entityManager.find(TestBaseEntity.class, ID_ENTITY).getCreatedTime();
        TestBaseEntity newEntity = createUpdateEntity();
        entityManager.merge(newEntity);
        entityManager.flush();
        entityManager.clear();
        LocalDateTime afterUpdate = entityManager.find(TestBaseEntity.class, ID_ENTITY).getCreatedTime();
        Assert.assertEquals(beforeUpdate, afterUpdate);
    }

    @Test
    public void shouldSetLastUpdatedDateWhenInsertHistoryEntity() {
        BaseEntity result = entityManager.find(TestBaseEntity.class, ID_ENTITY);
        Assert.assertNotNull(result.getLastUpdatedTime());
    }

    @Test
    public void shouldLastUpdatedTimeBeNotUpdateWhenUpdateHistoryEntity() {
        LocalDateTime beforeUpdate = entityManager.find(TestBaseEntity.class, ID_ENTITY).getLastUpdatedTime();
        TestBaseEntity newEntity = createUpdateEntity();
        entityManager.merge(newEntity);
        entityManager.flush();
        entityManager.clear();
        LocalDateTime afterUpdate = entityManager.find(TestBaseEntity.class, ID_ENTITY).getLastUpdatedTime();
        Assert.assertNotEquals(beforeUpdate, afterUpdate);
    }
}
