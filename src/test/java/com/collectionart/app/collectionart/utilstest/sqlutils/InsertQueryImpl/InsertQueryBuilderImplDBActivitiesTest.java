package com.collectionart.app.collectionart.utilstest.sqlutils.InsertQueryImpl;

import com.collectionart.app.collectionart.entity.updatedTimeModel.TestBaseEntity;
import com.collectionart.app.collectionart.utils.TestUtils;
import com.collectionart.app.collectionart.utils.sqlutils.InsertQueryBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.impls.InsertQueryBuilderImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InsertQueryBuilderImplDBActivitiesTest {

    @Autowired
    private EntityManager entityManager;

    private InsertQueryBuilder insertQueryBuilder;

    @Before
    public void setUp() {
        this.insertQueryBuilder = new InsertQueryBuilderImpl("test_base_entity", entityManager);
    }

    @Test
    public void testDBActivities() {
        this.insertQueryBuilder.setColumn("id", "001");
        this.insertQueryBuilder.setColumn("name", "Quang Phi");
        this.insertQueryBuilder.build().executeUpdate();
        TestBaseEntity testBaseEntity = entityManager.find(TestBaseEntity.class, "001");
        TestUtils.assertEquals(testBaseEntity.getId(), "001");
        TestUtils.assertEquals(testBaseEntity.getName(), "Quang Phi");
    }

}
