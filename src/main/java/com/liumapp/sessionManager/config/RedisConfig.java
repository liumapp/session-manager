package com.liumapp.sessionManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by liumapp on 11/11/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory connectionFactory () {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("adminadmin");
        return jedisConnectionFactory;
    }

    @Bean
    RedisTemplate<String, Object> intRedisTemplate(JedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

//    @Bean
//    ValueOperations<String, Integer> intOperations(RedisTemplate<String, Integer> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }
//
//    @Bean
//    RedisTemplate<String, Object> objRedisTemplate(JedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        return redisTemplate;
//    }
//
//    @Bean
//    ValueOperations<String, Object> objOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }

}
