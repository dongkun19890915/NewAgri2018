package com.sinosoft.gateway.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.netflix.zuul.context.RequestContext;

/**
 * Created by Jason on 2017/8/15.
 */
public class UrlLimiter implements Limiter{

    private static final Logger logger = LoggerFactory.getLogger(UrlLimiter.class);

    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    //@Autowired
    //private XDiamondConfig xDiamondConfig;

    private static final String BLOCKED_IP = "blockedip";
    private static final String LIMIT_COUNT = "limitCount";
    private static final String REQUEST_TIME = "requestTime";
    private static final String BLACK_LIST_TIME = "blackListTime";

    private int limitCount = 5;  //请求次数限制

    private int requestTime = 1;  //请求次数时限（秒）

    private int blackListTime = 7; //黑名单时长（天）

    /**
     * 通过请求次数来做限制
     */
    @Override
    public boolean needLimit(RequestContext context) {
        boolean result = false;
        HttpServletRequest request = context.getRequest();
        String url = request.getRequestURI();  //访问url
        String forwardedFor = context.getZuulRequestHeaders().get("x-forwarded-for");  //IP

        if(forwardedFor == null) {
            return false;
        }

        if(redisTemplate.hasKey(forwardedFor)) {
            //黑名单需要限制
            result = true;
            logger.info("[UrlLimiter:calculate] the ip is in blackList");

        }else {  //检查访问频次
            String key = forwardedFor + "_" + url;
            Long count = redisTemplate.opsForValue().increment(key, 1);

            if (count == 1) {
                requestTime = getConfigInt(REQUEST_TIME, 1);
                redisTemplate.expire(key, requestTime, TimeUnit.SECONDS);
            }

            limitCount = getConfigInt(LIMIT_COUNT, limitCount);

            if(count > limitCount) {
                result = true;
                logger.info("[UrlLimiter:calculate] the ip called too many times: " + key);
            }
        }

        return result;
    }

    /**
     * 从配置文件读取ip 批量加入黑名单
     * mhl 2017年3月9日
     */
    @PostConstruct
    public void batchAddBlacklist() {
        String blockedIps = getConfig(BLOCKED_IP);
        if(blockedIps == null || blockedIps.length() == 0) {
            logger.info("UrlLimiter | blockedIps is null or has no data");
            return;
        }
        String[] array = blockedIps.split(",");
        if(array.length > 0) {
            for (String string : array) {
                addBlacklist(string);
            }
        }

        logger.info("UrlLimiter | blockedIps successed");
    }

    public String getConfig(String key) {
        return null;
    }

    public int getConfigInt(String key, int defaultInt) {
        return defaultInt;
    }

    /**
     * 初始化配置 并且增加监听事件
     */
    private void init() {

    }

    /**
     * 手动添加黑名单
     * @param key
     * @return
     */
    public boolean addBlacklist(String key) {
        redisTemplate.opsForSet().add(key, key);

        String blackListTimeStr = getConfig(BLACK_LIST_TIME);
        if(blackListTimeStr != null) {
            blackListTime = Integer.valueOf(blackListTimeStr);
        }

        redisTemplate.expire(key, blackListTime, TimeUnit.DAYS);

        return true;
    }

    /**
     * 手动移除黑名单
     * @param key
     * @return
     */
    public boolean removeBlacklist(String key) {
        redisTemplate.delete(key);

        return true;
    }

    /**
     * 判断key是否在redis中
     * @param key
     * @return
     */
    public boolean inRedis(String key) {
        return redisTemplate.hasKey(key);
    }
}
