package com.collectionart.app.collectionart.repositories.historyrepository;

import com.collectionart.app.collectionart.common.ArgumentInCorrectException;
import com.collectionart.app.collectionart.repositories.HistoryRepository;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(MapObjectHistoryRepositoryTestConfiguration.class)
public class MapObjectHistoryRepositoryInsertCaseTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    @Qualifier("historyRepository")
    private HistoryRepository<Map<String, Object>> historyRepository;

    public MapObjectHistoryRepositoryInsertCaseTest() {
    }

    @Test
    public void testInsertCorrect() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "001");
        map.put("name", "Quang Phi");
        map.put("age", 18);
        map.put("last_updated_time", LocalDateTime.of(2021, 9, 9, 10, 10));
        map.put("created_time", LocalDateTime.of(2021, 9, 9, 10, 10));
        historyRepository.insertHistory(map);

        TestHistoryEntity entity = entityManager.find(TestHistoryEntity.class, "001");
        TestUtils.assertEquals(entity.getId(), "001");
        TestUtils.assertNull(entity.getBeforeName());
        TestUtils.assertEquals(entity.getAfterName(), "Quang Phi");
        TestUtils.assertNull(entity.getBeforeAge());
        TestUtils.assertEquals(entity.getAfterAge(), 18);
        TestUtils.assertEquals(entity.getLastUpdatedTime(), LocalDateTime.of(2021, 9, 9, 10, 10));
        TestUtils.assertEquals(entity.getCreatedTime(), LocalDateTime.of(2021, 9, 9, 10, 10));
    }

    @Test
    public void testInsertNullMap() {
        try {
            historyRepository.insertHistory(null);
            TestUtils.fail("Should be throw exception");
        } catch (ArgumentInCorrectException exception) {
            TestUtils.assertEquals("[beforeHistory] and [afterHistory] can not be null or empty!", exception.getMessage());
        }
    }

    @Test
    public void testInsertEmptyMap() {
        try {
            historyRepository.insertHistory(Collections.emptyMap());
            TestUtils.fail("Should be throw exception");
        } catch (ArgumentInCorrectException exception) {
            TestUtils.assertEquals("[beforeHistory] and [afterHistory] can not be null or empty!", exception.getMessage());
        }
    }

}
