package com.collectionart.app.collectionart.entity.uuidEntity;

import com.collectionart.app.collectionart.entity.UuidEntity;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.Table;

@RunWith(SpringRunner.class)
@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UuidEntityDBTest {

    @Autowired
    private TestEntityManager entityManager;

    @Entity
    @Table(name="uuid_entity_impl")
    private static class UuidEntityImpl extends UuidEntity {

    }

    @Test
    public void shouldSetIdWhenPersistEntity(){
        UuidEntity uuidEntity = new UuidEntityImpl();
        UuidEntity result = entityManager.persist(uuidEntity);
        TestUtils.assertNotNull(result);
    }

    @Test
    public void shouldNotDuplicateWhenInsertManyEntityInDB() {
        try {
            UuidEntity uuidEntity;
            for (int i = 0; i < 100; i++) {
                uuidEntity = new UuidEntityImpl();
                UuidEntity result = entityManager.persistAndFlush(uuidEntity);
            }
            TestUtils.assertTrue(true);
        } catch (EntityExistsException e) {
            TestUtils.fail();
        }
    }

}
