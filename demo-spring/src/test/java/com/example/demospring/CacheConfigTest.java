package com.example.demospring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CacheConfigTest {
    @Autowired
    private Cache tokenCache;

    @Test
    void testCache() throws InterruptedException {
        tokenCache.put("key", "some value");
        String value = tokenCache.get("key", String.class);
        assertEquals("some value", value);

        tokenCache.evict("key");
        value = tokenCache.get("key", String.class);
        assertNull(value);

        tokenCache.put("key", "some value");
        Thread.sleep(1000);
        value = tokenCache.get("key", String.class);
        assertNull(value);
    }

}
