package com.example.demospring.config;

import com.google.common.cache.CacheBuilder;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class CacheConfig {
    public static final String CACHE_NAME = "TOKEN_CACHE";
    private final Long cacheExpire = 1000L;

    @Bean
    public Cache tokenCache() {
        CacheManager manager = new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String name) {
                return new ConcurrentMapCache(
                        name,
                        CacheBuilder.newBuilder()
                                .expireAfterWrite(cacheExpire, TimeUnit.MILLISECONDS)
                                .build()
                                .asMap(),
                        true);
            }
        };
        return manager.getCache(CACHE_NAME);
    }
}
