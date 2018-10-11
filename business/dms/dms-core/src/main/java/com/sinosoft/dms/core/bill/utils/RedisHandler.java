package com.sinosoft.dms.core.bill.utils;

import java.util.Set;

public interface RedisHandler {
	/** 
     * 得到value 
     *  
     * @param key 
     */  
    public Object getValue(String key) throws Exception;  
  
    /** 
     * 添加key value 
     *  
     * @param key 
     * @param value 
     */  
    public void setValue(String key, Object value) throws Exception;  
  
    /** 
     * 添加key value (字节)(序列化) 
     * SerializeUtil 
     * @param key 
     * @param value 
     */  
    public void setValue(byte[] key, byte[] value) throws Exception;  
  
    /** 
     * 添加key value 并且设置存活时间(byte) 
     *  
     * @param key 
     * @param value 
     * @param liveTime 
     */  
    public void setValue(byte[] key, byte[] value, long liveTime)  
            throws Exception;  
  
    /** 
     * 添加key value 并且设置存活时间 
     *  
     * @param key 
     * @param value 
     * @param liveTime 
     *            单位秒 
     */  
    public void setValue(String key, Object value, long liveTime)  
            throws Exception;  
  
    /** 
     * @param key 
     */  
    public void delValue(String... keys) throws Exception;  
  
    /** 
     * @param 获取所有匹配的key 
     * @return 
     */  
    public Set<String> getKeys(String key) throws Exception;  
  
    /** 
     * 清除缓存 
     *  
     * @throws Exception 
     */  
    public void clear() throws Exception;  
  
    /** 
     * 相同key叠加 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public long incr(String key) throws Exception;  
      
    /** 
     * 相同key叠加 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public long hincrby(String hashkey,String field,long incr) throws Exception;  
  
    /** 
     * 验证是否存在 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public boolean exists(String key) throws Exception;  
    /** 
     * 清空 
     * @return 
     * @throws Exception 
     */  
    public String flushDB() throws Exception;  
  
     /** 
     * 查看redis里有多少数据 
     */  
    public long dbSize() throws Exception;  
  
     /** 
     * 检查是否连接成功 
     *  
     * @return 
     */  
    public String ping() throws Exception;  
}
