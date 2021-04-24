package com.collectionart.app.collectionart.repositories.historyrepository;

import com.collectionart.app.collectionart.config.SimpleRepositoryConfiguration;
import com.collectionart.app.collectionart.mockers.EntityManagerMocker;
import com.collectionart.app.collectionart.mockers.QueryMocker;
import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.repositories.MapObjectHistoryRepositoryFactory;
import com.collectionart.app.collectionart.utils.BehaviorMocker;
import com.collectionart.app.collectionart.utils.MethodMocker;
import com.collectionart.app.collectionart.utils.MockerUtil;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@Import(MapObjectHistoryRepositoryTestConfiguration.class)
public class MapObjectHistoryRepositoryInsertCase {

    @Autowired
    @Qualifier("historyRepositoryWithoutIgnoreHistoryColumns")
    private HistoryRepository<Map<String, Object>> repository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private Query query;

    private BehaviorMocker entityManagementMocker;

    private MethodMocker createNativeQueryMocker;

    private Map<String, Object> data = createData();

    private Map<String, Object> createData() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", "001009");
        data.put("created_date", LocalDateTime.now());
        data.put("last_updated_date", LocalDateTime.now());
        data.put("user_id", "quangphi001");
        data.put("password", "0773927601");
        data.put("age", 18);
        data.put("created_by", "quangphi001");
        data.put("last_updated_by", "quangphi001");
        return data;
    }

    @Before
    public void setUpBeforeTest() {
        entityManagementMocker = MockerUtil.castBehaviorMocker(entityManager);
        createNativeQueryMocker = entityManagementMocker.get("createNativeQuery");
        entityManagementMocker.resetAll();
        repository.insertHistory(data);
    }

    @Test
    public void testInsertSqlCorrect() {
        Assert.assertEquals(createNativeQueryMocker.getCalledTime(), 1);
        final String columnsInsert = "(before_id, after_id, before_user_id, after_user_id, before_password, after_password, before_created_date, after_created_date, before_last_updated_date, after_last_updated_date, before_created_by, after_created_by, before_last_updated_by, after_last_updated_by)";
        final String valueInsert = "(1?, 2?, 3?, 4?, 5?, 6?, 7?, 8?, 9?, 10?, 11?, 12?, 13?, 14?, 15?, 16?)";
        final String expectedSql = "Insert into user_history" + columnsInsert + " values " + valueInsert;
        TestUtils.assertLastCallWiths(createNativeQueryMocker, new Object[]{expectedSql});
    }

}
