package com.sinosoft.dms.core.bill.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPoolConfig;

//@Configuration
public class JedisConfiguration {
	@Autowired
	JedisConfig redisConfig;
	@Bean
	public JedisConnectionFactory convertJedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(redisConfig.getHost());
		jedisConnectionFactory.setPort(redisConfig.getPort());
		try {
		jedisConnectionFactory.setPassword(redisConfig.getPassword());
		} catch (Exception e) {
		}
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		try {
			jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());
		} catch (Exception e) {
		}
		jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
		try {
			jedisPoolConfig.setMinIdle(redisConfig.getMinIdle());
		} catch (Exception e) {
		}
		jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWait());
		try {
			jedisPoolConfig.setTestOnBorrow(redisConfig.isTestOnBorrow());
		} catch (Exception e) {
		}
		try {
			jedisPoolConfig.setTestOnReturn(redisConfig.isTestOnReturn());
		} catch (Exception e) {
		}
		try {
			jedisPoolConfig.setTestWhileIdle(redisConfig.isTestWhileIdle());
		} catch (Exception e) {
		}

		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		return jedisConnectionFactory;
	}
}
