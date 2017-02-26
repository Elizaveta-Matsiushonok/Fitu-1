package com.linoge.controllers.rest;

import com.linoge.config.CacheConfig;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Timo on 25.02.2017.
 */
@RestController
@RequestMapping("/")
public class StatsResourceController {

    @Autowired
    private CacheConfig cacheConfig;

    @RequestMapping(path = "/getstats", method = RequestMethod.GET)
    public String stats() {
        StringBuffer sb = new StringBuffer();

        CacheManager cacheManager = cacheConfig.ehCacheManager();
        /* get stats for all known caches */
        for (String name : cacheManager.getCacheNames()) {
            Cache cache = cacheManager.getCache(name);
            Statistics stats = cache.getStatistics();

            sb.append(String.format("%s: %s objects, %s hits, %s misses\n",
                    name,
                    stats.getObjectCount(),
                    stats.getCacheHits(),
                    stats.getCacheMisses()
            ));
        }
        return sb.toString();
    }
}
