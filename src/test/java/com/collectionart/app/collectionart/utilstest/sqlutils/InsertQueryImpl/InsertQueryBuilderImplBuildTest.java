package com.collectionart.app.collectionart.utilstest.sqlutils.InsertQueryImpl;

import com.collectionart.app.collectionart.common.CannotBuildException;
import com.collectionart.app.collectionart.mockers.EntityManagerMocker;
import com.collectionart.app.collectionart.mockers.QueryMocker;
import com.collectionart.app.collectionart.utils.ResettableManager;
import com.collectionart.app.collectionart.utils.SimpleResettableManager;
import com.collectionart.app.collectionart.utils.TestUtils;
import com.collectionart.app.collectionart.utils.sqlutils.InsertQueryBuilder;
import com.collectionart.app.collectionart.utils.sqlutils.impls.InsertQueryBuilderImpl;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Query;

public class InsertQueryBuilderImplBuildTest {

    private EntityManagerMocker entityManagerMocker;

    private InsertQueryBuilder insertQueryBuilder;

    private void setUpProvider() {
        entityManagerMocker = new EntityManagerMocker();
    }

    @Before
    public void setUp() {
        setUpProvider();
        insertQueryBuilder = new InsertQueryBuilderImpl("user", entityManagerMocker);
    };

    @Test
    public void testBuildWithoutSetColumn() {
        try {
            insertQueryBuilder.build();
            TestUtils.fail("Should be throw exception");
        } catch (CannotBuildException e) {
            TestUtils.assertEquals(e.getMessage(), "Cannot build without column !");
        }
    }

}
