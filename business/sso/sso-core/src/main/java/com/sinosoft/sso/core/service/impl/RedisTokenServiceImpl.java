package com.sinosoft.sso.core.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheElement;
import org.springframework.data.redis.cache.RedisCacheKey;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sinosoft.sso.core.entity.TokenInfo;
import com.sinosoft.sso.core.service.TokenService;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @description 使用redis保存token信息
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:43:01
 */
@Service
public class RedisTokenServiceImpl implements TokenService,InitializingBean {
	
	private static final String cacheName = "tokenStore:";

	private RedisCache              redisCache;
	//10分钟超时时间
	private long EXPIRE=60*30;

	@Autowired
	private RedisCacheManager redisCacheManager;

	@Autowired
	private RedisTemplate redisTemplate;

//	private RedisTemplate redisTemplate;
//	@Autowired(required = false)
//	public void setRedisTemplate(RedisTemplate redisTemplate) {
//		RedisSerializer stringSerializer = new StringRedisSerializer();
//		redisTemplate.setKeySerializer(stringSerializer);
////		redisTemplate.setValueSerializer(stringSerializer);
////		redisTemplate.setHashKeySerializer(stringSerializer);
////		redisTemplate.setHashValueSerializer(stringSerializer);
//		this.redisTemplate = redisTemplate;
//	}

	//public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
	//	this.redisCacheManager = redisCacheManager;
	//}

	@Override
	public void saveToken(TokenInfo info) {
		String token = info.getToken();
		System.out.println("-token----"+cacheName+token+"----------");

		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		operations.set(cacheName+token, info,EXPIRE, TimeUnit.SECONDS);
//		operations.set(cacheName+token,info);
//		redisTemplate.expire(token, 1000L, TimeUnit.SECONDS);
//		if(info == null){
//			return;
//		}
//		String token = info.getToken();
//		if(StringUtils.isEmpty(token)){
//			return;
//		}
//		System.out.println("-token----"+token+"----------");
//		redisCache.put(token, info);

//		RedisCacheKey key=new RedisCacheKey(token);
//		RedisCacheElement element=new RedisCacheElement(key,info);
//		element.expireAfter(1000);
//		redisCache.put(element);
	}


	@Override
	public TokenInfo getToken(String token) {
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		TokenInfo	tokenInfo =(TokenInfo) operations.get(cacheName+token);
		return tokenInfo;

//		if(StringUtils.isEmpty(token)){
//			return null;
//		}
//		TokenInfo tokenInfo=redisCache.get(token, TokenInfo.class);
//		return tokenInfo;

	}

	@Override
	public boolean expireToken(String token){
		return redisTemplate.expire(cacheName+token, EXPIRE, TimeUnit.SECONDS);
	}

	@Override
	public void deleteToken(String token) {
		if(StringUtils.isEmpty(token)){
			return;
		}
		redisTemplate.delete(cacheName+token);
		//redisCache.evict(token);
	}

	@Override
	public void updateToken(TokenInfo info) {
		saveToken(info);		
	}

    @Override
    public void afterPropertiesSet()throws Exception{
//        redisCache =   (RedisCache)redisCacheManager.getCache(cacheName);
		//redisTemplate=(RedisTemplate) redisCacheManager.getCache(cacheName);
    }

}
