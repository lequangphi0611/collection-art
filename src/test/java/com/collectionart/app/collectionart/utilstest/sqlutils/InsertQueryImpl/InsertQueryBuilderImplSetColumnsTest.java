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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InsertQueryBuilderImplSetColumnsTest {

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

    private Map<String, Object> getMapObject() {
        Map<String, Object> values = new HashMap<>();
        values.put("id", "001");
        values.put("name", "Quang Phi");
        values.put("age", 18);
        return values;
    }

    @Test
    public void testSetColumnsCreateNativeQueryMethod() {
        insertQueryBuilder.setColumns(getMapObject());
        insertQueryBuilder.build();

        TestUtils.assertLastCallWiths(entityManagerMocker.get("createNativeQuery"), "INSERT INTO user(name, id, age) VALUES(?, ?, ?)");
    }

    @Test
    public void testSetColumnSetParameterMethod() {
        insertQueryBuilder.setColumns(getMapObject());
        insertQueryBuilder.build();

        Iterator<Object[]> called = queryMocker.get("setParameter").callWithIterator();
        TestUtils.assertDeepEquals(called.next(), ArrayUtils.objects(1, "Quang Phi"));
        TestUtils.assertDeepEquals(called.next(), ArrayUtils.objects(2, "001"));
        TestUtils.assertDeepEquals(called.next(), ArrayUtils.objects(3, 18));
    }

    @Test(expected = ArgumentInCorrectException.class)
    public void testSetColumnWithColumnIsNull() {
        insertQueryBuilder.setColumns(null);
        insertQueryBuilder.build();
    }

}
