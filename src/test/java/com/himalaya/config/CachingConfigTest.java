package com.himalaya.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class CachingConfigTest {

    @Test
    public void testCacheManager() {

        // Arrange
        CachingConfig config = new CachingConfig();
        CacheManager expectedCacheManager = mock(SimpleCacheManager.class);

        // Act
        CacheManager actualCacheManager = config.CacheManager();

        // Assert
        assertEquals(expectedCacheManager.getClass(), actualCacheManager.getClass());
    }

}