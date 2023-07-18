package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.cache.configuration.MutableConfiguration;

import static org.junit.jupiter.api.Assertions.*;

class CacheConfiguration_cacheConfiguration_fd1a1c896a_Test {

    private CacheConfiguration cacheConfiguration;

    @BeforeEach
    public void setUp() {
        cacheConfiguration = new CacheConfiguration();
    }

    @Test
    public void testCacheConfiguration() {
        javax.cache.configuration.Configuration<Object, Object> configuration = cacheConfiguration.cacheConfiguration();
        assertTrue(configuration.isStatisticsEnabled(), "Statistics should be enabled in the configuration");
    }

    @Test
    public void testCacheConfigurationFailure() {
        javax.cache.configuration.Configuration<Object, Object> configuration = cacheConfiguration.cacheConfiguration();
        assertFalse(configuration.isStatisticsEnabled(), "Statistics should not be enabled in the configuration");
    }
}
