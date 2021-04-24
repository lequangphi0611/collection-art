package com.collectionart.app.collectionart.entity.uuidEntity;

import com.collectionart.app.collectionart.entity.BaseEntity;
import com.collectionart.app.collectionart.entity.UuidEntity;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UuidEntityTest {

    private UuidEntity entity;

    @Before
    public void setup() {
        entity = new UuidEntity();
    }

    @Test
    public void isBaseEntity() {
        TestUtils.assertTrue(entity instanceof BaseEntity);
    }

    @Test
    public void shouldReturnIdNullWhenCreateInstance() {
        TestUtils.assertNull(entity.getId());
    }

}
