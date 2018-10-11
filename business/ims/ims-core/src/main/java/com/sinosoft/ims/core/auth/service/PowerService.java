package com.sinosoft.ims.core.auth.service;


import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.auth.dto.CheckPowerPrpallResDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;


/**
* @description 权限管理服务接口
* @author hzhongkai
* @date 2016年9月22日下午5:06:26
*/
public interface PowerService {

	
	
	/**
	* @description 判断某个功能是否有权执行
	* @param PowerQueryConditionDto
	* @return ResponseDto
	* @author hzhongkai
	* @date 2016年9月25日下午3:37:48
	*/
    boolean checkPower(PowerConditionDto powerConditionDto, String cacheKey) ;
	
    /**
     * @description 承保系统获登录时校验业务权限，前端不用传险种代码
     * @param PowerConditionDto
     * @return ResponseDto
     * @throws Exception
     * @author libin
     * @date 2017年9月20日 上午10:33:15
     */
    CheckPowerPrpallResDto checkPowerPrpall(PowerConditionDto powerConditionDto, String cacheKey) ;
	/**
	* @description 检验给定的员工是否具有针对某些数据操作的权限(查询方式为本机构及同级机构及下级机构)
	* @param powerConditionDto
	* @param cacheKey缓存key
	* @return ResponseDto
	* @author yangqunwei
	* @date 2016年10月17日 10:59:48
	*/
    ResponseDto checkDataPower(PowerConditionDto powerConditionDto, String cacheKey);
	/**
	* @description 根据外部传入的信息获取查询条件附加权限
	* @param powerConditionDto
	* @param cacheKey 缓存key
	* @return String 附加的权限SQL语句
	* @author hzhongkai
	* @date 2016年9月25日下午3:38:20
	*/
    String addPower(PowerConditionDto powerConditionDto, String cacheKey) ;
    /**
	 * @description 获取可操作险种条件
	 * @param powerConditionDto
	 * @return String 附加的权限SQL语句
     * @author zkr07
     * @date 2016年10月14日下午2:52:34
     */
    String addRiskPower(PowerConditionDto powerConditionDto, String cacheKey) ;
    
    /**
     * @description 是否是超级用户
     * @param comCode 机构代码
     * @return userCode 用户代码
     * @throws Exception
     * @author libin
     * @date 2017年9月25日 上午10:47:30
     */
    boolean isSuperUser(String comCode, String userCode);

	/**
	 * 校验地址权限
	 * @author: 田健
	 * @date: 2018/2/22 16:49
	 * @param url 访问地址
	 * @return true或者false
	 */
    boolean checkURLPower(String url,String userCode)throws Exception;
}
