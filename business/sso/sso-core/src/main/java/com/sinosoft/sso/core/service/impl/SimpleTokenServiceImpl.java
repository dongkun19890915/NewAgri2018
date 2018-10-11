package com.sinosoft.sso.core.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.sso.core.entity.TokenInfo;
import com.sinosoft.sso.core.service.TokenService;

import java.lang.IllegalArgumentException;

public class SimpleTokenServiceImpl implements TokenService {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleTokenServiceImpl.class);
	
	/** 用于保存登陆票据 KEY:Token Value:UserName*/
	private static Map<String,TokenInfo> TOKEN_MAP = new HashMap<String, TokenInfo>();
	
	/** for test
	static {
		UserInfo user = new UserInfo();
		user.setUserCode("001");
		user.setUserName("Jason");
		TokenInfo info = new TokenInfo();
		info.setToken("0987654321");
		info.setUserInfo(user);
		TOKEN_MAP.put("0987654321", info);
	}
	*/
	
    //用于保存登陆票据 KEY:Token Value:NickName
    private static Map<String,String> NICKNAME_MAP = new HashMap<String, String>();
    
    //用于保存登陆时间，每次验证操作会刷新Token对应值，KEY:Token Value:time(Long)
    private static Map<String, Long> TIMER_MAP = new HashMap<String, Long>();
    
    //登陆过期时间，单位毫秒
    private static Long EXPIRE_TIME = 900000L;
    
	@Override
	public void saveToken(TokenInfo info) {
		if(info==null || info.getToken()==null || info.getToken().isEmpty()){
			throw new IllegalArgumentException("token不允许为空");
		}
		
		TOKEN_MAP.put(info.getToken(), info);
		NICKNAME_MAP.put(info.getToken(), info.getUserInfo().getUserName());

	}

	@Override
	public TokenInfo getToken(String token) {
		return TOKEN_MAP.get(token);
	}

	@Override
	public void deleteToken(String token) {
		TOKEN_MAP.remove(token);

	}
	
    /**
     * @Title:verifyToken 
     * @Description: 后台验证Token
     * @param token
     * @param inv
     * @return: String 返回类型
     * @throws
     */
    /*private String verifyToken(String token){
        JSONObject responseJson = new JSONObject();
        token = (token==null?"":token);
        token = token.replace(' ','+');
        logger.debug("Verify token : " + token);
        String loginName = this.getToken(token).getUserInfo().getUserName();
        String nickName = NICKNAME_MAP.get(token);
        logger.debug("Verify loginName : " + loginName);
        if(loginName!=null){
            if(!this.checkExpire(token)){
                responseJson.put("statusCode","200");
                responseJson.put("loginName",loginName);
                responseJson.put("nickName",nickName);
                return "@"+responseJson.toJSONString();
            }
        }
        responseJson.put("statusCode","500");
        responseJson.put("description","用户已失效");
        return "@"+responseJson.toJSONString();
    }*/
    
    @Override
	public boolean expireToken(String token){
			return false;
	}

    /**
     * @Title:checkExpire 
     * @Description:校验登陆是否过期
     * @param token
     * @return: boolean 返回类型
     * @throws
     */
    public boolean checkExpire(String token){
        logger.debug("-----------------------开始校验过期----------------------------");
        Long now = this.getTimerMark();
        Long mark = TIMER_MAP.get(token);
        if(mark != null ){
            Long gap = now - mark;
            logger.debug("now : " + now);
            logger.debug("mark : " + mark);
            logger.debug("gap : " + gap);
            logger.debug("expire : " + EXPIRE_TIME);
            if(gap >  EXPIRE_TIME){
                TOKEN_MAP.remove(token);
                TIMER_MAP.remove(token);
                return true;
            }else{
                TIMER_MAP.put(token, this.getTimerMark());
                return false;
            }
        }
        logger.debug("-----------------------结束校验过期----------------------------");
        return true;
    }
    
    
    /**
     * @Title:getTimerMark 
     * @Description:返回当前时间，单位毫秒
     * @return: Long 返回类型
     * @throws
     */
    private Long getTimerMark(){
        return Calendar.getInstance().getTimeInMillis(); 
    }

	@Override
	public void updateToken(TokenInfo info) {
		TOKEN_MAP.put(info.getToken(), info);
	}

}
