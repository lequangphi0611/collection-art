package com.collectionart.app.collectionart.repositories;

import com.collectionart.app.collectionart.config.SimpleRepositoryConfiguration;
import com.collectionart.app.collectionart.entity.updatedTimeModel.TestBaseEntity;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(SimpleRepositoryConfiguration.class)
public class SimpleRepositoryNoRecordTest {

 @Autowired
 @Qualifier("SimpleRepository")
 private Repository<TestBaseEntity, String> repository;

 @Test
 public void testFindIdWithNoRecord() {
  Optional<TestBaseEntity> queryResult = repository.findById("ID01");
  TestUtils.assertEmpty(queryResult);
 }

}
