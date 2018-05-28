package com.hendisantika.springboottdd.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-tdd
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/05/18
 * Time: 21.08
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("cars");
    }

}