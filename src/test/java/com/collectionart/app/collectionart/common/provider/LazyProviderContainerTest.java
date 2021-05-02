package com.collectionart.app.collectionart.common.provider;

import com.collectionart.app.collectionart.common.provider.impl.LazyProviderContainer;
import com.collectionart.app.collectionart.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

public class LazyProviderContainerTest {

    private int instanceCreatedTime = 0;

    public class ProviderTest {
        public ProviderTest () {
            instanceCreatedTime++;
        }
    }

    private ProviderContainer<ProviderTest> lazyProviderTest;

    @Before
    public void setUp() {
        instanceCreatedTime = 0;
        lazyProviderTest = new LazyProviderContainer<ProviderTest>(ProviderTest::new);
    }

    @Test
    public void testWhenNotCallGet() {
        TestUtils.assertEquals(instanceCreatedTime, 0);
    }

    @Test
    public void testWhenCallOnceGet() {
        ProviderTest providerTest = lazyProviderTest.get();
        TestUtils.assertEquals(instanceCreatedTime, 1);
        TestUtils.assertNotNull(providerTest);
    }

    @Test
    public void testWhenCallTwiceGet() {
        ProviderTest providerTest1 = lazyProviderTest.get();
        ProviderTest providerTest2 = lazyProviderTest.get();
        TestUtils.assertEquals(instanceCreatedTime, 1);
        TestUtils.assertSame(providerTest1, providerTest2);
    }

}
