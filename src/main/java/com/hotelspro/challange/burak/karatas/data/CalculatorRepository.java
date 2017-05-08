package com.hotelspro.challange.burak.karatas.data;

import com.hotelspro.challange.burak.karatas.data.entity.CalculatedEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Created by bkaratas on 08.05.2017.
 */
@Repository
public class CalculatorRepository {

    @Inject
    private RedisTemplate<Long, CalculatedEntity> redisTemplate;

    public void save(CalculatedEntity calculatedEntity) {
        redisTemplate.opsForValue().set(calculatedEntity.getCalculatedId(), calculatedEntity);
    }

}


