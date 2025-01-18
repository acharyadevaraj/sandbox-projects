package com.learning.springrediscache.controller;

import com.learning.springrediscache.constant.RedisConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    private final RedisTemplate<String, Object> redisTemplate;

    @Value("${redis.defaultTTL}")
    private long defaultTTL;

    public RedisController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addValue(@RequestParam String key, @RequestParam String value) {
        try {
            redisTemplate.opsForHash().put(RedisConstants.HASH_KEY, key, value);
            redisTemplate.expire(key, defaultTTL, TimeUnit.MINUTES);
            return ResponseEntity.ok("Value added successfully with default TTL");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding value to Redis");
        }
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<Object> getValue(@PathVariable String key) {
        try {
            Object value = redisTemplate.opsForHash().get(RedisConstants.HASH_KEY, key);
            return value != null ? ResponseEntity.ok(value) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving value from Redis");
        }
    }

    @DeleteMapping("/remove/{key}")
    public ResponseEntity<String> removeValue(@PathVariable String key) {
        try {
            redisTemplate.opsForHash().delete(RedisConstants.HASH_KEY, key);
            return ResponseEntity.ok("Value removed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error removing value from Redis");
        }
    }
}
