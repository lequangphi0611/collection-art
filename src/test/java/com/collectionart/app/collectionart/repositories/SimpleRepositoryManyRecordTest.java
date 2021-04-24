package com.collectionart.app.collectionart.repositories;

import com.collectionart.app.collectionart.config.SimpleRepositoryConfiguration;
import com.collectionart.app.collectionart.entity.updatedTimeModel.TestBaseEntity;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(SimpleRepositoryConfiguration.class)
public class SimpleRepositoryManyRecordTest {

 @Autowired
 @Qualifier("SimpleRepository")
 private Repository<TestBaseEntity, String> repository;

 @Autowired
 private TestEntityManager entityManager;

 private void setUpRecord() {
  TestBaseEntity entity = new TestBaseEntity();
  entity.setId("001");
  entity.setName("Name01");
  entityManager.persist(entity);
  entityManager.flush();
 }

 Optional<TestBaseEntity> queryResult;

 @Before
 public void beforeEach(){
  setUpRecord();
  queryResult = repository.findById("001");
 }

 @Test
 public void testFindByID() {
  TestUtils.assertNotNull(queryResult.get());
 }

 @Test
 public void testFindByIDProperties() {
  TestUtils.assertEquals(queryResult.get().getId(), "001");
  TestUtils.assertEquals(queryResult.get().getName(), "Name01");
 }

}
