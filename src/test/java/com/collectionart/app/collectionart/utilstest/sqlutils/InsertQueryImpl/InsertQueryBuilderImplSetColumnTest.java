package com.collectionart.app.collectionart.utilstest.sqlutils.InsertQueryImpl;

import com.collectionart.app.collectionart.common.ArgumentInCorrectException;
import com.collectionart.app.collectionart.mockers.EntityManagerMocker;
import com.collectionart.app.collectionart.mockers.QueryMocker;
import com.collectionart.app.collectionart.utils.ArrayUtils;
import com.collectionart.app.collectionart.utils.ResettableManager;
import com.collectionart.app.collectionart.utils.SimpleResettableManager;
import com.collectionart.app.collectionart.utils.TestUtils;
import com.collectionart.app.collectionart.utils.sqlutils.InsertQueryBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.impls.InsertQueryBuilderImpl;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Query;
import java.util.Iterator;

public class InsertQueryBuilderImplSetColumnTest {

    private QueryMocker queryMocker;

    private EntityManagerMocker entityManagerMocker;

    private InsertQueryBuilder insertQueryBuilder;

    private ResettableManager resettableManager;

    private Query result;

    private void setUpProvider() {
        resettableManager = new SimpleResettableManager();
        queryMocker = new QueryMocker();
        entityManagerMocker = new EntityManagerMocker(queryMocker);
        resettableManager.add(queryMocker);
        resettableManager.add(entityManagerMocker);
    }

    @Before
    public void setUp() {
        setUpProvider();
        resettableManager.reset();
        insertQueryBuilder = new InsertQueryBuilderImpl("user", entityManagerMocker);
    };

    @Test
    public void testCallCreateNativeQuery() {
        insertQueryBuilder.setColumn("id", "001");
        insertQueryBuilder.setColumn("name", "Quang Phi");
        insertQueryBuilder.setColumn("age", 18);

        result = insertQueryBuilder.build();
        TestUtils.assertLastCallWiths(entityManagerMocker.get("createNativeQuery"), "INSERT INTO user(id, name, age) VALUES(?, ?, ?)");
    }

    @Test
    public void testCallSetParameters() {
        insertQueryBuilder.setColumn("id", "001");
        insertQueryBuilder.setColumn("name", "Quang Phi");
        insertQueryBuilder.setColumn("age", 18);

        result = insertQueryBuilder.build();
        Iterator<Object[]> called = queryMocker.get("setParameter").callWithIterator();
        TestUtils.assertDeepEquals(called.next(), ArrayUtils.objects(1, "001"));
        TestUtils.assertDeepEquals(called.next(), ArrayUtils.objects(2, "Quang Phi"));
        TestUtils.assertDeepEquals(called.next(), ArrayUtils.objects(3, 18));
    }

    @Test(expected = ArgumentInCorrectException.class)
    public void testSetColumnWithNullColumn() {
        insertQueryBuilder.setColumn(null, "001");
        insertQueryBuilder.build();
    }

}
