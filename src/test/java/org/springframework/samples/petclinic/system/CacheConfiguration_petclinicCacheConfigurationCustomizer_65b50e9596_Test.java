package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.cache.configuration.MutableConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableCaching
public class CacheConfiguration_petclinicCacheConfigurationCustomizer_65b50e9596_Test {

    @Autowired
    private CacheConfiguration cacheConfiguration;

    @MockBean
    private JCacheManagerCustomizer jCacheManagerCustomizer;

    @Test
    public void testPetclinicCacheConfigurationCustomizer() {
        MutableConfiguration<String, Object> cacheConfiguration = new MutableConfiguration<>();

        when(jCacheManagerCustomizer.createCache(anyString(), any())).thenReturn(cacheConfiguration);

        JCacheManagerCustomizer result = this.cacheConfiguration.petclinicCacheConfigurationCustomizer();

        verify(jCacheManagerCustomizer, times(1)).createCache(anyString(), any());
    }

    @Test
    public void testPetclinicCacheConfigurationCustomizer_Failure() {
        MutableConfiguration<String, Object> cacheConfiguration = new MutableConfiguration<>();

        when(jCacheManagerCustomizer.createCache(anyString(), any())).thenThrow(new RuntimeException());

        try {
            JCacheManagerCustomizer result = this.cacheConfiguration.petclinicCacheConfigurationCustomizer();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }

        verify(jCacheManagerCustomizer, times(1)).createCache(anyString(), any());
    }
}
