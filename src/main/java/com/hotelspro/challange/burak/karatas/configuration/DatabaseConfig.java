package com.hotelspro.challange.burak.karatas.configuration;

import com.hotelspro.challange.burak.karatas.data.entity.CalculatedEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.inject.Inject;

/**
 * Created by bkaratas on 08.05.2017.
 */
@Configuration
public class DatabaseConfig {

    @Inject
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public JacksonJsonRedisSerializer<CalculatedEntity> jacksonJsonRedisJsonSerializer() {
        return new JacksonJsonRedisSerializer<>(CalculatedEntity.class);
    }

    @Bean
    public RedisTemplate<Long, CalculatedEntity> redisTemplate() {
        RedisTemplate<Long, CalculatedEntity> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jacksonJsonRedisJsonSerializer());
        return redisTemplate;
    }

}
