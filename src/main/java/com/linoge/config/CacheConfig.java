package com.linoge.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Timo on 21.02.2017.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    private static final String XML_PATH = "src/main/resources/ehcache.xml";

    @Bean
    public CacheManager ehCacheManager() {
        return CacheManager.create(XML_PATH);
    }
}
