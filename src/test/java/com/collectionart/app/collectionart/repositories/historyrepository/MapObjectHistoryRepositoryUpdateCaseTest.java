package com.collectionart.app.collectionart.repositories.historyrepository;

import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(MapObjectHistoryRepositoryTestConfiguration.class)
public class MapObjectHistoryRepositoryUpdateCaseTest {

    @Autowired()
    @Qualifier("historyRepository")
    private HistoryRepository<Map<String, Object>> historyRepository;

    @Autowired
    private EntityManager entityManager;

    private Map<String, Object> beforeHistory;

    private Map<String, Object> afterHistory;

    @Before
    public void setUp() {
        beforeHistory = new HashMap<>();
        afterHistory = new HashMap<>();
    }

    @Test
    public void testUpdateNormalCase() {
        beforeHistory.put("id", "001");
        beforeHistory.put("name", "Quang Phi");
        afterHistory.put("id", "002");
        afterHistory.put("name", "Quang Phi 1");
        afterHistory.put("age", 19);
        historyRepository.insertHistory(beforeHistory, afterHistory);

        TestHistoryEntity entity = entityManager.find(TestHistoryEntity.class, "002");
        TestUtils.assertEquals("002", entity.getId());
        TestUtils.assertEquals("Quang Phi", entity.getBeforeName());
        TestUtils.assertEquals("Quang Phi 1", entity.getAfterName());
        TestUtils.assertNull(entity.getBeforeAge());
        TestUtils.assertEquals(19, entity.getAfterAge());
        TestUtils.assertNull(entity.getCreatedTime());
        TestUtils.assertNull(entity.getLastUpdatedTime());
    }


}
