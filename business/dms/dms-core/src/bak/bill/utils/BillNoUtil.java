package com.sinosoft.dms.core.bill.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
/**
 * 单号生弄成工具类
 * @author yangqunwei@sinosoft.com.cn
 * @since 2016年9月17日 上午1:18:48
 */
@Service
public class BillNoUtil {
	@Autowired
	private RedisHandler redisHandler;
//  通过注解形式获取redis连接工厂这种方式放弃，工厂无法自动注入
//	private JedisConnectionFactory connectionFactory = null;
//	public void setConnectionFactory(JedisConnectionFactory connectionFactory) {
//		this.connectionFactory = connectionFactory;
//	}
	
	/**
	 * 根据业务类型和流水号位数生成业务号
	 * @param busType 业务类型
	 * @param length 流水号位数
	 * @return 业务单号
	 */
	public String getNo(String busType,int length){
		try {
//			JedisConnection jedisConnection = (JedisConnection) jedisConfiguration.convertJedisConnectionFactory().getConnection();
//			JedisConnection jedisConnection = (JedisConnection) connectionFactory.getConnection();
//			Jedis jedis = jedisConnection.getNativeConnection();
//			Long incrNo = jedis.incr(busType);
//			jedis.close();
			Long incrNo = redisHandler.incr(busType);
			return busType+transNumToString(incrNo, length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据业务类型和流水号位数生成业务号
	 * @param busType 业务类型
	 * @return 流水号
	 */
	public Long getSerialNo(String busType){
		try {
//			JedisConnection jedisConnection = (JedisConnection) connectionFactory.getConnection();
//			Jedis jedis = jedisConnection.getNativeConnection();
//			Long incrNo = jedis.incr(busType);	
//			jedis.close();
			Long incrNo = redisHandler.incr(busType);
			return incrNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 单号回收服务 系统异常时把单号收到
	 * @param busType
	 * @param busNo
	 */
	public void putNo(String busType,String busNo){
		//TODO 设计单号回收的服务
		System.err.println("业务类型:"+busType+"业务单号:"+busNo+",业务保存失败,待处理!");
	}
	
	/**
	 * 把传入的数字，转换成指定长度的字符串，前面补充0
	 * @param num
	 * @param length
	 * @return
	 */
	private static String transNumToString(Long num, int length) {
		String result = "" + num;
		while (true) {
			if (result.length() < length) {
				result = "0" + result;
			} else {
				break;
			}
		}
		return result;
	}
}
