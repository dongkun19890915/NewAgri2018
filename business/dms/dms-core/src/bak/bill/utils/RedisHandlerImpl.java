package com.sinosoft.dms.core.bill.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("redisHandler")  
public class RedisHandlerImpl implements RedisHandler {
	/** log日志 */
    private static final Logger curr_logger = LoggerFactory.getLogger(RedisHandlerImpl.class);
    
  
    @Resource
    RedisTemplate<Serializable, Serializable> redisTemplate;  
    
    @Override  
    public Object getValue(final String key) {  
        return redisTemplate.execute(new RedisCallback<Object>() {  
  
            @Override  
            public Object doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                Object value = null;  
                try {  
  
                    byte[] obj = connection.get(key.getBytes());  
                    if (obj != null) {  
                        value = unserialize(obj);  
                    }  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl getValue "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return value;  
            }  
        });  
    }  
  
    @Override  
    public void setValue(final String key, final Object value) {  
        this.setValue(key.getBytes(), serialize(value), 0L);  
    }  
  
    @Override  
    public void setValue(final byte[] key, final byte[] value) {  
        this.setValue(key, value, 0L);  
  
    }  
  
    @Override  
    public void setValue(String key, Object value, long liveTime) {  
        this.setValue(key.getBytes(), serialize(value), liveTime);  
    }  
  
    @Override  
    public void setValue(final byte[] key, final byte[] value,  
            final long liveTime) {  
        redisTemplate.execute(new RedisCallback<Object>() {  
  
            @Override  
            public Object doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                try {  
                    connection.multi();  
                    connection.set(key, value);  
                    if (liveTime > 0) {  
                        connection.expire(key, liveTime);  
                    }  
                    connection.exec();  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl setValue "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return null;  
            }  
        });  
  
    }  
  
    @Override  
    public void delValue(final String... keys) {  
        redisTemplate.execute(new RedisCallback<Object>() {  
            @Override  
            public Object doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                try {  
                    connection.multi();  
                    for (String key : keys) {  
                        connection.del(key.getBytes());  
                          
                    }  
                    connection.exec();  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl delValue "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return null;  
            }  
        });  
    }  
  
    /** 
     * 搜索与key匹配的的所有的key 
     */  
    @Override  
    public Set<String> getKeys(final String key) {  
  
        return redisTemplate.execute(new RedisCallback<Set<String>>() {  
  
            @Override  
            public Set<String> doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                Set<String> result = new HashSet<String>();  
                try {  
                    Set<byte[]> keys = connection.keys(key.getBytes());  
                    if (keys != null && keys.size() != 0) {  
                        for (byte[] key : keys) {  
                            result.add((String) unserialize(key));  
                        }  
                    }  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl getKeys "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return result;  
            }  
        });  
    }  
  
    @Override  
    public void clear() {  
        redisTemplate.execute(new RedisCallback<Object>() {  
  
            @Override  
            public Object doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                try {  
                    Set<byte[]> keys = connection.keys("*".getBytes());  
                    connection.multi();  
                    for (byte[] key : keys) {  
                        connection.del(key);  
                          
                    }  
                    connection.exec();  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl clear "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return null;  
            }  
        });  
    }  
  
    @Override  
    public long incr(final String key) {  
  
        return redisTemplate.execute(new RedisCallback<Long>() {  
  
            @Override  
            public Long doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
  
                Long incr = 0L;  
                try {  
                    incr = connection.incr(key.getBytes());  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl incr "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return incr;  
            }  
        });  
    }  
  
    @Override  
    public boolean exists(final String key) {  
        return redisTemplate.execute(new RedisCallback<Boolean>() {  
  
            @Override  
            public Boolean doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                Boolean result = false;  
                try {  
                    result = connection.exists(key.getBytes());  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl exists "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return result;  
            }  
        });  
    }  
  
    @Override  
    public String flushDB() {  
        return redisTemplate.execute(new RedisCallback<String>() {  
            public String doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                connection.flushDb();  
                return "ok";  
            }  
        });  
    }  
  
    @Override  
    public long dbSize() {  
        return redisTemplate.execute(new RedisCallback<Long>() {  
            public Long doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                return connection.dbSize();  
            }  
        });  
    }  
  
    @Override  
    public String ping() {  
        return redisTemplate.execute(new RedisCallback<String>() {  
            public String doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                return connection.ping();  
            }  
        });  
    }  
  
    @Override  
    public long hincrby(final String hashkey,final String field, long incr)  
            throws Exception {  
        return redisTemplate.execute(new RedisCallback<Long>() {  
  
            @Override  
            public Long doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
  
                Long incr = 0L;  
                try {  
                    incr = connection.hIncrBy(hashkey.getBytes(), field.getBytes(), incr);  
                } catch (Exception e) {  
                    curr_logger  
                            .error("com.utils.redis.impl.RedisCommonDaoImpl hincrby "  
                                    + e);  
                    throw (DataAccessException)e;  
                }  
                return incr;  
            }  
        });  
    }  
    
    
    
    private byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}
}
